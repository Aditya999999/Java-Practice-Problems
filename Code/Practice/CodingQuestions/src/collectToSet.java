import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class collectToSet {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,34,34,23,3432,64,8);
        nums.stream().map(x -> x + " ").collect(Collectors.toSet()).forEach(System.out::println);
    }
}
