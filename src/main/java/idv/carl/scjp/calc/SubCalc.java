package idv.carl.scjp.calc;

/**
 * @author Carl Lu
 */
public class SubCalc extends SuperCalc {
    public static int multiply(int a, int b) {
        // super cannot be referenced from a static context
        // int c = super.multiply(a, b);
        // return c;
        return 1;
    }
}
