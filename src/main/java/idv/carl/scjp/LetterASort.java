package idv.carl.scjp;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Carl Lu
 */
public class LetterASort {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("aAaA");
        strings.add("AaA");
        strings.add("aAa");
        strings.add("AAaa");
        Collections.sort(strings);
        for (String s : strings) {
            System.out.print(s + " ");
        }
    }
}
