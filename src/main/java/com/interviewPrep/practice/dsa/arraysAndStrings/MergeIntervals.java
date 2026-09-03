package com.interviewPrep.practice.dsa.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    public int[][] merge(int[][] intervals){
        // you can also check the internal one but this suffices for this case.
        if (intervals == null) throw new IllegalArgumentException("input can't be null");

        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();

        for (int[] current : intervals){
            // you use the merged as a continuous container to compare the rest of the elements in the array.
            // so in the first iteration put the first element to start with.
            if (merged.isEmpty()){
                merged.add(current);
                continue;
            }
            // get the last from the merged and compare it with the current interval.
            int[] last = merged.getLast();
            // does the current start <= the last end -> if so there is an overlap
            if (current[0] <= last[last.length-1]){
                // take the max of the two end values to treat values like [1,10] [2,5] where by the second is contained by the first.
                last[last.length-1] = Math.max(last[last.length-1],current[current.length-1]);
            } else{
                merged.add(current);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
