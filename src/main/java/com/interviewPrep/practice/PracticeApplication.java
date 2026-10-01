package com.interviewPrep.practice;

import com.interviewPrep.practice.dsa.hashmapsAndSets.LongestConsecutiveSequence;
import com.interviewPrep.practice.dsa.hashmapsAndSets.SubArraySum;
import com.interviewPrep.practice.dsa.hashmapsAndSets.TopkFrequentElements;
import com.interviewPrep.practice.dsa.sortingAndSearching.BinarySearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;


@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		BinarySearch binarySearch = new BinarySearch();
		System.out.println(binarySearch.search(new int[]{1},1));
	}

}
