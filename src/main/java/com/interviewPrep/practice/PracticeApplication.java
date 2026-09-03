package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import com.interviewPrep.practice.dsa.arraysAndStrings.KadanesAlgorithm;
import com.interviewPrep.practice.dsa.arraysAndStrings.RotateAnArray;
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

		RotateAnArray rotateAnArray = new RotateAnArray();
		var result = rotateAnArray.getRotatedArray(new int[]{1,2,3,4,5,6,7},3);
		System.out.println(Arrays.toString(result));
	}

}
