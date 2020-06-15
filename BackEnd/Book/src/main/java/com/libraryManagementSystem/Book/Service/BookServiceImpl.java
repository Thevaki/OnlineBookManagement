package com.libraryManagementSystem.Book.Service;

import com.libraryManagementSystem.Book.Model.Book;
import com.libraryManagementSystem.Book.Model.BookCategory;
import com.libraryManagementSystem.Book.Repository.BookCategotyRepository;
import com.libraryManagementSystem.Book.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookCategotyRepository bookCategotyRepository;

    @Override
    public Book createBook(Book book){
        return bookRepository.saveAndFlush(book);
    }

    public Book editBook(Book book){return bookRepository.save(book);}

    public Book deleteBook(Integer id){
        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent()) {
            bookRepository.deleteById(id);
            return book.get();
        }
        return null;

    }

    public Book findBook(Integer id){
        Optional<Book> book = bookRepository.findById(id);

        if(book.isPresent()) {
            return book.get();
        }
        return null;
    }

    public List<Book> fetchAllBooks(){
        List<Book> books = bookRepository.findAll();

        if(books.isEmpty()){
            return null;
        }
        return  books;
    }

    public List<Book> searchBooks(String bookName){
        List<Book> books = bookRepository.findByBookNameContainingIgnoreCase(bookName);

        if(books.isEmpty()){
            return null;
        }
        return  books;
    }

    public List<BookCategory> fetchAllCategories(){
        List<BookCategory> categories = bookCategotyRepository.findAll();

        if(categories.isEmpty()){
            return null;
        }
        return  categories;
    }

    public List<Book> findCategoryBooks(Integer id){
        List<Book> categoryBooks = bookRepository.findByBookCategoryId(id);

        if(categoryBooks.isEmpty()){
            return null;
        }
        return  categoryBooks;
    }

//    public List<Book> categoryBooks(String category){
//        List<Book> books = bookRepository.findByCategoryContainingIgnoreCase(category);
//
//        if(books.isEmpty()){
//            return null;
//        }
//        return  books;
//    }
}
