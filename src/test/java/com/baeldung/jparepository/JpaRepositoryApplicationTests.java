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
		bookService.insertBook(new Book(1L, "Altoriu sesely"));
		bookService.insertBook(new Book(2L, "Dievu miskas"));
		bookService.insertBook(new Book(3L, "Simtas metu vienatves"));
	}

	@Test
	void whenApplicationStarts_thenHibernateCreatesInitialRecords() {
		List<Book> books = bookService.list();

		Assertions.assertEquals(books.size(), 3);
	}
}
