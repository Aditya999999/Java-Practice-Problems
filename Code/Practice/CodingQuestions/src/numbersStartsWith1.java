import java.util.Arrays;
import java.util.List;

public class numbersStartsWith1 {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(12,432,54312,13,143,12342);
        nums.stream().map(i -> i + "").filter(i -> i.startsWith("1")).forEach(System.out::println);
    }
}
