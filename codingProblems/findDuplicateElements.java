import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class findDuplicateElements {
    public static void main(String[] args) {
        int[] list = {1,23,14,14,14,54,54,124,5231,14342};
        Set<Integer> set = new HashSet ();
        // filter those numbers which can't be added into the set
        Arrays.stream(list).filter(n -> !set.add(n)).forEach(System.out::println);
    }
}
