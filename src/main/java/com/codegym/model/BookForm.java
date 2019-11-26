package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.sql.Date;

public class BookForm {
    private Long id;
    private String name;
    private Date dateOfPurchase;
    private String author;
    private Double price;
    private MultipartFile image;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    public BookForm() {
    }

    public BookForm(Long id, String name, Date dateOfPurchase, String author, Double price, MultipartFile image, Category category) {
        this.id = id;
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.author = author;
        this.price = price;
        this.image = image;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
