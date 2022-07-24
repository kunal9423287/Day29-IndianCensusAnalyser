package com.codeanalyser;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.censusanalyser.CensusAnalyserException;
import com.censusanalyser.StateCensusAnalyser;

public class StateCodeAnalyser_test {
	
	private static final String csvPath ="C:\\Users\\Varsha Manwal\\Desktop\\BridgeLabz\\Fellowship\\Day29_IndianStatesCensusAnalyzer\\StateCensusAnalyser\\Data\\codeFile.csv";
	private static final String csvWrongPath ="C:\\Users\\Varsha Manwal\\Desktop\\BridgeLabz\\Fellowship\\Day29_IndianStatesCensusAnalyzer\\StateCensusAnalyser\\codeFile.csv";
	private static final String pdfPath ="C:\\Users\\Varsha Manwal\\Desktop\\BridgeLabz\\Fellowship\\Day29_IndianStatesCensusAnalyzer\\StateCensusAnalyser\\Data\\codeFile.pdf";
	
	@Test
	public void givenCodeCsvFile_returnCorrectRecords() throws IOException, CodeAnalyserException {
		StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
		int recordsNumb = stateCodeAnalyser.LoadIndianCodeData(csvPath);
		assertEquals(640,recordsNumb);	
	}
	
	@Test
	public void given_IndiaCodeData_CsvFile_ShouldThrowException() throws IOException {
		try {
			StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CodeAnalyserException.class);
			stateCodeAnalyser.LoadIndianCodeData(csvWrongPath);
		} catch(CodeAnalyserException e) {
		    assertEquals(CodeAnalyserException.ExceptionType.Csv_File_Problem, e.type);
		}
	}
	
	@Test
	public void given_IndiaCodeData_withWrongCsvFile_ShouldThrowException() throws IOException {
		try {
			StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CodeAnalyserException.class);
			stateCodeAnalyser.LoadIndianCodeData(pdfPath);
		} catch(CodeAnalyserException e) {
		    assertEquals(CodeAnalyserException.ExceptionType.Unable_To_Parse, e.type);
		}
	}
	
	@Test
	public void given_IndiaCensusData_WithWrongDelimeter_ShoulThrowException() throws IOException {
		try {
			StateCodeAnalyser stateCodeAnalyser = new StateCodeAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CodeAnalyserException.class);
			stateCodeAnalyser.LoadIndianCodeData(csvPath);
		}catch(CodeAnalyserException e) {
			 assertEquals(CodeAnalyserException.ExceptionType.Unable_To_Parse, e.type);
		}
	}

}
