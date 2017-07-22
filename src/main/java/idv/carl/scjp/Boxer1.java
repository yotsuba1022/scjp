package idv.carl.scjp;

/**
 * @author Carl Lu
 */
public class Boxer1 {
    Integer i;
    int x;

    public Boxer1(int y) {
        x = i + y;
        System.out.println(x);
    }

    public static void main(String[] args) {
        new Boxer1(new Integer(4));
    }
}
