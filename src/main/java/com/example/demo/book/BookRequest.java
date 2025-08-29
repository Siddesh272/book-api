package com.example.demo.book;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;

public class BookRequest {

    @NotBlank(message="title is required")
    private String title;
    @NotBlank(message="author is required")
    private String author;
    @PositiveOrZero(message="price must be >= 0")
    private double price;

    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public double getPrice(){return price;}

    public void setTitle(String title){this.title=title;}
    public void setAuthor(String author){this.author=author;}
    public void setPrice(double price){this.price=price;}


}
