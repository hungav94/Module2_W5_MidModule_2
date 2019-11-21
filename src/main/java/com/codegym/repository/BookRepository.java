package com.codegym.repository;

import com.codegym.model.Book;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    Iterable<Book> findAllByCategory(Category category);

    Page<Book> findAllByPrice(Double price, Pageable pageable);

    Page<Book> findAllByOrderByPriceDesc(Pageable pageable);

    Page<Book> findAllByOrderByPriceAsc(Pageable pageable);

    Page<Book> findAllByOrderByDateOfPurchaseAsc(Pageable pageable);

    Page<Book> findAllByOrderByDateOfPurchaseDesc(Pageable pageable);
}
