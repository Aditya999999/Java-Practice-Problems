import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class arrayElementsMatching {
    public int solution(int[]A, int L, int R){
        // collect all elements of A in a arraylist
        List<Integer> copyA = new ArrayList<>();
        for(int i = 0; i < A.length- 1; i++){
            copyA.add(A[i]);
        }
        System.out.println(copyA);
        List<Integer> generateNumbersList = new ArrayList<>();
        for (int j = L; j <= R; j++){
            generateNumbersList.add(j);
        }
        System.out.println(generateNumbersList);
        HashMap<Integer, Integer> hash = new HashMap<>();
        for(int m = 0; m < (long) generateNumbersList.size() ; m++){
            for(int n = 0; n < (long) copyA.size() - 1 - 1; n++){
                if(copyA.get(n) == generateNumbersList.get(m)){
                    hash.put(generateNumbersList.get(m), n);
                    //System.out.println(hash.get(generateNumbersList.get(n)));
                }

            }
        }
        //System.out.println(hash.size());
        return hash.get(4);
    }
    public static void main(String[] args) {
        arrayElementsMatching a = new arrayElementsMatching();
        System.out.println(a.solution(new int[]{3, 2, 11, 4, 11, 1, 1, 3, 2, 1}, 2, 6));
    }
}
