package com.aditya.ProgrammingQuestions;

public class pallindromeNumber {
    //    public static int[] convertNumbertoIntArray(int x){
//        String numberString = String.valueOf(x);
//        System.out.println(numberString);
//        int[] intArray = new int[numberString.length()];
//
//        for (int i = 0; i < numberString.length(); i++) {
//            intArray[i] = Character.getNumericValue(numberString.charAt(i));
//        }
//
//        return intArray;
//    }
    public static boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int reversed = 0;
        while(x > reversed){
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return x == reversed || x == reversed / 10;
    }

    public static void main(String[] args) {
        //convertNumbertoIntArray(54);
        System.out.println(isPalindrome(121));
    }
}

