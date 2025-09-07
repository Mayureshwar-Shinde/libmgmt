package com.example.libmgmt.dto;

import java.util.Set;
import lombok.Data;

@Data
public class LibraryDTO {
	private int id;
	private String name;
	private String location;
	private Set<BookDTO> books;
}

