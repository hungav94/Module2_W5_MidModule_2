package com.codegym.service.impl;

import com.codegym.model.Book;
import com.codegym.model.Category;
import com.codegym.repository.BookRepository;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findOne(id);
    }

    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public void remove(Long id) {
        bookRepository.delete(id);
    }

    @Override
    public Iterable<Book> findAllByCategoryContaining(Category category) {
        return bookRepository.findAllByCategoryContaining(category);
    }

    @Override
    public Page<Book> findAllByPriceContaining(Double price, Pageable pageable) {
        return bookRepository.findAllByPriceContaining(price, pageable);
    }
}
