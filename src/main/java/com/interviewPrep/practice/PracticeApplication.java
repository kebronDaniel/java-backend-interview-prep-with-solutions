package com.interviewPrep.practice;

import com.interviewPrep.practice.dsa.hashmapsAndSets.GroupAnagram;
import com.interviewPrep.practice.dsa.hashmapsAndSets.SubArraySum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		SubArraySum subArraySum = new SubArraySum();
		subArraySum.getSubArrays(new int[]{1,2,3},3);
	}

}
