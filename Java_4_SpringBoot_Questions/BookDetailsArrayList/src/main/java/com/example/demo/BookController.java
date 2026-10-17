package com.example.demo;

import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookarr")
public class BookController {
	
	private List<BookInfo> books = new ArrayList<>();
	
	@PostMapping
	public String addBookInfo(@RequestBody BookInfo book) {
		books.add(book);
		return "Book Details added successfully";
		
	}
	
	@GetMapping
	public List<BookInfo> getAllDetails() {
		return books;
	}
	
	@GetMapping("/{id}")
	public BookInfo getById(@PathVariable int id) {
		for(BookInfo b : books) {
			if(b.getId() == id) {
				return b;
			}
		}
		return null;
	}
	
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		boolean removed = books.removeIf(b->b.getId() == id);
		if(removed) {
			return "Successfully deleted book details with id: " + id;
		}else {
			return "No book found with id: "+ id;
		}
	}
	
	
	
	

}
