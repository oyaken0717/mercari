package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

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
	public ItemRepository itemRepository;
	
	@RequestMapping("")
	public String toItemList() {
		List<Item> itemList = itemRepository.findAll();
		return "list";
	}
}
