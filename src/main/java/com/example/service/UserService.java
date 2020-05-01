package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * User情報を取得するサービス.
 * 
 * @author oyamadakenji
 *
 */
@Service
@Transactional
public class UserService {

	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * User情報を登録、更新する.
	 * 
	 * @param user 登録、更新する情報の入ったドメイン
	 */
	public void save(User user) {
		if (user.getId()==null) {
			String encodePassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodePassword);			
		}
		userRepository.save(user);
	}
}
