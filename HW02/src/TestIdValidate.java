public class TestIdValidate {

    public static void main(String[] args) throws Exception {
        IdVerifyHelper idVerifyHelper=new IdVerifyHelper("./src/idList.txt");
        System.out.println(idVerifyHelper.validate("./src/idList2.txt"));
    }

}
