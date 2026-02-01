import java.util.*;
import java.util.stream.Collectors;

public class duplicateElements {
    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(10,15, 8, 48, 25, 98, 98, 32, 15);
        Set<Integer> set = new HashSet<>();
        // find duplicate elements
        myList.stream().filter(n -> !set.add(n)).forEach(System.out::println);
        // find first elements
        System.out.println(myList.stream().findFirst().get());
        // find total elements
        System.out.println(myList.stream().count());
        // find maximum value
        System.out.println(myList.stream().max(Integer::compare).get());
        // sort  the list in descending order
        List<Integer> seats = myList.stream().sorted().collect(Collectors.toList());
        System.out.println(seats);
        myList.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
    }
}
