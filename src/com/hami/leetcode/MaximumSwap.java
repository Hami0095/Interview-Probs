package com.hami.leetcode;
/*
 * Author: Mohammad Abdur Rehman Cheema
 * Date: 10/18/2024
 * 
 * PROBLEM => 
		You are given an integer num. You can swap two digits at most once to get the maximum valued number.
		
		Return the maximum valued number you can get.
		
		 
		
		Example 1:
		
		Input: num = 2736
		Output: 7236
		Explanation: Swap the number 2 and the number 7.
		Example 2:
		
		Input: num = 9973
		Output: 9973
		Explanation: No swap.
 * 
 * 
 * 
 * */
class MaximumSwap {
    public int maximumSwap(int num) {
        String numStr = Integer.toString(num);
        int[] digits = new int[numStr.length()];
        
        // Convert the number to an array of digits
        for (int i = 0; i < numStr.length(); i++) {
            digits[i] = numStr.charAt(i) - '0';
        }

        // Create a lastIndex array to track the last occurrence of each digit
        int[] lastIndex = new int[10];
        for (int i = 0; i < digits.length; i++) {
            lastIndex[digits[i]] = i;
        }

        // Step through each digit and try to find a larger digit to swap with
        for (int i = 0; i < digits.length; i++) {
            // Check from 9 to digits[i] + 1 to find a larger digit
            for (int d = 9; d > digits[i]; d--) {
                // If a larger digit exists and appears after the current digit
                if (lastIndex[d] > i) {
                    // Swap the current digit with the larger digit
                    int temp = digits[i];
                    digits[i] = digits[lastIndex[d]];
                    digits[lastIndex[d]] = temp;

                    // After one swap, we return the result
                    int res = 0;
                    for (int j = 0; j < digits.length; j++) {
                        res = res * 10 + digits[j];
                    }
                    return res;
                }
            }
        }

        // If no swap was made, return the original number
        return num;


        // String numStr = Integer.toString(num);
        // int[] digits = new int[numStr.length()];

        // // Convert numStr to an array of digits
        // for (int i = 0; i < numStr.length(); i++) {
        //     digits[i] = numStr.charAt(i) - '0';
        // }

        // // Convert int[] to Integer[] for sorting in descending order
        // Integer[] digitArray = Arrays.stream(digits).boxed().toArray(Integer[]::new);

        // // Sort in descending order
        // Arrays.sort(digitArray, Collections.reverseOrder());

        // int res = 0;
        // for (int j = 0; j < digits.length; j++) {
        //     res = res * 10 + digits[j];
        // }
        // return res;

    }
}
