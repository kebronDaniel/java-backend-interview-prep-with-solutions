package com.interviewPrep.practice;

import com.interviewPrep.practice.coreJava.equalsHashcode.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

@SpringBootApplication
public class PracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeApplication.class, args);
		User user = new User(1l, "kebron");
		User usertwo = new User(1l, "kebron");

		System.out.println(Objects.equals(user, usertwo));

		HashSet<User> userHashSet = new HashSet<>();
		userHashSet.add(user);
		userHashSet.add(usertwo);
		for (User person: userHashSet){
			System.out.println(person.getName());
		}
		System.out.println(userHashSet.size());

		HashMap<User, String> userStringHashMap = new HashMap<>();
		userStringHashMap.put(user,"kb");
		System.out.println(userStringHashMap.get(usertwo));
	}

}
