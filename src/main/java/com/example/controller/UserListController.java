package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ユーザー情報一覧を扱うコントローラー
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/user-list")
public class UserListController {

	/**
	 * ユーザー一覧画面へ.
	 * 
	 * @return ユーザー一覧画面
	 */
	@RequestMapping("/show-user-list")
	public String showUserList() {
		return "user_list";
	}
}