package com.interviewPrep.practice.dsa.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

    public Integer getIndexOfFirstNonRepeatingChar(String input){
        Map<Character,Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (frequencyMap.containsKey(input.charAt(i)))
                frequencyMap.put(input.charAt(i), frequencyMap.get(input.charAt(i)) + 1);
            else frequencyMap.put(input.charAt(i), 1);
        }

        for (int i = 0; i < input.length(); i++) {
            if (frequencyMap.get(input.charAt(i)) == 1) return i;
        }
        return -1;
    }
}
