package com.interviewPrep.practice.dsa.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {

    public int getMaxNonRepeatingLength(String input){
        // this is to tell where the indexes of the last seen char where at.
        Map<Character, Integer> lastSeen = new HashMap<>();
        // the sliding window moves from left to right.
        // this means the right always moves forward (i) and the left adjusts its position or slides based on condition
        int left = 0;
        // keeps track of the latest max values of the sliding window.
        int maximumLength = 0;
        for (int right = 0; right < input.length(); right++) {
            char current = input.charAt(right);
            // check if the there is a duplicate and if the index of the duplicate is behind or in front of the left.
            // if its in front it means you need to move the left pointer pass that letter, because you dont want a duplicate.
            // if its behind it means the left pointer has already left it behind so no need to update left.
            // thus the movement of the left pointer following the right one makes it a sliding window.
            if (lastSeen.containsKey(current) && lastSeen.get(current) >= left) left = lastSeen.get(current) + 1;
            // in any case you want to save the letter and its current index
            lastSeen.put(current,right);
            int currentWindowLength = right - left + 1;
            // you keep checking what is the max, the one that I have now or what I had.
            maximumLength = Math.max(currentWindowLength, maximumLength);
        }
        return maximumLength;
    }
}
