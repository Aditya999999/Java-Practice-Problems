import java.util.Arrays;
import java.util.List;

public class findFirstElement {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3423,4324,523,5435,435,423);
        nums.stream().findFirst().ifPresent(System.out::println);
    }
}
