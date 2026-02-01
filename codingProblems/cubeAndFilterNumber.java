import java.util.Arrays;
import java.util.List;

public class cubeAndFilterNumber {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3,12,654,7465,868,365,190,43,542,342);
        list.stream().map(i -> i*i*i).filter(i -> i > 50).forEach(System.out::println);
    }
}
