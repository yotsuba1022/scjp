package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class Venus {
    public static void main(String[] args) {
        int[] x = {1, 2, 3};
        int y[] = {4, 5, 6};
        new Venus().go(x, y);
    }

    void go(int[]... z) {
        for (int[] a : z)
            System.out.print(a[0]);
    }
}
