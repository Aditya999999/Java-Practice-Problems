import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class convertIntoUpperCase {
    public static void main(String[] args) {
        String[] num = {"sd","re","gfg"};
        List<String> sortedList = Arrays.stream(num).map(s -> s.toUpperCase()).collect(Collectors.toList());
                //.forEach(System.out::println);
        System.out.println(sortedList);
    }
}
