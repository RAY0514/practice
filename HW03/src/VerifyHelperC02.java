import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC02 extends IdVerifyHelper {

    public VerifyHelperC02(String fileName) {
        super(fileName);
    }

    public static void main(String[] args) throws Exception {
        VerifyHelperC02 verifyHelperC02 = new VerifyHelperC02("./src/idList.txt");
        System.out.println(verifyHelperC02.validate("./src/idList3.txt"));

    }

    @Override
    public List<VerifyResult> validate(String pathFileName) throws Exception {
        //step1 英文字母放進陣列
        insertCharacter();
        //step2 把file內容放進list
        List<String> fileDataList =fileContentAddList(pathFileName);
        // step3 檢查身分證是否正確
        List<VerifyResult> verifyList = new ArrayList<>();
        for (int i = 0; i < fileDataList.size(); i++) {
            VerifyResult verifyResult = new VerifyResult();
            String idNum = fileDataList.get(i);//抓list內的每筆資料
            String upperIdNum = idNum.toUpperCase();
            verifyResult.setId(fileDataList.get(i));
            //判斷身分證格式，身份證字號是1個英文字母接著9個數字
            System.out.println(upperIdNum.matches("[a-zA-Z0-9]\\."));
            System.out.println(upperIdNum);
            //判斷數字英文未完成
            if (upperIdNum.matches("[a-zA-Z0-9]") == true ) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setMessage("証號格式錯誤");
            } else if (!upperIdNum.matches("[a-zA-Z]\\d{9}")) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setMessage("格式錯誤");
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
