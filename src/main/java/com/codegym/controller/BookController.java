package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;


@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/book")
    public ModelAndView showListBook(@RequestParam("s") Optional<String> s, @PageableDefault(size = 2) Pageable pageable) {
        Page<Book> books;
        if (s.isPresent()) {
            Double d = Double.parseDouble(s.get());
            books = bookService.findAllByPriceContaining(d, pageable);
        } else {
            books = bookService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/create-book")
    public ModelAndView showCreateBook() {
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create-book")
    public ModelAndView saveBook(@ModelAttribute Book book) {
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("book/create");
        modelAndView.addObject("book", new Book());
        modelAndView.addObject("message", "Create book successfully");
        return modelAndView;
    }

    @GetMapping("/edit-book/{id}")
    public ModelAndView showEditBook(@PathVariable Long id) {
        Book book = bookService.findById(id);
        ModelAndView modelAndView = null;
        if (book != null) {
            modelAndView = new ModelAndView("book/edit");
            modelAndView.addObject("book", book);
        } else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }

    @PostMapping("edit-book")
    public ModelAndView updateBook(@ModelAttribute Book book) {
        bookService.save(book);
        ModelAndView modelAndView = new ModelAndView("book/edit");
        modelAndView.addObject("book", book);
        modelAndView.addObject("message", "Edit book successfully");
        return modelAndView;
    }

    @GetMapping("/delete-book/{id}")
    public ModelAndView deleteBook(@PathVariable Long id) {
        bookService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:book");
        return modelAndView;
    }
}