package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
public class OverrideWhat {
    public static void main(String args[]) {
        Foo f = new Bar();
        f.addFive();
        System.out.println(f.a);
        System.out.println(f.getA());

        Bar b = new Bar();
        b.addFive();
        System.out.println(b.a);
        System.out.println(b.getA());
        System.out.println(b.getSuperA());
    }
}


class Foo {
    // f.a
    public int a = 3;

    public void addFive() {
        a += 3;
        System.out.print("f ");
    }

    public int getA() {
        return this.a;
    }
}


class Bar extends Foo {
    public int a = 8;

    // f.addFive();
    public void addFive() {
        this.a += 5;
        System.out.print("b ");
    }

    /*
     * If we didn't implement this method,
     * then the result of f.getA() will be the same as line 28.
     */
    public int getA() {
        return a;
    }

    public int getSuperA() {
        return super.a;
    }

}
