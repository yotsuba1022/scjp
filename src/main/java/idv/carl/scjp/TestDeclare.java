package idv.carl.scjp;

/**
 * @author Carl Lu
 */
interface DeclareStuff {
    public static final int EASY = 3;

    void doStuff(int t);
}


public class TestDeclare implements DeclareStuff {
    public static void main(String[] args) {
        int x = 5;
        new TestDeclare().doStuff(++x);
    }

    // This should be public
    public void doStuff(int s) {
        s += EASY + ++s;
        System.out.println("s " + s);
    }
}
