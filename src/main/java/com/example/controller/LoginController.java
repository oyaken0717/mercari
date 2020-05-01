package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login-user")
public class LoginController {
	
	/**
	 * ログイン画面へ.
	 * 
	 * @param model エラー情報をHTML側で表示する為のモデル.
	 * @param error エラー情報
	 * @return ログイン画面
	 */
	@RequestMapping("/to-login")
	public String toLogin(Model model,@RequestParam(required = false) String error) {

		if (error != null) {
			model.addAttribute("errorMessage","エラーです。");
		}
		return "login";
	}
}
