package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Item;
import com.example.repository.ItemRepository;

/**
 * 商品情報を取得するサービス.
 * 
 * @author oyamadakenji
 *
 */
@Service
@Transactional
public class ItemService {

	@Autowired
	public ItemRepository itemRepository;
	
	/**
	 * 商品情報を全件取得するサービス.
	 * 
	 * @return
	 */
	public List<Item> findAll(Integer page) {
		Integer offset = 0; 
		if (page != null) {
			Integer limit = 30;
			offset = limit * (page - 1);
		}
		List<Item> itemList = itemRepository.findAll(offset);
		return itemList;
	} 

	/**
	 * idから検索された商品情報を返す.
	 * 
	 * @param id
	 * @return
	 */
	public Item load(Integer id) {
		Item item = itemRepository.load(id);
		return item;
	}
	
	public void save(Item item) {
		itemRepository.save(item);
	} 
}
