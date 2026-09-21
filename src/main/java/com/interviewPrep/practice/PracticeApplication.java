package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import com.interviewPrep.practice.dsa.linkedLists.*;
import com.interviewPrep.practice.dsa.stacksAndQueues.*;
import com.interviewPrep.practice.dsa.treesAndGraphs.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		TreeNode rootNode = new TreeNode(10);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode8 = new TreeNode(8);
		TreeNode treeNode15 = new TreeNode(15);
		TreeNode treeNode12 = new TreeNode(12);
		TreeNode treeNode17 = new TreeNode(17);

		rootNode.setLeftNode(treeNode6);
		rootNode.setRightNode(treeNode15);
		treeNode6.setLeftNode(treeNode4);
		treeNode6.setRightNode(treeNode8);
		treeNode15.setLeftNode(treeNode12);
		treeNode15.setRightNode(treeNode17);

		DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();
		diameter.getEdges(rootNode);
		diameter.getNodes(rootNode);

	}

}
