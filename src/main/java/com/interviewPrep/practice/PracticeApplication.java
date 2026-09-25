package com.interviewPrep.practice;

import com.interviewPrep.practice.dsa.hashmapsAndSets.GroupAnagram;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);

		GroupAnagram groupAnagram = new GroupAnagram();
		var result = groupAnagram.group(new ArrayList<>(List.of("ant","Tan", "eat", "TEA", "bat")));
		System.out.println(result);
	}

}
