import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class IdVerifyHelper {
    static int[] stringToIntArray = new int[26];//放輸入的字串
    static int[] numberArray = {10, 11, 12, 13, 14, 15, 16, 17, 34, 18, 19, 20, 21, 22, 35, 23, 24, 25, 26, 27, 28, 29, 32, 30, 31, 32};//A-Z對應的數字
    static char[] characterArray = new char[26];//A-Z

    public static void main(String[] args) throws Exception {
        //step1 英文字母放進陣列
        insertCharacter();

        //step2 抓取檔案內容
        File doc = new File("./src/idList.txt");//檔案路徑
        BufferedReader obj = new BufferedReader(new FileReader(doc));

        //step3 把內容放進list
        String string, line;
        List list = new ArrayList<>();
        while ((string = obj.readLine()) != null) {
            line = string;
            list.add(line);
        }

        // step4 檢查身分證是否正確
        for (int i = 0; i < list.size(); i++) {
            String a = (String) list.get(i);
            String b = a.toUpperCase();
            System.out.println("===========您輸入的身分證字號" + list.get(i) + "=========");
            if (check(b) == true) {
                System.out.println("====驗證成功====");
            } else {
                System.out.println("====驗證失敗====");
            }
        }
    }

        static boolean check (String a){
            int index = 0;
            String inputString = a;//身分證字串放進來
            Character firstLetter = inputString.charAt(0);//抓出字串第一個英文
            for (int i = 1; i <= inputString.length() - 1; i++) {
                stringToIntArray[i] = (int) (inputString.charAt(i)) - 48;//把身分證字號放入stringToIntArray[]，inputString.charAt(i)裡面的是字元1，(int)(inputString.charAt(i))傳回ASCII，0的ASCII十進位是48所以抓到什麼數字轉成int -48
            }
            index = Arrays.binarySearch(characterArray, firstLetter);//找英文字母在characterArray中的第幾個index//Arrays.binarySearch(要搜索的數組,要索的值)
            int d0 = numberArray[index];//英文對應到的數字抓出來放入d0
            int x2 = (d0) % 10;//d0的個位數//除10取餘數
            int x1 = (int) Math.floor((d0) / 10);//d0的十位數//Math.floor取整數
            int result = (x1 * 1) + (9 * x2) + (8 * stringToIntArray[1]) + (7 * stringToIntArray[2]) + (6 * stringToIntArray[3]) + (5 * stringToIntArray[4]) + (4 * stringToIntArray[5]) + (3 * stringToIntArray[6]) + (2 * stringToIntArray[7]) + (stringToIntArray[8]);
            int checkCode = 10 - (result % 10);
            if (stringToIntArray[9] == checkCode || stringToIntArray[9]==0) { //stringToIntArray[9]身分證的最後一碼為檢查碼
                return true;
            }
             return false;
        }

        static void insertCharacter() {
            for (int i = 0; i <= 25; i++) {
                characterArray[i] = (char) (65 + i);//把英文字母放入字元陣列，強制轉型A->65
            }
        }

    }