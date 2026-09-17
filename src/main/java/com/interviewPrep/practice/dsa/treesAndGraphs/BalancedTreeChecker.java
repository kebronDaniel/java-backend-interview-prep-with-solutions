package com.interviewPrep.practice.dsa.treesAndGraphs;

public class BalancedTreeChecker {

    // the idea is to tell if its balanced or not just by looking at the result -1.
    // how?
    public boolean check(TreeNode root){
        return getHeight(root) == -1 ? false : true;
    }

    private int getHeight(TreeNode node){
        int left = 0;
        int right = 0;
        if (node == null){
            return 0;
        }
        else {
            left = getHeight(node.getLeftNode());
            // if the height is -1 meaning there is an imbalance that value is propagated to the top
            // because all return -1 all the way up.
            // then the false is returned as a result.
            if (left == -1) return -1;
            right = getHeight(node.getRightNode());
            if (right == -1) return -1;
        }
        // during this recursion it checks if the difference between the two nodes below you is not > 1
        // if its then it means one is taller than the other.
        // in that case you return -1.
        // or in a normal case you return the height.
        if (Math.max(left,right) - Math.min(left,right) > 1) return -1;
        else return 1 + (Math.max(left,right));
    }
}
