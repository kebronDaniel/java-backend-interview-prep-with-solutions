package com.interviewPrep.practice.dsa.linkedLists;

public class DetectAndRemoveCycle {
    
    public ListNode removeCycle(ListNode node){
        
        // check if there is a cycle
        var result = checkCycle(node);
        if (result != null){
            ListNode head = node;
            // this is the second rule that states that starting from where the cycle occurred, you just need to keep
            // going forward until they both(head and where the cycle occurred) have similar node. that is where the cycle starts
            while (head != result){
                head = head.getNext();
                result = result.getNext();
            }
            // the last one is to see where the cycle repeats itself
            ListNode cycleEnd = head;
            while (true){
                if (head == cycleEnd.getNext()) break;
                cycleEnd = cycleEnd.getNext();
             }
            // finally remove the link, meaning sub where the cycle starts with null
            cycleEnd.setNext(null);
            return node;
        }
        return node;
    }

    private static ListNode checkCycle(ListNode node) {
        ListNode slow = node;
        ListNode fast = node;
        while (fast != null && fast.getNext() != null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
            if (fast== slow) return slow;
        }
        return null;
    }
}
