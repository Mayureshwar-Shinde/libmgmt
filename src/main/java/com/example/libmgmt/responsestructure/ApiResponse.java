package com.example.libmgmt.responsestructure;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse <T> {
	private int code;
	private T data;
	private String message;
}

