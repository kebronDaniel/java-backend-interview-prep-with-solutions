package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.ThreeSums;
import com.interviewPrep.practice.dsa.arraysAndStrings.TwoSum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.*;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		ThreeSums threeSums = new ThreeSums();
		var result = threeSums.getThreeSums(new int[]{-4,-1,-1,0,0,1,1,2});
		System.out.println(result);
	}

}
