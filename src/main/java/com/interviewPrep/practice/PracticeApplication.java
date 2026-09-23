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

		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");

		graph.addEdge("A", "B");
		graph.addEdge("B", "A");
		graph.addEdge("B", "C");
		graph.addEdge("B", "D");
		graph.addEdge("C", "B");
		graph.addEdge("D", "B");

		graph.pathExists("A","D");
	}

}
