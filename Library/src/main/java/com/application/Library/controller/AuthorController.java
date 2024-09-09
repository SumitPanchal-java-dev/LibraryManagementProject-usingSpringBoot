package com.application.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Library.entity.Author;
import com.application.Library.service.AuthorService;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService authorservice;
	
	@GetMapping("/authors")
	public String listAuthors(Model model) {
		model.addAttribute("authors", authorservice.findAllAuthors());
		return "authors";
	}
	
	@GetMapping("/remove-author/{id}")
	public String deleteAuthors(@PathVariable Long id, Model model) {
		authorservice.deleteAuthor(id);
		model.addAttribute("authors", authorservice.findAllAuthors());
		return "authors";
	}

	@GetMapping("/update-author/{id}")
	public String updateAuthor(@PathVariable Long id, Model model) {
		model.addAttribute("author", authorservice.findAuthor(id));
		return "update-author";
	}

	@PostMapping("/update-author/{id}")
	public String saveUpdateAuthor(@PathVariable Long id, Author author, BindingResult bindingresult,
			Model model) {
		if (bindingresult.hasErrors()) {
			return "update-author";
		}
		authorservice.updateAuthor(author);
		model.addAttribute("authors", authorservice.findAllAuthors());
		return "redirect:/authors";

	}
	
	@GetMapping("/add-author")
	public String showCreateAuthor(Author author) {
		return "add-author";
	}

	@PostMapping("/save-author")
	public String saveAuthor(Author author, BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {
			return "add-author";
		}
		authorservice.createAuthor(author);
		model.addAttribute("authors", authorservice.findAllAuthors());
		return "redirect:/authors";
	}
	
}
