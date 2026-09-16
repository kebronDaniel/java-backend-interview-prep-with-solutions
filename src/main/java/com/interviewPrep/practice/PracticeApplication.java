package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import com.interviewPrep.practice.dsa.linkedLists.*;
import com.interviewPrep.practice.dsa.stacksAndQueues.*;
import com.interviewPrep.practice.dsa.treesAndGraphs.InorderTraversal;
import com.interviewPrep.practice.dsa.treesAndGraphs.LevelOrderTraversal;
import com.interviewPrep.practice.dsa.treesAndGraphs.TreeNode;
import com.interviewPrep.practice.dsa.treesAndGraphs.ValidateBinaryTree;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		TreeNode rootNode = new TreeNode(5);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode1 = new TreeNode(1);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode8 = new TreeNode(8);

		rootNode.setLeftNode(treeNode3);
		rootNode.setRightNode(treeNode7);
		treeNode3.setLeftNode(treeNode1);
		treeNode3.setRightNode(treeNode4);
		treeNode7.setLeftNode(treeNode8);

		ValidateBinaryTree validateBinaryTree = new ValidateBinaryTree();
		System.out.println(validateBinaryTree.validate(rootNode));

	}

}
