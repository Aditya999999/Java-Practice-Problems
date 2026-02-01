import java.util.*;

public class ifValuePresentTwice {
    public boolean containsDuplicate(List<Integer> list) {

        Set<Integer> set = new HashSet<>(list);
//        System.out.println(set);
        if(set.size() == list.size()){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> myList = Arrays.asList(123, 543, 543, 654, 342, 756, 432);
        ifValuePresentTwice valuePresentTwice = new ifValuePresentTwice();
        System.out.println(valuePresentTwice.containsDuplicate(myList));

    }
}
