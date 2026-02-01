import java.util.Arrays;
import java.util.List;

public class cubeAndFilter {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(12,432,54,354);
        nums.stream().map(i -> i*i*i).filter(integer -> integer > 50).forEach(System.out::println);
    }
}
