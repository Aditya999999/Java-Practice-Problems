public class Solution {
    public int solution(String S) {
        int n = S.length();
        int count = 0;

        // Initialize counters for 'x' and 'y' in the left part
        int leftX = 0, leftY = 0;

        // Initialize counters for 'x' and 'y' in the right part
        int rightX = 0, rightY = 0;

        // Calculate the counts for the right part initially
        for (char c : S.toCharArray()) {
            if (c == 'x') rightX++;
            if (c == 'y') rightY++;
        }

        // Iterate through the string to check each split point
        for (int i = 0; i < n - 1; i++) {
            // Update the left part counters
            if (S.charAt(i) == 'x') {
                leftX++;
                rightX--;
            } else if (S.charAt(i) == 'y') {
                leftY++;
                rightY--;
            }

            // Check if the split satisfies the condition
            if (leftX == leftY || rightX == rightY) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("ayxbx"));  // Output: 3
    }
}
