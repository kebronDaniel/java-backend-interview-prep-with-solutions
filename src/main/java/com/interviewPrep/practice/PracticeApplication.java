package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import com.interviewPrep.practice.dsa.linkedLists.*;
import com.interviewPrep.practice.dsa.stacksAndQueues.BasicQueue;
import com.interviewPrep.practice.dsa.stacksAndQueues.BasicStack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
		System.out.println("---------Basic Queue--------------");
		BasicQueue queue = new BasicQueue();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.showQueue();

		System.out.println("----offer-----");
		queue.offer(4);
		queue.offer(5);
		queue.showQueue();

		System.out.println("------peek-------");
		System.out.println(queue.peek());

		System.out.println("-------poll--------");
		queue.poll();
		queue.showQueue();
	}

}
