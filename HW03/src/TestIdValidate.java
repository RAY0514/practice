public class TestIdValidate {

    public static void main(String[] args) throws Exception {
        String fileName="./src/idList3.txt";
        IdVerifyHelper idVerifyHelper = new IdVerifyHelper(fileName);
        System.out.println("idVerifyHelper :" + idVerifyHelper.validate(fileName));
        System.out.println("-----------------");
        IdVerifyHelper idVerifyHelper1c1 = new VerifyHelperC01(fileName);
        System.out.println("idVerifyHelper1c1 : " + idVerifyHelper1c1.validate(fileName));
        System.out.println("------------------");
        IdVerifyHelper idVerifyHelper1c2 = new VerifyHelperC02(fileName);
        System.out.println("idVerifyHelper1c2 : " + idVerifyHelper1c2.validate(fileName));
        }
    }

