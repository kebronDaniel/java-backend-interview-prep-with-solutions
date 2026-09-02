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
                        left++;
                    }
                    while (right > left && input[right] == input[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return  result;
    }
}
