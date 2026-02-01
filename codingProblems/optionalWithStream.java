import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class optionalWithStream {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("Aditya", "Dubey");
        long result = str.stream().filter(String::isEmpty).count();
        System.out.println(result);

        str.stream().map(String::toLowerCase).forEach(System.out::println);
        Optional<String> out =str.stream().filter(x -> x.startsWith("A")).findFirst();
        System.out.println(out);
    }
}
