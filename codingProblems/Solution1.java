class Solution1 {
    public String solution(int N) {
        // Total number of lowercase letters
        int totalLetters = 26;

        // Find the largest number of unique letters we can use such that each appears an equal number of times
        int numUniqueLetters = Math.min(N, totalLetters);

        // Adjust numUniqueLetters to ensure N is divisible by it
        while (N % numUniqueLetters != 0) {
            numUniqueLetters--;
        }

        // Generate the required string
        StringBuilder result = new StringBuilder(N);
        int repeats = N / numUniqueLetters;

        for (int i = 0; i < numUniqueLetters; i++) {
            char letter = (char) ('a' + i);
            for (int j = 0; j < repeats; j++) {
                result.append(letter);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        System.out.println(sol.solution(3));  // Example output: "abc"
        System.out.println(sol.solution(5));  // Example output: "abcde"
        System.out.println(sol.solution(30)); // Example output: "aabbccddeeffgghhiijjkkllmmnnoo"
    }
}
