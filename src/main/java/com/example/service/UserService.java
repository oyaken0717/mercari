package com.example.service;

import java.util.List;

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
	
	/**
	 * 登録されている全てのUser情報を取得する.
	 * 
	 * @return  登録されている全てのUser情報
	 */
	public List<User> findAll() {
		List<User> userList = userRepository.findAll();
		return userList;
	}
	
	/**
	 * idからユーザー情報を取得する.
	 * 
	 * @param id 一覧から選択されたid
	 * @return idから特定されたUser情報
	 */
	public User findById(Integer id) {
		User user = userRepository.findById(id);
		return user;
	}
	
	public void delete(Integer id) {
		userRepository.delete(id);
	}	
}
