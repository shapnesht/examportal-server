package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.SecondaryTable;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {
	@Autowired
	public UserService userService;

	@Autowired
	public PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		try {
			User user = new User(
					"admin",
					encoder.encode("shoppy"),
					"Shoppy",
					"Tiwari",
					"shap@123.com",
					"123456",
					"I'm devil"
			);
			Set<UserRole> set = new HashSet<>();
			Role role = new Role("ADMIN", 2L);
			UserRole userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);

			set.add(userRole);
			System.out.println(userService.createUser(
					user,
					set
			));
			user = new User(
					"shapnesht",
					encoder.encode("shoppy"),
					"Shapnesh",
					"Tiwari",
					"shap@123.com",
					"123456",
					"I'm devil"
			);
			set = new HashSet<>();
			role = new Role("NORMAL", 1L);
			userRole = new UserRole();
			userRole.setRole(role);
			userRole.setUser(user);

			set.add(userRole);
			System.out.println(userService.createUser(
					user,
					set
			));
		} catch (Exception e) {
			System.out.println("User exists!!");
		}
	}
}
