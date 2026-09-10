package com.interviewPrep.practice.dsa.stacksAndQueues;

import com.interviewPrep.practice.dsa.linkedLists.ListNode;

public class BasicQueue {

    private ListNode front;
    private ListNode tail;
    private int size;

    public void offer(int value){
        ListNode newNode = new ListNode(value);
        if (isEmpty()){
            front = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public int poll(){
        if (isEmpty()) throw new IllegalStateException("Can't poll an empty Queue");
        // if the queue has one node then tail should also be null.
        if (tail== front) tail = tail.getNext();
        int value = front.getValue();
        ListNode newHead = front.getNext();
        front = newHead;
        size--;
        return value;
    }

    public int peek(){
        if (isEmpty()) throw new IllegalStateException("Can't poll an empty Queue");
        int value = front.getValue();
        return value;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void showQueue(){
        if (isEmpty()) System.out.println("Queue is Empty");
        else {
            ListNode head = front;
            while (head != null){
                System.out.println(head.getValue());
                head = head.getNext();
            }
        }
    }

    public int getSize() {
        return size;
    }
}
