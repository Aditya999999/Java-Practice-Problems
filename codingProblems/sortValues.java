import java.util.Arrays;
import java.util.List;

public class sortValues {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,34,543,756,867,234,76);
        list.stream().sorted().forEach(System.out::println);
    }
}
