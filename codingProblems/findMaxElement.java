import java.util.Arrays;
import java.util.List;

public class findMaxElement {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 13,431,4132,342,1342,54,634);
        int max = list.stream().max(Integer :: compare).get();
        System.out.println(max);
    }
}
