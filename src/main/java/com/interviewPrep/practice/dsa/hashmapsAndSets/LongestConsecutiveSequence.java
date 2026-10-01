package com.interviewPrep.practice.dsa.hashmapsAndSets;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

    public int getLengthOfLongestConsecutiveSequence(int[] input){
        // change it to set
        Set<Integer> inputSet = Arrays.stream(input).boxed().collect(Collectors.toSet());
        int maxCount = 0;
        for (Integer num: inputSet){
            int counter = 0;
            // if there is a number less than this it means you can't start with this.
            if (inputSet.contains(num - 1)) continue;
            counter++;
            // keep moving forward until the sequence ends.
            while (inputSet.contains(num + 1)){
                counter++;
                num = num + 1;
            }
            maxCount = Math.max(counter, maxCount);
        }
        return maxCount;
    }
}
