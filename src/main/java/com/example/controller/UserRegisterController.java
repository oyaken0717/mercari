package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.form.UserForm;
import com.example.service.UserService;

@Controller
@RequestMapping("/user-register")
public class UserRegisterController {

	@Autowired
	private UserService userService; 
	
	/**
	 * ユーザー情報登録画面へ.
	 * 
	 * @return ユーザー情報登録画面
	 */
	@RequestMapping("/to-register-user")
	public String toRegisterUser() {
		return "register_user";
	}
	
	/**
	 * ユーザー情報の登録、更新をする.
	 * 
	 * @param user 登録、更新をするドメイン
	 * @return ログイン画面(仮:商品一覧画面)
	 */
	@RequestMapping("/save")
	public String save(UserForm form) {
		User user = new User();
		BeanUtils.copyProperties(form, user);
		userService.save(user);
		return "redirect:/login-user/to-login";
	}
}
