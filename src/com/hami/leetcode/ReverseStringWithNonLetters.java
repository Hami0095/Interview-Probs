package com.hami.leetcode;

public class ReverseStringWithNonLetters {

    // Given a string S, return the reverse string where all characters 
    // that are not letters stay in the same place and all letters reverse in their positions.

    String reverseStringWithNonLetters(String str) {
        char[] characters = str.toCharArray();
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (!Character.isLetter(characters[left])) {
                left++;
            } else if (!Character.isLetter(characters[right])) {
                right--;
            } else {
                // Swap the letters
                char temp = characters[left];
                characters[left] = characters[right];
                characters[right] = temp;
                left++;
                right--;
            }
        }
        
        return new String(characters); // Corrected: converting char array back to a string
    }

    public static void main(String[] args) {
        ReverseStringWithNonLetters solution = new ReverseStringWithNonLetters();
        System.out.println(solution.reverseStringWithNonLetters("ab-cd")); // Output: dc-ba
        System.out.println(solution.reverseStringWithNonLetters("a-bC-dEf=ghlj!!")); // Output: j-lh-gfE=dCba!!
    }
}
