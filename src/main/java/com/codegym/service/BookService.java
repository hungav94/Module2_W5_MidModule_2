package com.codegym.service;

import com.codegym.model.Book;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    Book findById(Long id);

    void save(Book book);

    void remove(Long id);

    Iterable<Book> findAllByCategory(Category category);

    Page<Book> findAllByPrice(Double price, Pageable pageable);

    Page<Book> findAllByOrderByPriceDesc(Pageable pageable);

    Page<Book> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Book> findAllByOrderByDateOfPurchaseAsc(Pageable pageable);

    Page<Book> findAllByOrderByDateOfPurchaseDesc(Pageable pageable);
}
