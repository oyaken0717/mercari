package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.service.CategorySearchService;
import com.example.service.ItemSearchService;

/**
 * 商品検索をするコントローラー.
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/item_search")
public class ItemSearchController {

	@Autowired
	public ItemSearchService itemSearchService;
	
	@Autowired
	private CategorySearchService categorySearchService;
		
	@RequestMapping("/find-by-key-words")
	public String findByKeyWords(String name,Integer parentId,Integer childId,Integer grandChildId,String brand, Model model) {
		List<Item> itemList =  itemSearchService.findByKeyWords(name, parentId, childId, grandChildId, brand);
		List<Category> parentList = categorySearchService.findAllParent();
		model.addAttribute("itemList",itemList);
		model.addAttribute("parentList",parentList);
		return "list";		
	}
}
