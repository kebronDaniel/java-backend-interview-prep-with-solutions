package com.interviewPrep.practice.dsa.linkedLists;

public class PalindromeLinkedList {

    public boolean checkPalindrome(ListNode node){

        // get the middle
        var midNode = midNode(node);

        // reverse the second half
        var reversedSecondHalf = reverse(midNode);

        // note that now node (original one) is 1-2-3-null because the reverse has changed the pointer of 3.
        ListNode firstPointer = node;
        // the other half (3-2-1-null) has now been reversed to 1-2-3-null which is not node but similar to node.
        ListNode secondPointer = reversedSecondHalf;
        while (firstPointer != null && firstPointer.getNext() != null){
            if (firstPointer.getValue() != secondPointer.getValue()) return false;
            firstPointer =  firstPointer.getNext();
            secondPointer = secondPointer.getNext();
        }
        // reverse back the node
        reverse(reversedSecondHalf);
        return true;
    }

    private static ListNode midNode(ListNode node){
        ListNode slow = node;
        ListNode fast = node;

        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return slow;
    }

    private static ListNode reverse(ListNode node){

        ListNode previous = null;
        ListNode current = node;

        while (current != null){
            ListNode next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
}
