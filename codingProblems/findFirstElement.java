import java.util.Arrays;

public class findFirstElement {
    public static void main(String[] args) {
        int[] numbers = {12, 34, 42,4323, 543};
        Arrays.stream(numbers).findFirst().ifPresent(System.out::println);
    }
}
