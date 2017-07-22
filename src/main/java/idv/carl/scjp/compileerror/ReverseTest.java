package idv.carl.scjp.compileerror;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Carl Lu
 */
public class ReverseTest {

    public static Iterator reverse(List list) {
        Collections.reverse(list);
        return list.iterator();
    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("1");
        list.add("2");
        list.add("3");
        // foreach not applicable to type java.util.Iterator
        // for(Object obj : reverse(list))
        // System.out.print(obj + ", ");
    }
}
