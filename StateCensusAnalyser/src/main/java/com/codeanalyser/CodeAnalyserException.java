package com.codeanalyser;

public class CodeAnalyserException extends Exception {
	
	enum ExceptionType {
		
		 Unable_To_Parse, Csv_File_Problem
	}
	
	ExceptionType type;
	
	public CodeAnalyserException(String message,ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CodeAnalyserException( ExceptionType type, String message, Throwable cause) {
		super(message, cause);
		this.type = type;
	}

}
