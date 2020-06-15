package com.libraryManagementSystem.Book.Service;

import com.libraryManagementSystem.Book.Model.Book;
import com.libraryManagementSystem.Book.Model.BookCategory;

import java.util.List;
import java.util.Optional;

public interface BookService {
    Book createBook(Book book);

    Book editBook(Book book);

    Book deleteBook(Integer id);

    Book findBook(Integer id);

    List<Book> fetchAllBooks();

    List<Book> searchBooks(String title);

    List<BookCategory> fetchAllCategories();

    List<Book> findCategoryBooks(Integer id);

    //List<Book> categoryBooks(String category);
}
