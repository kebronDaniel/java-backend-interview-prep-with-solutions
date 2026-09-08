package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import com.interviewPrep.practice.dsa.linkedLists.BasicLinkedList;
import com.interviewPrep.practice.dsa.linkedLists.ListNode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		BasicLinkedList linkedList = new BasicLinkedList();
		linkedList.addLast(new ListNode(1));
		linkedList.addLast(new ListNode(2));
		linkedList.addLast(new ListNode(3));
		linkedList.addLast(new ListNode(4));
		linkedList.printList();
	}

}
