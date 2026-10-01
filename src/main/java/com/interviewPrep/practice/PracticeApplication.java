package com.interviewPrep.practice;

import com.interviewPrep.practice.dsa.hashmapsAndSets.LongestConsecutiveSequence;
import com.interviewPrep.practice.dsa.hashmapsAndSets.SubArraySum;
import com.interviewPrep.practice.dsa.hashmapsAndSets.TopkFrequentElements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		TopkFrequentElements frequentElements = new TopkFrequentElements();
		frequentElements.getFrequentElements(new int[]{1,2,3,2,1,2,2,3,1,1,2,4,5,3,6,4,3,2}, 1);
	}

}
