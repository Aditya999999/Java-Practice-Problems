import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class countElementsInStringArrayList {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("ad","fds","gfg","ey", "ey");
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(String s : list){
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        System.out.println("HashMap"+hashMap);
        hashMap.values().stream().filter(x -> x>1).collect(Collectors.toList()).forEach(System.out::println);
        hashMap.entrySet().stream().filter(e -> e.getValue() > 1).forEach(x -> System.out.println("Count : "+x.getKey()));
        LinkedHashMap<String, Integer> linkedHashMap = new LinkedHashMap<>();
        for(String s : list){
            linkedHashMap.put(s, linkedHashMap.getOrDefault(s,0)+1);
        }
        System.out.println("LinkedHashMap: "+linkedHashMap);
        Map<String, Long> countMap = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(countMap);
    }
}
