package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.service.UserService;

/**
 * ユーザー情報一覧を扱うコントローラー
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/user-list")
public class UserListController {

	@Autowired
	private UserService userService;
	
	/**
	 * ユーザー一覧画面へ.
	 * 
	 * @return ユーザー一覧画面
	 */
	@RequestMapping("/show-user-list")
	public String showUserList(Model model) {
		List<User> userList = userService.findAll();
		model.addAttribute("userList",userList);
		return "user_list";
	}
	
	@RequestMapping("/to-user-detail")
	public String toUserDetail(Integer id, Model model) {
		User user = userService.findById(id);
		model.addAttribute("user",user);
		return "user_detail";
	}
	
}