package idv.carl.scjp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * @author Carl Lu
 */
public class MethodReferenceDemo {

    private static <P, R> List<R> map(List<P> list, Function<P, R> mapper) {
        List<R> mapped = new ArrayList<>();
        for (P element : list) {
            mapped.add(mapper.apply(element));
        }

        return mapped;
    }

    public static void main(String[] args) {
        List<String> names = Arrays.asList(args);
        List<Person> persons = map(names, Person::new);
        persons.forEach(System.out::println);
    }

}
