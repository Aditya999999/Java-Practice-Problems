import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class valuePresentAtLeastTwice {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(234,5435,6546,43534,234);
        Set<Integer> set = new HashSet<>(nums);
        System.out.println(set);
        if(set.size() != nums.size()){
            System.out.println("False");;
        }else {
            System.out.println("True");
        }
    }
}
