package com.baeldung.jparepository.service;

import com.baeldung.jparepository.model.Book;
import com.baeldung.jparepository.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> list() {
        return bookRepository.findAllEntities();
    }


    public void insertBook(Book book) {
        bookRepository.insertEntity(book);
    }
}
