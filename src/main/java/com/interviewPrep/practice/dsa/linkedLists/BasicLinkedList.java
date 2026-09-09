package com.interviewPrep.practice.dsa.linkedLists;

public class BasicLinkedList {

    private ListNode head;

    public void addLast(ListNode node){

        if (head == null) {
            head = node;
            return;
        }

        ListNode current = head;
        while (current.getNext() != null){
            current = current.getNext();
        }

        current.setNext(node);
    }

    public void printList(){
        ListNode current = head;
        while (current != null){
            System.out.println(current.getValue());
            current = current.getNext();
        }
        System.out.println("null");
    }

    public void reverse(){
        ListNode previous = null;
        ListNode current = head;

        while (current != null){
            // save the original next node so that it would be used to point the next one to continue.
            // because during the process you change pointers so you need to know which one comes next.
            ListNode next = current.getNext();
            // here reversing happens or you change the pointer to point from the next to the previous.
            current.setNext(previous);

            // to continue the process the previous and current move one step forward.
            previous = current;
            current = next;
        }
        head = previous;
    }

    public boolean detectCycle(){
        ListNode slow = head;
        ListNode fast = head;

        // this guarantees if the one just before the last is not null.
        // and its ok if the last one is null.
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (slow==fast) return true;
        }
        return false;
    }

    public ListNode findMiddleNode(){
        // go until fast reaches final and slow is the mid point
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }
}
