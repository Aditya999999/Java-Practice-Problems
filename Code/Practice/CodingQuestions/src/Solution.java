import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1,3,4,6,7);
        Map<String, Integer> map= new HashMap<>();
        map.put("Apple", 1);
        map.put("Banana", 2);
        map.put("Cherry", 3);
        map.put("Apple", 4);
        System.out.println(map);
        nums.stream().filter(x -> x % 2 == 0).forEach(System.out::println);
    }
}
