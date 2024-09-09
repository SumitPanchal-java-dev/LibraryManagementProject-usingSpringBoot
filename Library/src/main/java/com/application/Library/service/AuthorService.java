package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Author;
import com.application.Library.repository.AuthorRepository;

@Service
public class AuthorService {

	@Autowired
	AuthorRepository authorrepo;
	
	public List<Author> findAllAuthors(){
		return authorrepo.findAll();
	}
	
	
	public Author findAuthor(Long id) {
		Author author = authorrepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
		return author;
	}
	
	public void createAuthor(Author newAuthor) {
		authorrepo.save(newAuthor);
	}
	
	
	public void updateAuthor(Author newAuthor) {
		authorrepo.save(newAuthor);
	}
	
	public void deleteAuthor(Long id) {
		Author author = authorrepo.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
		authorrepo.deleteById(author.getId());
	}
}

