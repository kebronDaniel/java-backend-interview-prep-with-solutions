package com.interviewPrep.practice.dsa.treesAndGraphs;

public class ValidateBinaryTree {

    public boolean validate(TreeNode root) {
        // remember the stack is a stack of the left visited nodes
        // and the way you move is left....when there is right node continue moving left .....
        // it's like the spdf ordering.
        // Inorder traversal visits left, node, then right.
        // The stack remembers nodes to return to after exploring their left subtree.
        // Each popped value must be greater than the previously visited value.
        if (root == null) return true;
        TreeNode previous = null;
        TreeNode current = root;
        StackTree stack = new StackTree();
        while (current != null || !stack.isEmpty()){
            // go to the left most end
            while (current != null){
                stack.add(current);
                current = current.getLeftNode();
            }
            var popped = stack.pop();
            if (previous == null || popped.getValue() > previous.getValue()) previous = popped;
            else return false;
            current = popped.getRightNode();
        }
        return true;
    }

}
