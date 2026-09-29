package com.interviewPrep.practice.dsa.hashmapsAndSets;

import java.util.*;
// Track each prefix sum and the indexes where it occurred.
// At index i, any earlier index j with prefixSum[j] = currentSum - target
// produces a matching subarray from j + 1 through i.
public class SubArraySum {

    public List<int[]> getSubArrays(int[] input, int target){

        List<int[]> result = new ArrayList<>();

        // this tells the total number of arrays that needed to be returned at the end.
        int counter = 0;

        // prepare the two hashmaps
        // 1, current sum occurrence which starts with 0->1
        int currentSum = 0;
        int neededSum = 0;
        Map<Integer, Integer> currentSumOccurrenceMap = new HashMap<>();
        currentSumOccurrenceMap.put(currentSum,1);

        //2, Current sum with index hashmap which starts with 0 and -1 index
        Map<Integer,List<Integer>> currentSumIndexOccurrenceMap = new HashMap<>();
        currentSumIndexOccurrenceMap.put(currentSum,new ArrayList<>(List.of(-1)));

        for (int i = 0; i < input.length; i++){
            // first get the current sum and needed sum values.
            currentSum = currentSum + input[i];
            neededSum = currentSum - target;

            // check if the neededSum exists in the occurrence to update the counter.
            if (currentSumOccurrenceMap.get(neededSum) != null){
                counter = counter + currentSumOccurrenceMap.get(neededSum);

                var currentSumIndexList = currentSumIndexOccurrenceMap.getOrDefault(neededSum,null);
                if (currentSumIndexList != null){
                    for (int index: currentSumIndexList){
                        result.add(Arrays.copyOfRange(input, index + 1, i + 1));
                    }
                }
            }
            if (currentSumIndexOccurrenceMap.get(currentSum) != null){
                currentSumIndexOccurrenceMap.get(currentSum).add(i);
            } else {
                currentSumIndexOccurrenceMap.put(currentSum, new ArrayList<>(List.of(i)));
            }
            currentSumOccurrenceMap.put(currentSum,
                    currentSumOccurrenceMap.getOrDefault(currentSum,0) + 1);
        }

        // you can use the counter to check if the number of elements here and counter are the same.
        return result;

    }
}
