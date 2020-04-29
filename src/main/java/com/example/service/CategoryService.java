package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.repository.CategoryRepository;

/**
 * カテゴリーの情報を取得するサービス.
 * 
 * @author oyamadakenji
 *
 */
@Service
@Transactional
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	/**
	 * 孫カテゴリーを登録する.
	 * 
	 */
	public void insert(Category category) {
		categoryRepository.insert(category);
	}

}
