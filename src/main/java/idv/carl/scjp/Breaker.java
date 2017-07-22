package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class Breaker {
    static String o = "";

    public static void main(String[] args) {
        z: o = o + 2;
        for (int x = 3; x < 8; x++) {
            if (x == 4)
                break;
            if (x == 6)
                // break z; -> This will cause error:undefined label
                o = o + x;
        }
        System.out.println(o);

        /*
         * As described in http://docs.oracle.com/javase/specs/jls/se7/html/jls-14.html#jls-14.7 ,
         * "The scope of a label of a labeled statement is the immediately contained Statement."
         * Java programming language has no goto statement!!
         * So the solution should looks like this:
         */
        wtf: {
            o = o + 2;
            for (int x = 3; x < 8; x++) {
                if (x == 4)
                    break;
                if (x == 6)
                    break wtf; // leave wtf loop
                o = o + x;
            }
        }
        System.out.println(o);
    }
}
