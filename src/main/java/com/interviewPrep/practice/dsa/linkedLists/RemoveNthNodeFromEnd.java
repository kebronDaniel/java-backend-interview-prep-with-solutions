package com.interviewPrep.practice.dsa.linkedLists;

public class RemoveNthNodeFromEnd {

    public ListNode remove(ListNode node, int position){

        ListNode dummy = new ListNode(0);
        dummy.setNext(node);

        ListNode slow = dummy;
        ListNode fast = dummy;

        int fastStartPosition = position + 1;
        for (int i = 0; i < fastStartPosition; i++) {
            fast = fast.getNext();
        }
        while (fast != null){
            slow = slow.getNext();
            fast = fast.getNext();
        }
        // remember dummy, slow and fast are all different pointers to the same linkedlist.
        // so when you change what the node points next you affect all.
        slow.setNext(slow.getNext().getNext());
        return dummy.getNext();
    }
}
