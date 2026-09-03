package com.interviewPrep.practice.dsa.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSums {

    public List<List<Integer>> getThreeSums(int[] input){

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(input);

        for (int i = 0; i < input.length - 2; i++) {

            if (i > 0 && input[i] == input[i-1]) continue;
            int left = i+1;
            int right = input.length - 1;

            while (left<right){
                int sum = input[i] + input[left] + input[right];
                if (sum == 0){
                    result.add((List.of(input[i], input[left], input[right])));
                    while (left < right && input[left] == input[left+1]){
                        // escape repeated number, this is possible b/ce the array is sorted.
                        left++;
                    }
                    while (right > left && input[right] == input[right - 1]){
                        // escape repeated number
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    // since its a sorted array if the sum is greater, then it means add (move the left side)
                    left++;
                } else {
                    // same for the right side, if its greater then move right or decrease to get close to 0.
                    right--;
                }
            }
        }
        return  result;
    }
}
