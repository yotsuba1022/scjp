package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
class X {
    public void foo() {
        System.out.print("X ");
    }
}


public class SubB extends X {
    public static void main(String[] args) {
        new SubB().foo();
    }

    public void foo() throws RuntimeException {
        super.foo();
        if (true)
            throw new RuntimeException();
        System.out.print("B ");
    }
}
