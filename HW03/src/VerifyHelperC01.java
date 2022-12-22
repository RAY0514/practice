import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class VerifyHelperC01 extends IdVerifyHelper {

    public VerifyHelperC01(String fileName) {
        super(fileName);
    }

    public static void main(String[] args) throws Exception {
        VerifyHelperC01 verifyHelperC01 = new VerifyHelperC01("./src/idList.txt");
        System.out.println(verifyHelperC01.validate("./src/idList3.txt"));

    }

    @Override
    public List<VerifyResult> validate(String pathFileName) throws Exception {
        //step1 英文字母放進陣列
        insertCharacter();
        //step2 抓取檔案內容
        File file = new File(pathFileName);//檔案路徑
        BufferedReader obj = new BufferedReader(new FileReader(file));
        //step3 把內容放進list
        String string, line;
        List<String> fileDataList = new ArrayList<>();
        while ((string = obj.readLine()) != null) {
            line = string;
            fileDataList.add(line);
        }
        // step4 檢查身分證是否正確
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
                System.out.println("證件長度不為10: "+idNum);
            }else if (!idNum.matches("[A-Z]\\d{9}")) {
                    verifyResult.setVerifySuccess(false);
                    verifyResult.setMessage("證件格式錯誤");
                    System.out.println("證件格式錯誤:　"+idNum);
            } else {
                if (check(upperIdNum) == true) {
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

