package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import com.interviewPrep.practice.dsa.linkedLists.*;
import com.interviewPrep.practice.dsa.stacksAndQueues.BasicQueue;
import com.interviewPrep.practice.dsa.stacksAndQueues.BasicStack;
import com.interviewPrep.practice.dsa.stacksAndQueues.MinStack;
import com.interviewPrep.practice.dsa.stacksAndQueues.ValidParenthesis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		MinStack minStack = new MinStack();
		minStack.push(5);
		minStack.push(2);
		minStack.push(4);
		System.out.println(minStack.getMin());
	}

}
