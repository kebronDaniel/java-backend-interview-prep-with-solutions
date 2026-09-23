package com.interviewPrep.practice;

import com.interviewPrep.practice.dsa.treesAndGraphs.graphs.Graph;
import com.interviewPrep.practice.dsa.treesAndGraphs.graphs.MatrixGraph;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);


		MatrixGraph matrixGraph = new MatrixGraph(2,2);
		matrixGraph.assignNode(0,0,0);
		matrixGraph.assignNode(0,1,1);
		matrixGraph.assignNode(1,0,0);
		matrixGraph.assignNode(1,1,1);
		System.out.println(matrixGraph);
	}

}
