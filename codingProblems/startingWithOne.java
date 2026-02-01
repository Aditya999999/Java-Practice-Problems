import java.util.Arrays;

public class startingWithOne {
    public static void main(String[] args) {
        int[] list = {1,23,14,54,54,124,5231,14342};
        Arrays.stream(list).mapToObj(s -> s+"").filter(x -> x.startsWith("1")).forEach(System.out::println);
    }
}
