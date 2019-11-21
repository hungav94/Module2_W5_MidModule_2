package com.codegym.controller;

import com.codegym.model.Book;
import com.codegym.model.Category;
import com.codegym.service.BookService;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    private BookService bookService;

    @GetMapping("/category")
    public ModelAndView showListCategory() {
        Iterable<Category> category = categoryService.findAll();
        ModelAndView modelAndView = new ModelAndView("category/list");
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @GetMapping("/create-category")
    public ModelAndView showCreateCategory() {
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        return modelAndView;
    }

    @PostMapping("/create-category")
    public ModelAndView saveCategory(@ModelAttribute("category") Category category) {
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category", new Category());
        modelAndView.addObject("message", "Create category successfully");
        return modelAndView;
    }

    @GetMapping("/edit-category/{id}")
    public ModelAndView showEditCategory(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        ModelAndView modelAndView = null;
        if (category != null) {
            modelAndView = new ModelAndView("category/edit");
            modelAndView.addObject("category", category);
        } else {
            modelAndView = new ModelAndView("error-404");
        }
        return modelAndView;
    }

    @PostMapping("/edit-category")
    public ModelAndView updateCategory(@ModelAttribute("category") Category category){
        categoryService.save(category);
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category", category);
        modelAndView.addObject("message", "Edit category successfully");
        return modelAndView;
    }

    @GetMapping("/delete-category/{id}")
    public ModelAndView deleteCategory(@PathVariable Long id){
        categoryService.remove(id);
        ModelAndView modelAndView = new ModelAndView("redirect:/category");
        return modelAndView;
    }

    @GetMapping("/view-category/{id}")
    public ModelAndView viewCategory(@PathVariable Long id){
        Category category = categoryService.findById(id);
        if (category == null){
            return new ModelAndView("error-404");
        }

        Iterable<Book> books = bookService.findAllByCategory(category);
        ModelAndView modelAndView = new ModelAndView("category/view");
        modelAndView.addObject("category", category);
        modelAndView.addObject("books", books);
        return modelAndView;
    }
}
