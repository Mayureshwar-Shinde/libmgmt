package com.example.libmgmt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libmgmt.dto.BookDTO;
import com.example.libmgmt.entity.Book;
import com.example.libmgmt.exception.DoesNotExistException;
import com.example.libmgmt.repository.BookRepository;
import com.example.libmgmt.repository.LibraryRepository;


@Service
public class BookService {
	@Autowired LibraryRepository libraryRepository;
	@Autowired BookRepository bookRepository;

	public List<BookDTO> findAll() {
		List<Book> books = bookRepository.findAll();
		List<BookDTO> booksDTO = new ArrayList<>(books.size());
		for (Book book : books) {
			booksDTO.add(mapToDTO(book));
		}
		return booksDTO;
	}

	public BookDTO get(int id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new DoesNotExistException("Book with ID: " + id + " does not exist."));
		return mapToDTO(book);
	}

	public BookDTO create(BookDTO bookDTO) {
		Book book = bookRepository.save(mapToEntity(bookDTO, new Book()));
		return mapToDTO(book);
	}

	public BookDTO update(BookDTO bookDTO, int id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new DoesNotExistException("Book with ID: " + id + " does not exist."));
		mapToEntity(bookDTO, book);
		Book updatedBook = bookRepository.save(book);
		return mapToDTO(updatedBook);
	}

	public void delete(int id) {
		Book book = bookRepository.findById(id)
				.orElseThrow(() -> new DoesNotExistException("Book with ID: " + id + " does not exist."));
		bookRepository.delete(book);
	}

	public BookDTO mapToDTO(Book book) {
		BookDTO bookDTO = new BookDTO();
		bookDTO.setId(book.getId());
		bookDTO.setName(book.getName());
		bookDTO.setAuthor(book.getAuthor());
		bookDTO.setDescription(book.getDescription());
		bookDTO.setLibraryId(book.getLibrary() == null ? null : book.getLibrary().getId());
		return bookDTO;
	}

	public Book mapToEntity(BookDTO bookDTO, Book book) {
		book.setAuthor(bookDTO.getAuthor());
		book.setName(bookDTO.getName());
		book.setDescription(bookDTO.getDescription());
		book.setLibrary(bookDTO.getLibraryId() == null ? null
				: libraryRepository.findById(bookDTO.getLibraryId()).orElseThrow(() -> new DoesNotExistException(
						"Library with ID: " + bookDTO.getLibraryId() + " does not exist.")));
		return book;
	}
}



