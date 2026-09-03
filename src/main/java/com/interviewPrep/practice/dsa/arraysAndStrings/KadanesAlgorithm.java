package com.interviewPrep.practice.dsa.arraysAndStrings;

import java.util.Arrays;

// Max sub array
public class KadanesAlgorithm {

    public int[] getMaxSubArray(int[] input){
        int current = input[0];
        int best = input[0];
        int startPosition = 0;
        int bestStartPosition = 0;
        int bestEndPosition = 0;

        for (int i = 1; i < input.length; i++) {
            // current always grows, either by extension or taking the next best value.
            // if the value at the current position is greater than the sum. you start over
            if (input[i] > current + input[i]){
                current = input[i];
                startPosition = i;
            } else {
                // if adding to the existing value is better than you keep extending.
                current = current + input[i];
            }
            // in any of the above case the current has now grown, either taking new value(start over) or extension.
            // now it would be greater to best so the best changes.
            // but if its through extension the starting position doesn't change thus the best starting position too is unchanged,
            // only the best end position grows with the index
            // but if it was a start over then the best starting position would also change.
            if (current > best){
                best = current;
                bestStartPosition = startPosition;
                bestEndPosition = i;
            }
        }
        return Arrays.copyOfRange(input, bestStartPosition, bestEndPosition + 1);
    }
}
