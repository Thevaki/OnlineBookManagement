package com.libraryManagementSystem.Book.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "BookCategory")
@Table(name = "book_category")
public class BookCategory {
    @Id
    private Integer id;

    @Column(name = "categoryName")
    private String name;

    @OneToMany(mappedBy = "bookCategory")
    @JsonIgnore
    private Set<Book> books;

    public BookCategory() {
    }

    public BookCategory(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
        for (Book book : books) {
            book.setBookCategory(this);
        }
    }
}

//    @Override
//    public String toString() {
//        String result = String.format(
//                "Category[id=%d, name='%s']%n",
//                id, name);
//        if (books != null) {
//            for(Book book : books) {
//                result += String.format(
//                        "Book[id=%d, name='%s']%n",
//                        book.getBookId(), book.getBookName());
//            }
//        }
//
//        return result;
//    }

    //
//    public List<Book> getBooks() {
//        return books;
//    }
//
//    public void setBooks(List<Book> books) {
//        this.books = books;
//    }

    //    @OneToMany(
//            mappedBy = "bookCategory",
//            cascade = CascadeType.ALL
//    )
//    private List<Book> books;

//    @OneToMany(mappedBy = "bookCategory", cascade = CascadeType.PERSIST,
//            fetch = FetchType.LAZY)
//    private Set<Book> books;

