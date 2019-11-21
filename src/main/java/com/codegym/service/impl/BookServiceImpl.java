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
    public Iterable<Book> findAllByCategory(Category category) {
        return bookRepository.findAllByCategory(category);
    }

    @Override
    public Page<Book> findAllByPrice(Double price, Pageable pageable) {
        return bookRepository.findAllByPrice(price, pageable);
    }

    @Override
    public Page<Book> findAllByOrderByPriceDesc(Pageable pageable) {
        return bookRepository.findAllByOrderByPriceDesc(pageable);
    }

    @Override
    public Page<Book> findAllByOrderByPriceAsc(Pageable pageable) {
        return bookRepository.findAllByOrderByPriceAsc(pageable);
    }

    @Override
    public Page<Book> findAllByOrderByDateOfPurchaseAsc(Pageable pageable) {
        return bookRepository.findAllByOrderByDateOfPurchaseAsc(pageable);
    }

    @Override
    public Page<Book> findAllByOrderByDateOfPurchaseDesc(Pageable pageable) {
        return bookRepository.findAllByOrderByDateOfPurchaseDesc(pageable);
    }
}
