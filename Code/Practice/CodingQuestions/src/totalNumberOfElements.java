import java.util.*;

public class totalNumberOfElements {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(423,543,423,6534);
        long count = nums.stream().count();
        System.out.println(count);
    }
}
