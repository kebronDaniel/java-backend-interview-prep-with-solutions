package com.interviewPrep.practice.dsa.stacksAndQueues;

import com.interviewPrep.practice.dsa.linkedLists.ListNode;

public class MinStack {

    private ListNode stack;
    private ListNode minStack;
    private int minStackSize;
    private int size;

    public void push(int value){
        ListNode newNode = new ListNode(value);
        // Critical: pass another instance than the one you use for here (newNode)
        // assume the main has 4,2,5 and 1 is added now so its 1,4,2,5
        // in the minStack its 2,5
        // now the min would change, using pushToMinStack, the newNode to 1,2,5 and 4 is lost.
        // thus we need a separate instance and process that inside pushToMinStack.
        var head = new ListNode(newNode.getValue());
        if (isEmpty()) stack = newNode;
        else {
            newNode.setNext(stack);
            stack = newNode;
        }
        pushToMinStack(head);
        size++;
    }

    public int pop(){
        if (isEmpty()) throw new IllegalStateException("Can't pop an empty stack");
        popFromMinStack();
        int value = stack.getValue();
        stack = stack.getNext();
        size--;
        return value;
    }

    private void pushToMinStack(ListNode node){
        if (isMinStackEmpty()) {
            minStack = node;
            minStackSize++;
            return;
        }
        if (node.getValue() <= minStack.getValue()){
            node.setNext(minStack);
            minStack = node;
            minStackSize++;
        }
    }

    private void popFromMinStack(){
        if (!isMinStackEmpty()){
            if (stack.getValue() == minStack.getValue()){
                minStack = minStack.getNext();
                minStackSize--;
            }
        }
    }

    public int getMin(){
        if (isMinStackEmpty()) throw new IllegalStateException("No min found");
        return minStack.getValue();
    }

    private boolean isMinStackEmpty(){
        return minStackSize == 0;
    }

    public boolean isEmpty(){
        return size==0;
    }
}
