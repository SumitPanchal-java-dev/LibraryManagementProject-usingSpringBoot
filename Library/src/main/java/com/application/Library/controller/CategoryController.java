package com.application.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Library.entity.Category;
import com.application.Library.service.CategoryService;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService categoryservice;

	@GetMapping("/categories")
	public String findAllCategories(Model model) {
		model.addAttribute("categories", categoryservice.findAllCategory());
		return "categories";
	}

	@GetMapping("/remove-category/{id}")
	public String deleteCategory(@PathVariable Long id, Model model) {
		categoryservice.deleteCategory(id);
		model.addAttribute("categories", categoryservice.findAllCategory());
		return "categories";
	}

	@GetMapping("/update-category/{id}")
	public String updateCategory(@PathVariable Long id, Model model) {
		model.addAttribute("category", categoryservice.findCategory(id));
		return "update-category";
	}

	@PostMapping("/update-category/{id}")
	public String saveCategory(@PathVariable Long id, Category category, BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {
			return "update-category";
		}
		categoryservice.updateCategory(category);
		model.addAttribute("categories", categoryservice.findAllCategory());
		return "redirect:/categories";
	}

	@GetMapping("/add-category")
	public String showCreateCategory(Category category) {
		return "add-category";
	}

	@PostMapping("/save-category")
	public String saveCategory(Category category, BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {
			return "add-category";
		}
		categoryservice.createCategory(category);
		model.addAttribute("categories", categoryservice.findAllCategory());
		return "redirect:/categories";
	}

}
