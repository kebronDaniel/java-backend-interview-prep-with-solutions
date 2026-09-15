package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import com.interviewPrep.practice.dsa.linkedLists.*;
import com.interviewPrep.practice.dsa.stacksAndQueues.*;
import com.interviewPrep.practice.dsa.treesAndGraphs.InorderTraversal;
import com.interviewPrep.practice.dsa.treesAndGraphs.TreeNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		TreeNode rootNode = new TreeNode(1);
		TreeNode treeNode2 = new TreeNode(2);
		TreeNode treeNode3 = new TreeNode(3);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);

		rootNode.setLeftNode(treeNode2);
		rootNode.setRightNode(treeNode3);

		treeNode2.setLeftNode(treeNode4);
		treeNode2.setRightNode(treeNode5);

		InorderTraversal inorderTraversal = new InorderTraversal();
		inorderTraversal.getNodesInorder(rootNode);
	}

}
