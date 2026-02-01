import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class sortArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 6, 1);
        list.stream().sorted().collect(Collectors.toList()).forEach(System.out :: println);

    }
}
