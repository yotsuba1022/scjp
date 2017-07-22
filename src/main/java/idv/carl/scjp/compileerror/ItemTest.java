package idv.carl.scjp.compileerror;

/**
 * @author Carl Lu
 */
public class ItemTest {
    private final int id;

    public ItemTest(int id) {
        this.id = id;
    }

    public static void main(String[] args) {
        ItemTest fa = new ItemTest(42);
        fa.updateId(69);
        System.out.println(fa.id);
    }

    public void updateId(int newId) {
        // id = newId; -> can not assign a value to final variable.
    }
}
