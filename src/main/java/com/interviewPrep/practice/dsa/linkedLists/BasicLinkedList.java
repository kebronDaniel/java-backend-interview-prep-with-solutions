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
}
