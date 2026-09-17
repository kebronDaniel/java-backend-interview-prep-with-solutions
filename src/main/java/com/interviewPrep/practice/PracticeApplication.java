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

		TreeNode rootNode = new TreeNode(8);
		TreeNode treeNode4 = new TreeNode(4);
		TreeNode treeNode5 = new TreeNode(5);
		TreeNode treeNode6 = new TreeNode(6);
		TreeNode treeNode7 = new TreeNode(7);
		TreeNode treeNode8 = new TreeNode(8);

		rootNode.setLeftNode(treeNode4);
		rootNode.setRightNode(treeNode5);
		treeNode4.setLeftNode(treeNode6);
		treeNode4.setRightNode(treeNode7);
		treeNode6.setLeftNode(treeNode8);

		BalancedTreeChecker checker = new BalancedTreeChecker();
		System.out.println(checker.check(rootNode));

	}

}
