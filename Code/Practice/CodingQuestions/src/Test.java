public class Test {
    public static void main(String[] args) {
        int result = method(new int[]{4, 6, 1, 7, 2}, 8);
        System.out.println(result);
    }
    public static int method(int[] A, int u) {
        int pair_count = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length; j++) {
                if (A[i] + A[j] == u) {
                    pair_count++;
                }
            }
        }
        return pair_count;
    }
}
