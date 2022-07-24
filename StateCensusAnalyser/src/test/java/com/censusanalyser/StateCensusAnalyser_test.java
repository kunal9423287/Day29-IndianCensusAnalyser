package com.censusanalyser;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StateCensusAnalyser_test {
	
	private static final String csvPath ="C:\\Users\\Varsha Manwal\\Desktop\\BridgeLabz\\Fellowship\\Day29_IndianStatesCensusAnalyzer\\StateCensusAnalyser\\Data\\censusFile.csv";
	private static final String csvWrongPath = "C:\\Users\\Varsha Manwal\\Desktop\\BridgeLabz\\Fellowship\\Day29_IndianStatesCensusAnalyzer\\CensusAnalyser\\data\\censusFile.csv";
	private static final String pdfPath ="C:\\Users\\Varsha Manwal\\Desktop\\BridgeLabz\\Fellowship\\Day29_IndianStatesCensusAnalyzer\\StateCensusAnalyser\\Data\\censusFile.pdf";
	
	@Test
	public void givenCensusCsvFile_returnCorrectRecords() throws IOException, CensusAnalyserException {
		StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
		int recordsNumb = stateCensusAnalyser.LoadIndiaCensusData(csvPath);
		assertEquals(640,recordsNumb);	
	}
	
	@Test
	public void given_IndiaCensusData_CsvFile_ShouldThrowException() throws IOException {
		try {
			StateCensusAnalyser censusAnalyZer = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyZer.LoadIndiaCensusData(csvWrongPath);
		} catch(CensusAnalyserException e) {
		    assertEquals(CensusAnalyserException.ExceptionType.Csv_File_Problem, e.type);
		}
	}
	
	@Test
	public void given_IndiaCensusData_WithWrongFile_ShoulThrowException() throws IOException {
		try {
			StateCensusAnalyser censusAnalyZer = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyZer.LoadIndiaCensusData(pdfPath);
		} catch(CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.Unable_To_Parse, e.type);
		}
	}
	
	@Test
	public void given_IndiaCensusData_WithWrongDelimeter_ShoulThrowException() throws IOException {
		try {
			StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
			ExpectedException exceptionRule = ExpectedException.none();
			exceptionRule.expect(CensusAnalyserException.class);
			censusAnalyser.LoadIndiaCensusCSVData(csvPath);
		} catch(CensusAnalyserException e) {
			assertEquals(CensusAnalyserException.ExceptionType.Unable_To_Parse, e.type);
		}
	}

}
