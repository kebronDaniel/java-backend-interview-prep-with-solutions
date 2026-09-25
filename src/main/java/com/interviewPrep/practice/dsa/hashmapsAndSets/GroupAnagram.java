package com.interviewPrep.practice.dsa.hashmapsAndSets;

import java.util.*;

public class GroupAnagram {

    public List<List<String>> group(List<String> input){

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String word: input){
            var lowerCase = word.toLowerCase();
            // first order the character of the word, that would be used as a key
            char[] chars = lowerCase.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (anagramMap.get(key) != null) {
                anagramMap.get(key).add(word);
                continue;
            }
            anagramMap.put(key, new ArrayList<>(List.of(word)));
        }
        return new ArrayList<>(anagramMap.values());
    }
}
