import java.util.Arrays;
import java.util.List;

public class filteringElements {
    public static void main(String[] args) {
        List<String> str = Arrays.asList("aditya", "dubey", "");
        long count = str.stream().filter(String::isEmpty).count();
        System.out.println(count);

    }
}
