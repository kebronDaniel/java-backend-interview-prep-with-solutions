package com.interviewPrep.practice;

import com.interviewPrep.practice.dsa.hashmapsAndSets.LongestConsecutiveSequence;
import com.interviewPrep.practice.dsa.hashmapsAndSets.SubArraySum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
		System.out.println(longestConsecutiveSequence.getLengthOfLongestConsecutiveSequence(new int[]{100,4,200,1,3,2,4,5}));
	}

}
