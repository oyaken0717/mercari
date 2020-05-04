package com.example.controller;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Sale;
import com.example.form.SaleForm;
import com.example.service.SaleSetService;

/**
 * セール情報を扱うコントローラー.
 * 
 * @author oyamadakenji
 *
 */
@Controller
@RequestMapping("/sale-set")
public class SaleSetController {

	@Autowired
	private SaleSetService saleSetService;
	
	/**
	 * 【遷移】セール設定画面へ.
	 * 
	 * @param id 一覧画面からのitemのid
	 * @param model idがセール設定画面でhiddenで格納される
	 * @return セール設定画面
	 */
	@RequestMapping("/to-sale")
	public String toSale(Integer id,Model model){
		model.addAttribute("itemId", id);
		return "add_sale";
	}

	@RequestMapping("/save")
	public String save(SaleForm form){
		//■ ①form.getItemId()で登録があるかチェックする。
		Sale sale = new Sale();
		sale.setItemId(form.getIntItemId());
		sale.setPrice(form.getDoublePrice());
		//■ DBのdateに登録できるように情報を加工する。
		String year = form.getYear();
		String month = form.getMonth();
		String day = form.getDay();
		String date = year+"-"+month+"-"+day;
		sale.setTerm(Date.valueOf(date));
		
		sale = saleSetService.save(sale);
		return "redirect:/";
	}
	
	
}
