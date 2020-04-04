package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Category;
import com.example.service.CategorySearchService;

/**
 * 商品検索をするajax用コントローラー
 * 
 * @author oyamadakenji
 *
 */
@RestController
@RequestMapping("/item_search")
public class CategorySearchContoroller {
	
	@Autowired
	private CategorySearchService categorySearchService;
	
	/**
	 * 選択された親カテゴリーから子カテゴリーを取得する.
	 * 
	 * @param parentId 親のID
	 * @return 子カテゴリーのみ入ったリスト
	 */
	@RequestMapping(value = "/check_parent", method = RequestMethod.POST)
	public List<Category> checkParent(Integer parentId) {
		List<Category> childList = categorySearchService.findByParentId(parentId);
		return childList;
	}        

	/**
	 * 選択された子カテゴリーから孫カテゴリーを取得する.
	 * 
	 * @param childId 子のID
	 * @return 孫カテゴリーのみ入ったリスト
	 */
	@RequestMapping(value = "/check_child", method = RequestMethod.POST)
	public List<Category> checkChild(Integer childId) {
		List<Category> grandChildList = categorySearchService.findByChildId(childId);
		return grandChildList;
	}        
}
