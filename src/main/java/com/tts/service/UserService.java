package com.tts.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tts.model.Role;
import com.tts.model.User;
import com.tts.repository.RoleRepository;
import com.tts.repository.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private Object dateFormat;

	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public User findByUsername(String username) {
		// formatTimestamps(userRepository.findByUsername(username));
		return userRepository.findByUsername(username);
	}

	public List<User> findAll() {
		return (List<User>) userRepository.findAll();
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public User saveNewUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}

	public User getLoggedInUser() {
		String loggedInUsername = SecurityContextHolder.getContext().getAuthentication().getName();
		return findByUsername(loggedInUsername);

	}
	// test

//	private void formatTimestamps(User user) {
//		String dateFormat;
//		PrettyTime prettyTime = new PrettyTime();
//		SimpleDateFormat simpleDate = new SimpleDateFormat("M/d/yy");
//		Date now = new Date();
//		long diffInMillies = Math.abs(now.getTime() - user.getCreatedAt().getTime());
//		long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
//		if (diff > 3) {
//			user.setDate(simpleDate.format(user.getCreatedAt()));
//		} else {
//			user.setDate(prettyTime.format(user.getCreatedAt()));
//		}
//
//	}
	// test
}
