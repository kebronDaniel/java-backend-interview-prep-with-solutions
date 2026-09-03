package com.interviewPrep.practice.dsa.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public int[] getTwoSum(int[] input, int target){
        Map<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < input.length; i++) {
            int need = target - input[i];
            // like looking for the second pair in the map and if non register yourself there and move on.
            if (seen.containsKey(need)){
                return new int[]{seen.get(need), i};
            }
            seen.put(input[i], i);
        }
        throw new IllegalArgumentException("No solution");
    }
}
