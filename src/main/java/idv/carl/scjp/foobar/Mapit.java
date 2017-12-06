package idv.carl.scjp.foobar;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Carl Lu
 */
public class Mapit {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<Integer>();
        Integer i1 = 45;
        Integer i2 = 46;
        set.add(i1);
        set.add(i1);
        set.add(i2);
        System.out.print(set.size() + " ");
        set.remove(i1);
        System.out.print(set.size() + " ");
        i2 = 47;
        set.remove(i2);
        System.out.print(set.size() + " ");
    }
}
