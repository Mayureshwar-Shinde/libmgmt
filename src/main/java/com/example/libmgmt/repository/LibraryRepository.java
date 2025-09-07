package com.example.libmgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.libmgmt.entity.Library;

public interface LibraryRepository extends JpaRepository<Library, Integer> {

}
