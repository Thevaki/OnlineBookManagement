package com.libraryManagementSystem.Book.Model;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @NotBlank(message = "Book name cannot be empty")
    private String bookName;

    @NotBlank(message = "Author cannot be empty")
    private String author;

    @NotBlank(message = "Image url cannot be empty")
    @URL(message = "Enter valid image url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name="book_category_id", nullable=false)
    private BookCategory bookCategory;

    public Book() {

    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    public Book(String bookName, BookCategory bookCategory) {
        this.bookName = bookName;
        this.bookCategory = bookCategory;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BookCategory getBookCategory() {
        return bookCategory;
    }

    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}

