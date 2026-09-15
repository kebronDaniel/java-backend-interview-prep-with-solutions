package com.interviewPrep.practice.dsa.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversalRecursion {

    public List<Integer> getInorder(TreeNode treeNode){
        List<Integer> result = new ArrayList<>();
        helper(treeNode,result);
        return result;
    }

    private void helper(TreeNode input, List<Integer> result){
        if (input == null) return;
        helper(input.getLeftNode(), result);
        result.add(input.getValue());
        helper(input.getRightNode(), result);
    }
}
