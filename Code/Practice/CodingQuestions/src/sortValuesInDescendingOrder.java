import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class sortValuesInDescendingOrder {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(324,5423,1323,53244,3423542);
        nums.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
