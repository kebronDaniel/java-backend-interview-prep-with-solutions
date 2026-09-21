package com.interviewPrep.practice.dsa.treesAndGraphs;

public class DiameterOfBinaryTree {

    // the longest path possible.
    private int bestDiameter;
    public int getEdges(TreeNode node){
        bestDiameter = 0;
        getDepth(node);
        return bestDiameter;
    }

    public int getNodes(TreeNode node){
        bestDiameter = 0;
        getDepth(node);
        return bestDiameter + 1;
    }

    private int getDepth(TreeNode node){
        if (node == null) return 0;

        int leftDepth = getDepth(node.getLeftNode());
        int rightDepth = getDepth(node.getRightNode());

        int diameter = leftDepth + rightDepth;
        bestDiameter = Math.max(bestDiameter, diameter);
        return 1+(Math.max(leftDepth,rightDepth));

    }

}
