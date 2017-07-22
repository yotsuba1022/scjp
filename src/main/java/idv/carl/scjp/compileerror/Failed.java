package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class Failed {
    public static void main(String[] args) {
        try {
            args = null;
            args[0] = "test";
            System.out.println(args[0]);
        } catch (Exception ex) {
            System.out.println("Exception");
        }
        // NPE has been caught already.
        // catch (NullPointerException npe) {
        // System.out.println("Null PointerException");
        // }
    }
}
