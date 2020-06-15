package com.libraryManagementSystem.Book.Repository;

import com.libraryManagementSystem.Book.Model.Book;
import com.libraryManagementSystem.Book.Model.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookCategotyRepository extends JpaRepository<BookCategory,Integer> {
}
