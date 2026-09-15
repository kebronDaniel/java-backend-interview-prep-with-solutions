package com.interviewPrep.practice.dsa.treesAndGraphs;

import java.util.ArrayList;
import java.util.List;

// Inorder: the order is Left,current,right
public class InorderTraversal {

    public List<Integer> getNodesInorder(TreeNode inputTree){
        StackTree stack = new StackTree();
        TreeNode currentNode = inputTree;
        List<Integer> result = new ArrayList<>();

        while (currentNode != null || !stack.isEmpty()){
            // this keeps going till there is no left node.
            while (currentNode != null){
                stack.add(currentNode);
                currentNode = currentNode.getLeftNode();
            }
            currentNode = stack.pop();
            result.add(currentNode.getValue());
            // this part checks if the current node has right node.
            // if so it does since current now points to it then the program goes to find the left most node.
            // if not (if it doesn't exist) then we dont check if it has left node and we move one step out (stack.pop).
            // remember the above steps happen when the loop goes another round.
            currentNode = currentNode.getRightNode();
        }
        return result;
    }
}
