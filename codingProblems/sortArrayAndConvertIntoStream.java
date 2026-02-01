import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class sortArrayAndConvertIntoStream {
    public static void main(String[] args) {
        int[] num = {12,423,1000, 543,654,746};
        IntStream sortedArray = Arrays.stream(num).sorted();
        sortedArray.forEach(s -> System.out.println(s + ""));
    }
}
