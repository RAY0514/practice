import java.io.*;
import java.util.*;

public class IdVerifyHelper {

    public static int[] stringToIntArray = new int[26];//放輸入的字串
    public static int[] numberArray = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 32};//A-Z對應的數字
    public static char[] characterArray = new char[26];//A-Z
    public static String fileName = "./src/idList3.txt";

    public IdVerifyHelper(String fileName) {
        this.fileName = fileName;
    }

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
            System.out.println("第" + (i+1) + "筆資料性別為" + gender(idNum));
            String upperIdNum = idNum.toUpperCase();
            verifyResult.setId(fileDataList.get(i));
            //判斷身分證格式，身份證字號是1個英文字母接著9個數字
            if (!upperIdNum.matches("[a-zA-Z]\\d{9}")) {
                verifyResult.setVerifySuccess(false);
                verifyResult.setMessage("驗證失敗");
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

    public static boolean check(String id) {
        int index = 0;
        String inputString = id;//身分證字串放進來
        Character firstLetter = inputString.charAt(0);//抓出字串第一個英文
        String gender = String.valueOf(inputString.charAt(1));//抓出字串第二個英文
        for (int i = 1; i <= inputString.length() - 1; i++) {
            stringToIntArray[i] = (int) (inputString.charAt(i)) - 48;//把身分證字號放入stringToIntArray[]，inputString.charAt(i)裡面的是字元1，(int)(inputString.charAt(i))傳回ASCII，0的ASCII十進位是48所以抓到什麼數字轉成int -48
        }
        index = Arrays.binarySearch(characterArray, firstLetter);//找英文字母在characterArray中的第幾個index//Arrays.binarySearch(要搜索的數組,要索的值)
        int d0 = numberArray[index];//英文對應到的數字抓出來放入d0
        int x2 = (d0) % 10;//d0的個位數//除10取餘數
        int x1 = (int) Math.floor((d0) / 10);//d0的十位數//Math.floor取整數
        int result = (x1 * 1) + (9 * x2) + (8 * stringToIntArray[1]) + (7 * stringToIntArray[2]) + (6 * stringToIntArray[3]) + (5 * stringToIntArray[4]) + (4 * stringToIntArray[5]) + (3 * stringToIntArray[6]) + (2 * stringToIntArray[7]) + (stringToIntArray[8]);
        int checkCode = 10 - (result % 10);
        if (stringToIntArray[9] == checkCode || stringToIntArray[9] == 0) { //stringToIntArray[9]身分證的最後一碼為檢查碼
            return true;
        }
        return false;
    }

    public static void insertCharacter() {
        for (int i = 0; i <= 25; i++) {
            characterArray[i] = (char) (65 + i);//把英文字母放入字元陣列，強制轉型A->65
        }
    }

    public String gender(String gender) {
        String determine = String.valueOf(gender.charAt(1));//抓出字串第二個英文
        //性別判斷
        if (determine.equals("2")) {
            return "女性";
        } else if (determine.equals("1")) {
            return "男性";
        }
        return "未知";
    }

}