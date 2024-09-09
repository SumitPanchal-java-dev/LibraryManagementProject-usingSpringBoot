package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Book;
import com.application.Library.entity.Category;
import com.application.Library.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository categoryrepo;

	public List<Category> findAllCategory() {
		return categoryrepo.findAll();
	}

	public Category findCategory(Long id) {
		Category category;
		category = categoryrepo.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
		return category;
	}

	public void createCategory(Category newcategory) {
		categoryrepo.save(newcategory);
	}

	public void updateCategory(Category newcategory) {
		categoryrepo.save(newcategory);
	}

	public void deleteCategory(Long id) {
		Category category;
		category = categoryrepo.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
		categoryrepo.deleteById(category.getId());
	}

}
