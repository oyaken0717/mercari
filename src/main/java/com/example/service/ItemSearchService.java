package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.domain.Item;
import com.example.repository.CategorySearchRepository;
import com.example.repository.ItemSearchRepository;

@Service
@Transactional
public class ItemSearchService {

	@Autowired
	public ItemSearchRepository itemSearchRepository;
	
	@Autowired
	public CategorySearchRepository categorySearchRepository;
	
	public List<Item> findByKeyWords(String name,Integer parentId,Integer childId,Integer grandChildId,String brand) {
		
//		//■ name ※検索フォームを作る時にいるかと思って作ったけどいらないっぽい
//		String itemName = "";
//		if (name != "") {
//			Item item = itemSearchRepository.findByName(name); 
//			itemName = item.getName();
//		}
		
		//■ parentId
		String parentName = "";
		if (parentId != null) {
			Category parentCategory = categorySearchRepository.load(parentId);
			parentName = parentCategory.getName();
		}
		//■ childId
		String childName = "";
		if (childId != null) {
			Category parentCategory = categorySearchRepository.load(childId);
			childName = parentCategory.getName();
		}
		//■ grandChildId
		String grandChildName = "";
		if (grandChildId != null) {
			Category parentCategory = categorySearchRepository.load(grandChildId);
			grandChildName = parentCategory.getName();
		}
		
//		//■ brand ※検索フォームを作る時にいるかと思って作ったけどいらないっぽい
//		String brandName = "";
//		if (brand != "") {
//			Item item = itemSearchRepository.findByBrand(brand); 
//			brandName = item.getBrand();
//		}
		
		//■ name_allを作る
		StringBuilder nameAll = new StringBuilder();
		if (parentName != "") {
			nameAll.append(parentName);			
			nameAll.append("/");			
		}
		if (childName != "") {
			nameAll.append(childName);			
			nameAll.append("/");			
		}
		if (grandChildName != "") {
			nameAll.append(grandChildName);			
		}
		
		List<Item> itemList = itemSearchRepository.findByKeyWords(name, nameAll.toString(), brand);
		return itemList;
	}
}
