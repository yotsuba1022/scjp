package idv.carl.scjp.foobar;

/**
 * @author Carl Lu
 */
public class Spock {
    public static void main(String[] args) {

        /*
         * XOR Operator:
         * 
         * X Y Output
         * 0 0 0
         * 0 1 1
         * 1 0 1
         * 1 1 0
         * 
         */

        Long tail = 2000L;
        Long distance = 1999L;
        Long story = 1000L;
        if ((tail > distance) ^ ((story * 2) == tail))
            System.out.print("1");
        if ((distance + 1 != tail) ^ ((story * 2) == distance))
            System.out.print("2");
    }
}
