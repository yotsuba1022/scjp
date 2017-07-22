package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
class Foo {
    private int x;

    public Foo(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}


class Gamma {
    static Foo fooBar(Foo foo) {
        foo = new Foo(100);
        return foo;
    }

    public static void main(String[] args) {
        Foo foo = new Foo(300);
        System.out.print(foo.getX() + "-");

        Foo fooFoo = fooBar(foo);
        System.out.print(foo.getX() + "-");
        System.out.print(fooFoo.getX() + "-");
        foo = fooBar(fooFoo);
        System.out.print(foo.getX() + "-");
        System.out.print(fooFoo.getX());
    }
}
