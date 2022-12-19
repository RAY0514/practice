import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IdVerifyHelper {



public static void main(String[] args)throws Exception {
    File doc = new File("C:\\Users\\Chen\\Desktop\\idList.txt  ");//檔案路徑


        BufferedReader obj = new BufferedReader(new FileReader(doc));

        String strng,line;
        List list=new ArrayList<>();

        while ((strng = obj.readLine()) != null) {
            System.out.println(strng);
            line = strng;
            //System.out.println("line ="+line);
            list.add(line);
            System.out.println(list);

        }


        Map<String,Integer> map=new HashMap<>();
        String EnglishAlphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i=0 ;i<EnglishAlphabet.length();i++){
           String x =String.valueOf( EnglishAlphabet.charAt(i));
            map.put(x,i+10);
        }
    System.out.println("map = " +map);



        String q="B123456";

    System.out.println("檢查第一個字母"+q.charAt(0));

    String x= String.valueOf(map.get( (String.valueOf( q.charAt(0)))));

    System.out.println("第一個字母是"+q.charAt(0)+"回傳"+x);

    String y= x.substring(0,1);
    String  z = x.substring(1,2);


    System.out.println("兩數相加="+Integer.valueOf(y).intValue() + Integer.valueOf(z).intValue());






    System.out.println("z=" +z);
    System.out.println("y=" +y);
    System.out.println(z+y);


    System.out.println("--------測試------------");
    Checksum(map,q);












    }




    public  static void Checksum(Map<String,Integer> map,String s){
        System.out.println("檢查第一個字母"+s.charAt(0));//拿到字母

        String x= String.valueOf(map.get( (String.valueOf( s.charAt(0)))));//拿到字母的數字

        System.out.println("第一個字母是"+s.charAt(0)+"回傳"+x);

        String z=x.substring(0,1);//拿到字母的第一個數字
        String y=x.substring(1,2);//拿到字母的第一個數字

        System.out.println("字母的第一個數字 = " + z + " 字母的第二個數字 = " + y);



    }

}
