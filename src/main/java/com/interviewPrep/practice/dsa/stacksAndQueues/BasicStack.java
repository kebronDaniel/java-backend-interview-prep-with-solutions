package com.interviewPrep.practice.dsa.stacksAndQueues;

import com.interviewPrep.practice.dsa.linkedLists.ListNode;

public class BasicStack {

    private ListNode stack;
    private int size;

    public void push(int value){
        ListNode newNode = new ListNode(value);
        newNode.setNext(stack);
        stack = newNode;
        size++;
    }

    public int pop(){
        if (size == 0) throw new IllegalStateException("Can't pop from an empty stack");
        int value = stack.getValue();
        stack = stack.getNext();
        size--;
        return value;
    }

    public int peek(){
        if (size == 0) throw new IllegalStateException("Can't pop from an empty stack");
        return stack.getValue();
    }

    public boolean isEmpty(){
        return size != 0 ? false : true;
    }

    public void showStack(){
        if (isEmpty()) System.out.println("Stack is empty");
        else {
            ListNode current  = stack;
            while (current != null){
                System.out.println(current.getValue());
                current = current.getNext();
            }
        }
    }

    public int getSize() {
        return size;
    }
}
