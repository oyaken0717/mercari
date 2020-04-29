package com.example.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.form.ItemForm;
import com.example.service.CategorySearchService;
import com.example.service.ItemService;

/**
 * カテゴリー情報を管理するコントローラー.
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/category")
public class CategoryController {
	
	@Autowired
	private CategorySearchService categorySearchService;
	
	/**
	 * 親カテゴリ一覧画面
	 * 
	 * @param model List化された親カテゴリーの情報が入る
	 * @return　親カテゴリ一覧画面
	 */
	@RequestMapping("/to-prent-category-list")
	public String toParentCategoryList(Model model) {
		List<Category> parentCategoryList = categorySearchService.findAllParent();
		model.addAttribute("parentCategoryList",parentCategoryList);
		return "categoryList";			

	}

	/**
	 * 子カテゴリ一覧画面
	 * 
	 * @param model List化された子カテゴリーの情報が入る
	 * @return　子カテゴリ一覧画面
	 */
	@RequestMapping("/to-child-category-list")
	public String toChildCategoryList(Integer parentId, Model model) {
		List<Category> childCategoryList = categorySearchService.findByParentId(parentId);
		model.addAttribute("childCategoryList",childCategoryList);
		return "childCategoryList";			
	}

	/**
	 * 孫カテゴリ一覧画面
	 * 
	 * @param model List化された孫カテゴリーの情報が入る
	 * @return　孫カテゴリ一覧画面
	 */
	@RequestMapping("/to-grand-child-category-list")
	public String toGrandChildCategoryList(Integer parentId, Model model) {
		List<Category> grandChildCategoryList = categorySearchService.findByChildId(parentId);
//■ カテゴリー登録時用の子カテゴリーのid
		parentId = grandChildCategoryList.get(0).getParent();
		model.addAttribute("parentId",parentId);
//■ 孫カテゴリーをリストで表示する。
		model.addAttribute("grandChildCategoryList",grandChildCategoryList);
		return "grandChildCategoryList";
	}
}
