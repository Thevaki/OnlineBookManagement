package com.libraryManagementSystem.Book.Repository;

import com.libraryManagementSystem.Book.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByBookNameContainingIgnoreCase(String bookName);

    List<Book> findByBookCategoryId(Integer id);
   // List<Book> findByCategoryContainingIgnoreCase(String category);
}
