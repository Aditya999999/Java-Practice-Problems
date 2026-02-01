import java.util.Arrays;
import java.util.List;

public class sortValues {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(3423,65,746,4353,4754,654);
        nums.stream().sorted().forEach(System.out::println);

    }
}
