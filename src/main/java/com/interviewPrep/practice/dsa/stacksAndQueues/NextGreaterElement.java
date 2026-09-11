package com.interviewPrep.practice.dsa.stacksAndQueues;

import com.interviewPrep.practice.dsa.linkedLists.ListNode;

public class NextGreaterElement {

    ListNode stack;
    public int[] findNextGreaterElement(int[] input){
        for (int i = 0; i < input.length; i++) {
            ListNode newNode = new ListNode(i);
            while (stack!= null && input[i] > input[stack.getValue()]){
                input[stack.getValue()] = input[i];
                pop();
            }
            newNode.setNext(stack);
            stack = newNode;
        }
        while (stack != null){
            input[stack.getValue()] = -1;
            pop();
        }
        return input;
    }

    private void pop(){
        stack = stack.getNext();
    }
}
