import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

public class Subsequence {
    //{3, 10, 2, 1, 20}
    // 1. elements should be increasing order
    // 2. j = 0, i = 3  = {3}, {3, 10}, {3,10,2}, {3, 10,2,1} {3, 10, 2, 1, 20}, {3, 10, 20}
    //   j = 1, i = 10 = {10}, {10, 2}, {10, 2, 1}, {10, 2, 1, 20}
    //    j = 2, i = 2 = {2}, {2, 1}, {2, 1, 20}, {}
    // largest possible subsequence , where all the elements are in increasing order
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        array.add(30);
        array.add(10);
        array.add(40);
        array.add(33);
        array.add(2);

        List<Integer> result = possibleSequences(array);
        System.out.println(result);
    }

    static List<Integer> possibleSequences(List<Integer> A) {
        List<Integer> secondary = new ArrayList<>();
        for (int i = 0; i <= A.size() - 1; i++) {
            for (int j = i; j <= A.size() - 1; j++) {
                if (A.get(i) <= A.get(j)) {
                    secondary.add(A.get(j));
                }
            }
            break;
        }

        return secondary.stream().sorted().collect(Collectors.toList());
    }
}


