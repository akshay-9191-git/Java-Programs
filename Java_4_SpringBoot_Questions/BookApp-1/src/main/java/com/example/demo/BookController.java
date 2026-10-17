
package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.BookEntity;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookRepo bookRepository;

    public BookController(BookRepo bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Save a new book
    @PostMapping
    public BookEntity saveBook(@RequestBody BookEntity book) {
        return bookRepository.save(book);
    }

    // Get all books
    @GetMapping
    public List<BookEntity> getAllBooks() {
        return bookRepository.findAll();
    }

    // Get a book by ID
    @GetMapping("/{id}")
    public BookEntity getBookById(@PathVariable Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    
    @DeleteMapping("/{id}")
    public String Deletebook(@PathVariable Long id) {
    	if(bookRepository.existsById(id)) {
    		bookRepository.deleteById(id);
    		return "Book deleted successfully with id : "+ id;
    	}else {
    		return "Book doesn't exist";
    	}
    }
}
