package com.baeldung.jparepository;

import com.baeldung.jparepository.model.Book;
import com.baeldung.jparepository.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JpaRepositoryApplicationTests {

	@Autowired
	private BookService bookService;

	@BeforeEach
	void insertBooksIntoDatabase() {
		bookService.insertBook(new Book("Altorių šėšėly"));
		bookService.insertBook(new Book("Dievų miškas"));
		bookService.insertBook(new Book("Simtas metu vienatves"));
	}

	@Test
	void verifyBooksInDB() {
		List<Book> books = bookService.list();
		printBooks(books);
		Assertions.assertEquals(books.size(), 3);
	}

	void printBooks(List<Book> list) {
		System.out.println("Knygu sarasas:");
		for (Book book : list) {
			System.out.println(book);
		}
	}
}
