import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC01 extends IdVerifyHelper {

    public VerifyHelperC01(String fileName) {
        super(fileName);
    }

    @Override
    public List<VerifyResult> validate(String pathFileName) throws Exception {
        //step1 英文字母放進陣列
        insertCharacter();
        //step2 把file內容放進list
        List<String> fileDataList = fileContentAddList(pathFileName);
        // step3 檢查身分證是否正確
        List<VerifyResult> verifyList = new ArrayList<>();
        for (int i = 0; i < fileDataList.size(); i++) {
            VerifyResult verifyResult = new VerifyResult();
            String idNum = fileDataList.get(i);//抓list內的每筆資料
            String upperIdNum = idNum.toUpperCase();
            verifyResult.setId(fileDataList.get(i));
            //判斷身分證格式，身份證字號是1個英文字母接著9個數字
            if (idNum.length() != 10) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setMessage("證件長度不為10");
                System.out.println("證件長度不為10: " + idNum);
            } else if (!idNum.matches("[A-Z]\\d{9}")) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setMessage("證件格式錯誤");
                System.out.println("證件格式錯誤:　" + idNum);
            } else {
                if (check(upperIdNum) == true && gender(idNum) == true) {
                    verifyResult.setVerifySuccess(true);
                    verifyResult.setMessage("驗證成功");
                } else {
                    verifyResult.setVerifySuccess(false);
                    verifyResult.setMessage("驗證失敗");
                }
            }
            verifyList.add(verifyResult);
        }
        return verifyList;
    }

}

