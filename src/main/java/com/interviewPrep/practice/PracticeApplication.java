package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import com.interviewPrep.practice.dsa.linkedLists.*;
import com.interviewPrep.practice.dsa.stacksAndQueues.BasicStack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		BasicStack stack = new BasicStack();
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.showStack();
		stack.push(5);
		System.out.println("-------push-------");
		stack.showStack();
		System.out.println("-------peek--------");
		System.out.println(stack.peek());
		stack.pop();
		System.out.println("-------pop-------");
		stack.showStack();
	}

}
