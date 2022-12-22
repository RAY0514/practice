public class TestIdValidate {

    public static void main(String[] args) throws Exception {
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper("./src/idList.txt");
        System.out.println("idVerifyHelper :" + idVerifyHelper.validate("./src/idList3.txt"));
        System.out.println("-----------------");
        IdVerifyHelper idVerifyHelper1c1 = new VerifyHelperC01("./src/idList3.txt");
        System.out.println("idVerifyHelper1c1 : " + idVerifyHelper1c1.validate("./src/idList3.txt"));
        System.out.println("------------------");
        IdVerifyHelper idVerifyHelper1c2 = new VerifyHelperC02("./src/idList3.txt");
        System.out.println("idVerifyHelper1c2 : " + idVerifyHelper1c2.validate("./src/idList3.txt"));

        }
    }

