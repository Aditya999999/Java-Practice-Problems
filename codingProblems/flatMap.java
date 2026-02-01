import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class flatMap {
    public static void main(String[] args) {
        List<List<String>> list = Arrays.asList(Arrays.asList("a", "b"),
                Arrays.asList("c", "d"),
                Arrays.asList("e", "f"));
        // Flatten the list of lists
        List<String> flatList = list.stream().flatMap(Collection::stream).toList();
        System.out.println(flatList);
    }
}
