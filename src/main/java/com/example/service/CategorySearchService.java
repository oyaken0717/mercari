package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.repository.CategorySearchRepository;

/**
 * 大中小のカテゴリーの情報を取得するサービス.
 * 
 * @author oyamadakenji
 *
 */
@Service
@Transactional
public class CategorySearchService {

	@Autowired
	private CategorySearchRepository categorySearchRepository;
	
	/**
	 * 親カテゴリーを取得する.
	 * 
	 * @return  親カテゴリーのみ入ったリスト
	 */
	public List<Category> findAllParent() {
		List<Category> parentList = categorySearchRepository.findAllParent();
		return parentList;
	}

	/**
	 * 子カテゴリーを取得する.
	 * 
	 * @param parentId 親のID
	 * @return 子カテゴリーのみ入ったリスト
	 */
	public List<Category> findByParentId(Integer parentId) {
		List<Category> childList = categorySearchRepository.findByParentId(parentId);
		return childList;
	}

	/**
	 * 孫カテゴリーを取得する.
	 * 
	 * @param childId 子のID
	 * @return 孫カテゴリーのみ入ったリスト
	 */
	public List<Category> findByChildId(Integer parentId) {
		List<Category> grandChildList = categorySearchRepository.findByChildId(parentId);
		return grandChildList;
	}
}
