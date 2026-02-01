import java.util.Arrays;
import java.util.List;

public class findTotalNumberOfElements {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10,1,23,42,431,41);
        long count = list.stream().count();
        System.out.println(count);
    }
}
