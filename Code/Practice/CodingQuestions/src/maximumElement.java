import java.util.Arrays;
import java.util.List;

public class maximumElement {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(342, 534,6546,4353);
        int max = nums.stream().max(Integer::compare).get();
        System.out.println(max);
    }
}
