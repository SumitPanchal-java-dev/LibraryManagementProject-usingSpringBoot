package com.application.Library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.Library.entity.Category;
import com.application.Library.entity.Publisher;
import com.application.Library.service.PublisherService;

@RestController
public class PublisherController {

	@Autowired
	private PublisherService publisherservice;

	@GetMapping("/publishers")
	public String findAllPublishers(Model model) {
		model.addAttribute("publishers", publisherservice.finadAllPublisher());
		return "publishers";
	}

	@GetMapping("/remove-publisher/{id}")
	public String deletePublisher(@PathVariable Long id, Model model) {
		publisherservice.deletePublisher(id);
		model.addAttribute("publishers", publisherservice.finadAllPublisher());
		return "publishers";
	}

	@GetMapping("/update-publishers/{id}")
	public String updatePublisher(@PathVariable Long id, Model model) {
		model.addAttribute("publisher", publisherservice.findPublisher(id));
		return "update-publisher";
	}

	@PostMapping("/update-publisher/{id}")
	public String saveUpdatePublisher(@PathVariable Long id, Publisher publisher, BindingResult bindingresult,
			Model model) {
		if (bindingresult.hasErrors()) {
			return "update-publisher";
		}
		publisherservice.updatePublisher(publisher);
		model.addAttribute("publishers", publisherservice.findPublisher(id));
		return "redirect:/publishers";

	}
	
	@GetMapping("/add-publisher")
	public String showCreatePublisher(Publisher publisher) {
		return "add-publisher";
	}

	@PostMapping("/save-publisher")
	public String savePublisher(Publisher publisher, BindingResult bindingresult, Model model) {
		if (bindingresult.hasErrors()) {
			return "add-publisher";
		}
		publisherservice.createPublisher(publisher);
		model.addAttribute("publishers", publisherservice.finadAllPublisher());
		return "redirect:/publishers";
	}

}
