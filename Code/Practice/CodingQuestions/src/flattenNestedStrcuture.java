import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class flattenNestedStrcuture {
    public static void main(String[] args) {
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("Aditya", "Dubey"),
                Arrays.asList("Ishika", "Chhabra"),
                Arrays.asList("Anamaya", "Pandey"),
                Arrays.asList("Aditya", "Dubey")
        );

        Set<String> flatSet = nestedList.stream().flatMap(List::stream).collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(flatSet);

        Function<String, Integer> methodRef = String::length;
        System.out.println(methodRef.apply("Aditya"));

        Stream<Double> randoms = Stream.generate(Math::random).limit(5);
        System.out.println(randoms.collect(Collectors.toList()));
    }

}
