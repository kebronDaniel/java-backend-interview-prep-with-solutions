package com.interviewPrep.practice.dsa.hashmapsAndSets;

import java.util.*;
import java.util.stream.Collectors;

public class TopkFrequentElements {

    public List<Integer> getFrequentElements(int[] input, int target){

        Map<Integer, Integer> numFrequency = new HashMap<>();
        // the queue uses the comparator when adding new element thus they are always ordered from small to big.
        Queue<Integer> result = new PriorityQueue<>
                ((first, second) -> Integer.compare(numFrequency.get(first),numFrequency.get(second)));

        for (int num:input){
            if (numFrequency.get(num) != null) numFrequency.put(num,numFrequency.get(num) + 1);
            else numFrequency.put(num,1);
        }

        for (int key: numFrequency.keySet()){
            result.add(key);
            // later you just need to remove the tip of the queue which is the smallest.
            if (result.size() > target){
                result.poll();
            }
        }

        return result.stream().collect(Collectors.toList());
    }
}
