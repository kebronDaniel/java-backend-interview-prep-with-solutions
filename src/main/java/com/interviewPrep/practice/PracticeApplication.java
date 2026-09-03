package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		MergeIntervals mergeIntervals = new MergeIntervals();
		var result = mergeIntervals.merge(new int[][]{
				{8,9},{2,6},{1,10},{4,5}
		});
		for (int[] value:result){
			System.out.println(Arrays.toString(value));
		}
	}

}
