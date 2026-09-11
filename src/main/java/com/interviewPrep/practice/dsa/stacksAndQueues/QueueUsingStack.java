package com.interviewPrep.practice.dsa.stacksAndQueues;

import com.interviewPrep.practice.dsa.linkedLists.ListNode;

public class QueueUsingStack {

    private ListNode inputStack;
    private ListNode outputStack;
    private int inputStackSize;
    private int outputStackSize;

    public void offer(int value){
        ListNode newNode = new ListNode(value);
        if (inputStack==null) inputStack = newNode;
        else{
            newNode.setNext(inputStack);
            inputStack = newNode;
        }
        inputStackSize++;
    }

    public int poll(){
        if (isInputStackEmpty() && isOutputStackEmpty()) throw new IllegalStateException("can't poll empty queue");
        // first put everything in the input stack to the output stack if output is empty
        if (isOutputStackEmpty()) pollInternalStack();
        // then put pop the first item.
        int value = outputStack.getValue();
        outputStack = outputStack.getNext();
        outputStackSize--;
        return value;
    }

    public int peek(){
        if (isInputStackEmpty() && isOutputStackEmpty()) throw new IllegalStateException("can't poll empty queue");
        // first put everything in the input stack to the output stack if output is empty
        if (isOutputStackEmpty()) pollInternalStack();
        // then put pop the first item.
        int value = outputStack.getValue();
        return value;
    }

    private void pollInternalStack(){
        while (inputStack != null){
            var current = inputStack;
            var next = inputStack.getNext();
            current.setNext(outputStack);
            outputStack = current;
            outputStackSize++;
            inputStackSize--;
            inputStack = next;
        }
    }

    private boolean isInputStackEmpty(){
        return inputStackSize == 0;
    }

    private boolean isOutputStackEmpty(){
        return outputStackSize == 0;
    }
}
