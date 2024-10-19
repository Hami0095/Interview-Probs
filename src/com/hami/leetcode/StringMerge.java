package com.hami.leetcode;

public class StringMerge {
	
//	PROBLEM=>
	
//	You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. 
//	If a string is longer than the other, append the additional letters onto the end of the merged string.
//	Return the merged string.
	
	public String mergeAlternately(String word1, String word2) {
        StringBuilder res = new StringBuilder();  
        int i = 0, j = 0;
          while (i < word1.length() && j < word2.length()) {
            res.append(word1.charAt(i++));  // Append character from word1 and increment index
            res.append(word2.charAt(j++));  // Append character from word2 and increment index
        }
        if (i < word1.length()) {
            res.append(word1.substring(i));  // Append the rest of word1
        }
        
        // If there are remaining characters in word2, append them
        if (j < word2.length()) {
            res.append(word2.substring(j));  // Append the rest of word2
        }
        return res.toString();
    }
}
