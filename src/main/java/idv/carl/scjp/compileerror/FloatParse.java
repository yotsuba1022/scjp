package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class FloatParse {

    public static void parse(String str) {
        try {
            float f = Float.parseFloat(str);
        } catch (NumberFormatException nfe) {
            // f = 0; -> cannot resolve f
        } finally {
            // System.out.println(f);
        }
    }

    public static void main(String[] args) {
        parse("invalid");
    }
}
