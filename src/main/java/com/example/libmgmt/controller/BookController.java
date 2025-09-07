package com.example.libmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libmgmt.dto.BookDTO;
import com.example.libmgmt.responsestructure.ApiResponse;
import com.example.libmgmt.service.BookService;


@RestController
@RequestMapping("/api/books")
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping
	public ResponseEntity<ApiResponse<List<BookDTO>>> getAllBooks() {
		List<BookDTO> books = bookService.findAll();
		ApiResponse<List<BookDTO>> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), books, "Records fetched successfully");
		return ResponseEntity.ok(apiResponse);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ApiResponse<BookDTO>> getBook(@PathVariable int id) {
		ApiResponse<BookDTO> apiResponse = new ApiResponse<>(HttpStatus.OK.value(), bookService.get(id), "Record fetched successfully.");
		return ResponseEntity.ok(apiResponse);
	}
}



