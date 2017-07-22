package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class Mud {

    // public static void main(String...a){ -> o

    // public static void main(String.* a){ -> x

    // public static void main(String... a){ -> o

    // public static void main(String[]... a){ -> o

    // public static void main(String...[] a){ -> x

    public static void main(String args[]) {
        System.out.println("hi");
    }

}
