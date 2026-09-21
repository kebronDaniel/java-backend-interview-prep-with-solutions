package com.interviewPrep.practice.dsa.treesAndGraphs;

public class LeastCommonAncestor {

    public TreeNode findLeastCommonAncestor(int p, int q, TreeNode node){
        // here when ever you reach bottom it returns null.
        if (node == null) return null;
        // if you have got one of the nodes then return that node
        // because we would know later using the caller (either left or right) which side got it.
        // and also what we want is the ancestor.
        // returning back mean I am here to the caller parent.
        if (node.getValue() == p || node.getValue() == q) return node;

        var leftResult = findLeastCommonAncestor(p,q,node.getLeftNode());
        var rightResult = findLeastCommonAncestor(p,q,node.getRightNode());

        // if both have nodes it means that the parent has got a call from both children (left and right) that both have been found.
        if (leftResult != null && rightResult != null) return node;
        // or else we return the correct node and that would propagate back properly to the call stack.
        if (leftResult != null) return leftResult;
        return rightResult;
    }
}
