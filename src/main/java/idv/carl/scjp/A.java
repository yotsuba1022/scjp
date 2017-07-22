package idv.carl.scjp;

/**
 * @author Carl Lu
 */
class A {
    public static void main(String args[]) {
        A a = new A();
        System.out.println(a.doit(4, 5));
        System.out.println(a.doit(4, 5, 6));
    }

    public String doit(int x, int y) {
        return "a";
    }

    public String doit(int... vals) {
        return "b";
    }
}
