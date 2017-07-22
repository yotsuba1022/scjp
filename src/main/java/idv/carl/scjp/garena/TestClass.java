package idv.carl.scjp.garena;

/**
 * @author Carl Lu
 */
public class TestClass {

    public static void main(String args[]) {
        A a = new A();
        a.m1(); // method 1 in A

        /*
         * Compile error:
         * Incompatible types
         * 
         * Should change to
         * B b2 = (B) new A();
         */
        // B b2 = new A();
        // b2.m1();

        A b1 = new B();
        b1.m1(); // method 1 in B
        b1.m3(); // method 3 in A
        /*
         * Compile error:
         * Cannot resolve method 'm2()'
         *
         * -> From the point of A, class A doesn't know method m2().
         */
        // b1.m2();
    }

}
