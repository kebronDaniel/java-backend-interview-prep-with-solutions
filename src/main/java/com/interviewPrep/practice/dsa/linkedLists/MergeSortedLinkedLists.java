package com.interviewPrep.practice.dsa.linkedLists;

public class MergeSortedLinkedLists {

    public ListNode merge(ListNode firstList, ListNode secondList){

        // Assuming that they are sorted.

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode currentFirstNode = firstList;
        ListNode currentSecondNode = secondList;
        while (currentFirstNode != null && currentSecondNode != null){
            if (currentFirstNode.getValue() < currentSecondNode.getValue()) {
                tail.setNext(currentFirstNode);
                currentFirstNode = currentFirstNode.getNext();
            } else {
                tail.setNext(currentSecondNode);
                currentSecondNode = currentSecondNode.getNext();
            }
            tail = tail.getNext();
        }
        // check if the first is over or if it has remaining members append
        while (currentFirstNode != null) {
            tail.setNext(currentFirstNode);
            tail = tail.getNext();
            currentFirstNode = currentFirstNode.getNext();
        }
        // check if the second is over or if it still has members append
        while (currentSecondNode != null) {
            tail.setNext(currentSecondNode);
            tail = tail.getNext();
            currentSecondNode = currentSecondNode.getNext();
        }
        return dummy.getNext();
    }
}
