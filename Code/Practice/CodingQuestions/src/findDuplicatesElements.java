import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findDuplicatesElements {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(23,5324,32,23,32,454,54);
        Set<Integer> set = new HashSet<>();
        nums.stream().filter(n -> !set.add(n)).forEach(System.out::println);
    }
}
