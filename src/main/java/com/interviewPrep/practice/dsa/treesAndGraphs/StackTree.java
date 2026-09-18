package com.interviewPrep.practice.dsa.treesAndGraphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

// stack that stores a tree
public class StackTree {

    private Deque<TreeNode> stackTreeNode = new ArrayDeque<>();
    private int size;

    public void add(TreeNode treeNode){
        stackTreeNode.push(treeNode);
        size++;
    }

    public TreeNode pop(){
        if (isEmpty()) throw new IllegalStateException("Can't pop an empty stack");
        size--;
        return stackTreeNode.pop();
    }

    public TreeNode peek(){
        if (isEmpty()) throw new IllegalStateException("Can't pop an empty stack");
        return stackTreeNode.peek();
    }


    public boolean isEmpty(){
        return size <= 0;
    }
}
