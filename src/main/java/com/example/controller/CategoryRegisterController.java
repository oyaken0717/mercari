package com.example.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.domain.Category;
import com.example.form.CategoryForm;
import com.example.service.CategoryService;
import com.example.service.CsvOutputService;

/**
 * カテゴリー情報を管理するコントローラー.
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/category-register")
public class CategoryRegisterController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private CsvOutputService csvOutputService;
	
	/**
	 * カテゴリー登録画面へ
	 * 
	 * @param model 大中小カテゴリーの情報が入ったリストが入る
	 * @return 商品登録画面
	 */
	@RequestMapping("/to-add-category")
	public String toAddCategory(Integer parentId,Model model) {
		model.addAttribute("parentId",parentId);
		return "addCategory";
	}

	/**
	 * カテゴリーを登録する.
	 * 
	 * @param form 登録画面からの情報を受け取るform
	 * @param redirectAttributes リダイレクト先の引数に必要なparentId
	 * @return 孫カテゴリー一覧画面
	 */
	@RequestMapping("/insert")
	public String insert(CategoryForm form, RedirectAttributes redirectAttributes){
		Category category = new Category();
		BeanUtils.copyProperties(form, category);
		category.setParent(form.getIntParent());
		category.setName(form.getName());
		category.setNameAll("あとで登録する。");
		//■insert
		category = categoryService.insert(category);
		//■csvで出力
		csvOutputService.outputCategory(category);
		redirectAttributes.addAttribute("parentId", category.getParent());
		return "redirect:/category/to-grand-child-category-list";
	}
	
	/**
	 * カテゴリー詳細画面へ
	 * 
	 * @param model idで指定された商品の情報が入る
	 * @param id 商品一覧画面で取得した商品のid
	 * @return 商品詳細画面
	 */
	@RequestMapping("/to-show-category")
	public String toShowCategory(Integer id, Model model) {
		Category category = categoryService.load(id);
		model.addAttribute("category", category);
		return "detailCategory";
	}

	/**
	 * カテゴリー編集画面へ
	 * @return カテゴリー編集画面
	 */
	@RequestMapping("/to-edit-category")
	public String toEditCategory(Integer id, Model model) {
		model.addAttribute("categoryId", id);
		return "editCategory";
	}

	/**
	 * カテゴリーの更新.
	 * 
	 * @param form 更新したい情報が入ったform
	 * @param redirectAttributes 詳細画面に遷移するためのid
	 * @return カテゴリー詳細画面
	 */
	@RequestMapping("/edit")
	public String edit(CategoryForm form, RedirectAttributes redirectAttributes){
		Category category = new Category();
		BeanUtils.copyProperties(form, category);
		category.setId(form.getIntId());
		//■update
		categoryService.insert(category);
		//■csvで出力
		csvOutputService.outputCategory(category);
		redirectAttributes.addAttribute("id", category.getId());
		return "redirect:/category-register/to-show-category";
	}
	
	@RequestMapping("/delete-category")
	public String deleteCategory(Integer id) {
		categoryService.delete(id);
		return "redirect:/";
	}
	
}
