package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class ThrowSomething {
    static void test() throws Error {
        if (true)
            throw new AssertionError();
        System.out.print("test ");
    }

    public static void main(String[] args) {
        try {
            test();
            // Will throw a Throwable (Error)
            // So the catch exception will not work.
        } catch (Exception ex) {
            System.out.print("exception ");
        }
        System.out.print("end ");
    }
}
