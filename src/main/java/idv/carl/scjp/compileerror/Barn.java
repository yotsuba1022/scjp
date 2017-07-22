package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class Barn {
    public static void main(String[] args) {
        // new Barn.go("hi", 1);
        // new Barn.go("hi", "world", 2);
    }

    // Vararg parameter (String... y) must be the last in the list
    // public void go(String... y, int x) {
    // System.out.print(y[y.length - 1] + " ");
    // }
}
