package com.interviewPrep.practice.dsa.linkedLists;

public class ListNode {
    private int value;
    private ListNode next;

    public ListNode(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return value;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

}
