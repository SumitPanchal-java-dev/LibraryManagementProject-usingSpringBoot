package com.application.Library.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.application.Library.entity.Book;
import com.application.Library.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookrepo;

	public List<Book> findAllBooks() {
		return bookrepo.findAll();
	}
	
	public Book findBook(Long id) {
		Book book;
		book = bookrepo.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
		return book;
	}

	public void createBook(Book newBook) {
		bookrepo.save(newBook);
	}
	
	public void updateBook(Book newBook) {
		bookrepo.save(newBook);
	}
	
	public void deleteBook(Long id) {
		Book book;
		book = bookrepo.findById(id).orElseThrow(() -> new RuntimeException("Book not Found"));
		bookrepo.deleteById(book.getId());
	}
	
}
