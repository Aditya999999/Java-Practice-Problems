import java.util.Arrays;

public class evenNumbers {
    public static void main(String[] args) {
        int[] list = {10, 20, 13, 432,462, 443};
        for(int n : list){
            System.out.print(n + " ");
        }
        System.out.print("\n");
        Arrays.stream(list).filter(x -> x%2 == 0).forEach(System.out::println);
    }
}
