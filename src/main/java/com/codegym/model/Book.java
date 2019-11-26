package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Date dateOfPurchase;
    private String author;
    private Double price;
    private String image;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoryId")
    private Category category;

    public Book() {
    }

    public Book(String name, Date dateOfPurchase, String author, Double price, String image) {
        this.name = name;
        this.dateOfPurchase = dateOfPurchase;
        this.author = author;
        this.price = price;
        this.image = image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
