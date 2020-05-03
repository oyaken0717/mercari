package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 * 編集画面へ.
	 * 
	 * @param id id
	 * @param model 詳細画面からのuserのid
	 * @return 編集画面 
	 */
	@RequestMapping("/to-edit-user")
	public String toEditUser(Integer id, Model model) {
		model.addAttribute("user_id", id);
		return "edit_user";
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
		if (form.getId()!=null) {
			user.setId(form.getIntId());			
		}
		userService.save(user);
		if (form.getId()!=null) {
			return "redirect:/user-list/show-user-list";
		}
		return "redirect:/login-user/to-login";			
	}
	
	/**
	 * User情報を削除する.
	 * 
	 * @param id id
	 * @return ユーザー一覧画面
	 */
	@RequestMapping("/delete")
	public String delete(Integer id) {
		userService.delete(id);
		return "redirect:/user-list/show-user-list";
	}

}
