package com.interviewPrep.practice.dsa.arraysAndStrings;

public class ValidAnagrams {

    public boolean isValidAnagram(String firstWord, String secondWord){
        if (firstWord.length() != secondWord.length()) return false;

        int[] charCounts = new int[26];
        for (int i = 0; i < firstWord.length(); i++) {
            char firstChar = firstWord.charAt(i);
            char secondChar = secondWord.charAt(i);

            int firstCharPosition = firstChar - 'a';
            charCounts[firstCharPosition]++;

            int secondCharPosition = secondChar - 'a';
            charCounts[secondCharPosition]--;
        }
        for (Integer counter: charCounts){
            if (counter!=0) return false;
        }
        return true;
    }
}
