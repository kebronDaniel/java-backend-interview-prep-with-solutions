package com.interviewPrep.practice;

import com.interviewPrep.practice.dsa.treesAndGraphs.graphs.Graph;
import com.interviewPrep.practice.dsa.treesAndGraphs.graphs.MatrixGraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		Graph graph = new Graph();
		graph.addNode("A");
		graph.addNode("B");
		graph.addNode("C");
		graph.addNode("D");
		graph.addEdge("A","B");
		graph.addEdge("B","C");
		graph.addEdge("C","D");
		graph.addEdge("D","B");
		System.out.println(graph.detectCycleForDirectedGraph());
	}

}
