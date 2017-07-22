package idv.carl.scjp;

/**
 * @author Carl Lu
 */
interface Foo2 {
    int bar();
}


public class Beta2 {

    public static void main(String[] argv) {
        new Beta2().testFoo();
    }

    public int fubar(Foo2 foo) {
        return foo.bar();
    }

    public void testFoo() {

        class A implements Foo2 {
            public int bar() {
                return 2;
            }
        }

        System.out.println(fubar(new A()));
    }

    class A implements Foo2 {
        public int bar() {
            return 1;
        }
    }
}
