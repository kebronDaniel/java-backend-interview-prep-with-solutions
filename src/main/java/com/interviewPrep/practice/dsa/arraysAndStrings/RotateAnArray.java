package com.interviewPrep.practice.dsa.arraysAndStrings;

public class RotateAnArray {

    public int[] getRotatedArray(int[] input, int k){
        if (input == null || input.length == 0) throw new IllegalArgumentException("Array can't be null");
        // this help is the k value is > than the length we dont rotate that many times, we cut short.
        // if length is 7 and k = 10 its the same as rotating 3 times.
        k = k % input.length;
        if (k == 0) return input;
        // the following are the three steps to rotate the array
        reverseArray(input,0,input.length-1);
        reverseArray(input, 0, k-1);
        reverseArray(input, k,input.length-1);
        return input;
    }


    private void reverseArray(int[] input, int startIndex, int endIndex){

        while (startIndex < endIndex){
            int a = input[startIndex];
            input[startIndex] = input[endIndex];
            input[endIndex] = a;
            startIndex++;
            endIndex--;
        }
    }
}
