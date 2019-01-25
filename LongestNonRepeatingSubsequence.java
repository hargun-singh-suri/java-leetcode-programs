import sun.nio.cs.ext.MacThai;

import java.util.HashSet;

public class LongestNonRepeatingSubsequence {
    public static void main(String args[]) {
        LongestNonRepeatingSubsequence obj = new LongestNonRepeatingSubsequence();
        String s = "pwwkew";
        int longestSubString = obj.lengthOfLongestSubstring(s);
        System.out.println("Max length of substring " + longestSubString);
    }

    public int lengthOfLongestSubstring(String s) {
        //This variable will maintain length of the longest non repeating subsequence
        int maxLength = 0;
        //This DS will maintain the character in string to identify the repeating once
        HashSet<Character> chars = new HashSet<Character>();
        //First Pointer which will only increment if there is any repeating character
        int i = 0;
        //Second Pointer which will maintain the characters in Hash set
        int j = 0;

        //Parse the string for all characters this will give you O(n) Time complexity
        while (j < s.length()) {
            /*-Check if character exist in your set or not if not exist then add the character to set.
             -Increase the length of your second pointer
             -Check the max length from pointer i to pointer j till this point and assign to max length if greater
             -If character exists then increase the value of i and remove the existing character pointed by i from string
             because this string can never be longest*/
            if (!chars.contains(s.charAt(j))) {
                chars.add(s.charAt(j));
                j++;
                maxLength = Math.max(maxLength, j - i);
            } else {
                chars.remove(s.charAt(i));
                i++;
            }
        }
        return maxLength;
    }
}


/*Problem statement : https://leetcode.com/problems/longest-substring-without-repeating-characters/*/