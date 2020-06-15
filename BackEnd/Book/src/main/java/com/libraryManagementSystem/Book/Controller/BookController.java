package com.libraryManagementSystem.Book.Controller;

import com.libraryManagementSystem.Book.Model.Book;
import com.libraryManagementSystem.Book.Model.BookCategory;
import com.libraryManagementSystem.Book.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Book")
@XmlRootElement
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value = "/createBook" , method = RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @RequestMapping(value = "/editBook",method = RequestMethod.PUT)
    public Book editBook(@RequestBody Book book){return bookService.editBook(book);}

    @RequestMapping(value = "/deleteBook/{id}",method = RequestMethod.DELETE)
    public Book deleteBook(@PathVariable("id") Integer id){return bookService.deleteBook(id);}

    @RequestMapping(value="/findBook/{id}",method = RequestMethod.GET)
    public Book findBook(@PathVariable("id") Integer id){
        return bookService.findBook(id);
    }

    @RequestMapping(value="/fetchAllBooks",method = RequestMethod.GET)
    public List<Book> fetchAllBooks(){
        return bookService.fetchAllBooks();
    }

    @RequestMapping(value="/searchBooks/{bookName}",method = RequestMethod.GET)
    public List<Book> searchBooks(@PathVariable("bookName") String bookName){
        return bookService.searchBooks(bookName);
    }

    @RequestMapping(value="/fetchAllCategories",method = RequestMethod.GET)
    public List<BookCategory> fetchAllCategories(){
        return bookService.fetchAllCategories();
    }

    @RequestMapping(value="/findCategoryBooks/{id}",method = RequestMethod.GET)
    public List<Book> findCategoryBooks(@PathVariable("id") Integer id){
        return bookService.findCategoryBooks(id);
    }

//    @RequestMapping(value="/categoryBooks/{category}",method = RequestMethod.GET)
//    public List<Book> categoryBooks(@PathVariable("category") String category){
//        return bookService.categoryBooks(category);
//    }

}
