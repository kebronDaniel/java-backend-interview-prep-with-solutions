package com.interviewPrep.practice.dsa.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// to get list node values based on their level.
public class LevelOrderTraversal {

    public List<List<Integer>> getLevelOrder(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        if (root == null) throw new IllegalArgumentException("input node is null");

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.push(root);
        while (!queue.isEmpty()){
            List<Integer> currentLevel = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                var currentNode = queue.removeFirst();
                currentLevel.add(currentNode.getValue());
                if (currentNode.getLeftNode() != null) queue.addLast(currentNode.getLeftNode());
                if (currentNode.getRightNode() != null) queue.addLast(currentNode.getRightNode());
            }
            result.add(currentLevel);
        }
        return result;
    }
}
