package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
public interface A111 {
    String s = "yo";

    public void method1();
}


interface B {
}


interface C extends A111, B {
    public void method1();

    public void method1(int x);
}
