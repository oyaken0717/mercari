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
	public List<Item> findAll() {
		List<Item> itemList = itemRepository.findAll();
		return itemList;
	} 
}
