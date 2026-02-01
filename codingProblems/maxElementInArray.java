import java.util.Arrays;
import java.util.OptionalInt;

public class maxElementInArray {
    public static void main(String[] args) {
        int[] num = {12, 534,2423,756,756,3432};
        OptionalInt max = Arrays.stream(num).max();
        System.out.println(max);
    }
}
