import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EvenNumbers {
    public static void main(String[] args) {
        int[] num = {2, 34, 345, 353, 647, 867};
        List<Integer> streamNum = Arrays.stream(num).boxed().filter(x -> x % 2 == 0).collect(Collectors.toList());
        System.out.println(streamNum);
    }
}
