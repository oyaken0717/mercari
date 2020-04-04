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

	@Autowired
	private CategorySearchService categorySearchService;
	
	/**
	 * 商品一覧画面
	 * 
	 * @param model List化された全商品の情報が入る
	 * @return　商品一覧画面
	 */
	@RequestMapping("")
	public String toItemList(Model model) {
		List<Item> itemList = itemService.findAll();
		List<Category> parentList = categorySearchService.findAllParent();
		model.addAttribute("itemList",itemList);
		model.addAttribute("parentList",parentList);
		return "list";
	}
	
	/**
	 * 商品登録画面へ
	 * 
	 * @param model 大中小カテゴリーの情報が入ったリストが入る
	 * @return 商品登録画面
	 */
	@RequestMapping("/to-add-item")
	public String toAddItem(Model model) {
		List<Category> parentList = categorySearchService.findAllParent();
		model.addAttribute("parentList",parentList);
		return "add";
	}
	
	/**
	 * 商品詳細画面
	 * 
	 * @param model idで指定された商品の情報が入る
	 * @param id 商品一覧画面で取得した商品のid
	 * @return 商品詳細画面
	 */
	@RequestMapping("/to-show-item")
	public String toShowItem(Model model, Integer id) {
		Item item = itemService.load(id);
		model.addAttribute("item",item);
		return "detail";
	}

	/**
	 * 商品編集画面へ
	 * @param model idで指定された商品の情報が入る
	 * @param id 商品一覧画面で取得した商品のid
	 * @return 商品編集画面
	 */
	@RequestMapping("/to-edit-item")
	public String toEditItem(Model model,Integer id) {
		Item item = itemService.load(id);
		List<Category> parentList = categorySearchService.findAllParent();
		model.addAttribute("item",item);
		model.addAttribute("parentList",parentList);
		return "edit";
	}
	
	/**
	 * 商品情報を登録、更新する.
	 * 
	 * @param model 登録、更新するための新しい商品情報が入る
	 * @param form 登録、更新するための新しい商品情報が入る
	 * @return 商品詳細画面
	 */
	@RequestMapping("/save-item")
	public String saveItem(ItemForm form,Model model,RedirectAttributes redirectAttributes) {
		Item item = new Item();
		if (form.getIntId()!=null) {
			item = itemService.load(form.getIntId());					
		}
		
		BeanUtils.copyProperties(form, item);
		item.setId(form.getIntId());
        item.setPrice(form.getDoublePrice());
        item.setCategory(form.getIntCategory());
        item.setCondition(form.getIntCondition());

		itemService.save(item);
		
		if (form.getIntId()!=null) {
			redirectAttributes.addAttribute("id", form.getIntId());
			return "redirect:/to-show-item";
		}
		return "redirect:/";
	}
}
