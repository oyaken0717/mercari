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
	 * 孫カテゴリーを登録、更新する.
	 * @return 
	 * 
	 */
	public Category insert(Category category) {
		category = categoryRepository.insert(category);
		return category;
	}
	
	/**
	 * カテゴリーの詳細情報を取得する.
	 * 
	 * @param id カテゴリーのid
	 * @return カテゴリーの詳細情報
	 */
	public Category load(Integer id) {
		Category category = categoryRepository.load(id);
		return category;
	}

	/**
	 * カテゴリー情報を削除する.
	 * 
	 * @param id カテゴリーのid
	 */
	public void delete(Integer id) {
		categoryRepository.delete(id);
	}
}
