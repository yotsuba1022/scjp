package idv.carl.scjp;

/**
 * @author Carl Lu
 */
class TestA {
    public void start() {
        System.out.println("TestA");
    }
}


class TestB extends TestA {
    public static void main(String[] args) {
        // Casting new TestB() to TestA is redundant
        ((TestA) new TestB()).start();
    }

    public void start() {
        System.out.println("TestB");
    }
}
