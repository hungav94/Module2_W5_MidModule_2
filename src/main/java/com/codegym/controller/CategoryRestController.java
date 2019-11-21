package com.codegym.controller;

import com.codegym.model.Category;
import com.codegym.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CategoryRestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/restCategory/")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        Iterable<Category> categories = categoryService.findAll();
        if (categories == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping(value = "/restCategory/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> getCategory(@PathVariable("id") Long id) {
        System.out.println("Fetching Category with id" + id);
        Category category = categoryService.findById(id);
        if (category == null) {
            System.out.println("Customer with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(category, HttpStatus.OK);
    }

    @PostMapping("/restCategory/")
    public ResponseEntity<Void> createCategory(@RequestBody Category category, UriComponentsBuilder uriComponentsBuilder) {
        System.out.println("Creating Category " + category.getName());
        categoryService.save(category);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/restCategory/{id}").buildAndExpand(category.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PutMapping("/restCategory/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable("id") Long id, @RequestBody Category category) {
        System.out.println("Updating category " + id);
        Category currentCategory = categoryService.findById(id);
        if (currentCategory == null) {
            System.out.println("Category with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        currentCategory.setId(category.getId());
        currentCategory.setName(category.getName());
        currentCategory.setDescription(category.getDescription());

        categoryService.save(currentCategory);
        return new ResponseEntity<>(currentCategory, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Category> deleteCategory(@PathVariable("id") Long id){
        System.out.println("Fetching & Deleting Category with id " + id);
        Category category = categoryService.findById(id);
        if (category == null){
            System.out.println("Unable to delete. Category with id " + id + " not found");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        categoryService.remove(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
