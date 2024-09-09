package com.application.Library;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.application.Library.entity.Author;
import com.application.Library.entity.Book;
import com.application.Library.entity.Category;
import com.application.Library.entity.Publisher;
import com.application.Library.service.BookService;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	
	//Adding up some dummy data
	
	@Bean
	public CommandLineRunner initialCreate(BookService bookservice) {
		return (args) -> {
			// Book 1
			Book book1 = new Book("ISBN12345", "Effective Java", "A comprehensive guide to programming with Java.");
			Author author1 = new Author("Joshua Bloch", "Renowned author and software engineer.");
			Category category1 = new Category("Programming");
			Publisher publisher1 = new Publisher("Addison-Wesley");
			book1.addAuthor(author1);
			book1.addCategory(category1);
			book1.addPublisher(publisher1);
			bookservice.createBook(book1);

			// Book 2
			Book book2 = new Book("ISBN67890", "Clean Code", "A Handbook of Agile Software Craftsmanship.");
			Author author2 = new Author("Robert C. Martin", "A well-known software engineer and author.");
			Category category2 = new Category("Software Engineering");
			Publisher publisher2 = new Publisher("Prentice Hall");
			book2.addAuthor(author2);
			book2.addCategory(category2);
			book2.addPublisher(publisher2);
			bookservice.createBook(book2);

			// Book 3
			Book book3 = new Book("ISBN11223", "Java Concurrency in Practice", "Thread safety and concurrency in Java.");
			Author author3 = new Author("Brian Goetz", "Expert in Java concurrency and software engineering.");
			Category category3 = new Category("Concurrency");
			Publisher publisher3 = new Publisher("Addison-Wesley");
			book3.addAuthor(author3);
			book3.addCategory(category3);
			book3.addPublisher(publisher3);
			bookservice.createBook(book3);

			// Book 4
			Book book4 = new Book("ISBN44556", "Head First Design Patterns", "A learner's guide to design patterns in Java.");
			Author author4 = new Author("Eric Freeman", "Author and consultant specializing in software design.");
			Category category4 = new Category("Design Patterns");
			Publisher publisher4 = new Publisher("O'Reilly Media");
			book4.addAuthor(author4);
			book4.addCategory(category4);
			book4.addPublisher(publisher4);
			bookservice.createBook(book4);

			// Book 5
			Book book5 = new Book("ISBN78901", "Spring in Action", "Comprehensive guide to Spring Framework.");
			Author author5 = new Author("Craig Walls", "Spring framework expert and author.");
			Category category5 = new Category("Frameworks");
			Publisher publisher5 = new Publisher("Manning Publications");
			book5.addAuthor(author5);
			book5.addCategory(category5);
			book5.addPublisher(publisher5);
			bookservice.createBook(book5);

			
		};
	}

}
