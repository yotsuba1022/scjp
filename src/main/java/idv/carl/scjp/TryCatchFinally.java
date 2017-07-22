package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class TryCatchFinally {

    public static void main(String args[]) {
        System.out.println(case1());
    }

    public static String case1() {
        try {
            if (true) {
                throw new RuntimeException();
            }
            return "try";
        } catch (Exception e) {
            return "catch";
        } finally {
            return "finally";
        }
    }
}
