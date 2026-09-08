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

		FirstNonRepeatingCharacter nonRepeatingCharacter = new FirstNonRepeatingCharacter();
		System.out.println(nonRepeatingCharacter.getIndexOfFirstNonRepeatingChar("loveleetcode"));
	}

}
