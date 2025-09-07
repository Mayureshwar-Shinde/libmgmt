package com.example.libmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libmgmt.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {

}
