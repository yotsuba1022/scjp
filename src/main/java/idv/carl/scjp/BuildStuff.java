package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class BuildStuff {
    public static void main(String[] args) {
        Boolean test = new Boolean(true);
        Integer x = 343;
        Integer y = new BuildStuff().go(test, x);
        System.out.println(y);
    }

    int go(Boolean b, int i) {
        if (b)
            return (i / 7);
        return (i / 49);
    }
}
