package com.interviewPrep.practice.dsa.sortingAndSearching;

public class BinarySearch {

    public int search(int[] input, int target){
        if (input == null) return -1;
        int startIndex = 0;
        int endIndex = input.length - 1;
        while (startIndex <= endIndex){
            int midIndex = (startIndex + endIndex) / 2;
            if (input[midIndex] == target) return midIndex;
            if (input[midIndex] < target) startIndex = midIndex + 1;
            else endIndex = midIndex - 1;
        }
        return -1;
    }
}
