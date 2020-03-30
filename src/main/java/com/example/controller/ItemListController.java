package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ItemService;

/**
 * 商品情報を表示するコントローラー.
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("")
public class ItemListController {
	
	@Autowired
	private ItemService itemService;
	

	/**
	 * 商品一覧画面
	 * 
	 * @param model List化された全商品の情報が入る
	 * @return　商品一覧画面
	 */
	@RequestMapping("")
	public String toItemList(Model model) {
		List<Item> itemList = itemService.findAll();
		model.addAttribute("itemList",itemList);
		return "list";
	}
	
	/**
	 * 商品詳細画面
	 * 
	 * @param model idで指定された商品の情報が入る
	 * @return 商品詳細画面
	 */
	@RequestMapping("to-show-item")
	public String toShowItem(Model model, Integer id) {
		Item item = itemService.load(id);
		model.addAttribute("item",item);
		return "list";
	}
	
}
