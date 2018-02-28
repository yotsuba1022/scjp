package idv.carl.scjp.foobar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Carl Lu
 */
public class FindReversedString {

    public static void main(String[] args) {
        String[] words = {"RADAR", "WARTER START", "MILK KLIM", "RESERVERED", "IWI"};
        List<String> results = Arrays.stream(words)
                .filter(word -> word.equals(new StringBuffer(word).reverse().toString()))
                .collect(Collectors.toList());
        System.out.println(results);
    }

}
