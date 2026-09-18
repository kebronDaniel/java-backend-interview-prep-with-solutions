package com.interviewPrep.practice.dsa.treesAndGraphs;

public class LeastCommonAncestorForBst {


    public int findLeastCommonAncestor(int p, int q, TreeNode root){
        var current = root;
        while (current != null ){
            if (p < current.getValue() && q < current.getValue()){
                current = current.getLeftNode();
            } else if (p > current.getValue() && q > current.getValue()) {
                current = current.getRightNode();
            } else {
                return current.getValue();
            }
        }
        return root.getValue();
    }
}
