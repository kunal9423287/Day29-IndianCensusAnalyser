package com.codeanalyser;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class StateCodeAnalyser {
	
	public static  int LoadIndianCodeData(String csvPath) throws IOException, CodeAnalyserException {
		Reader reader;
		try {
		reader = Files.newBufferedReader(Paths.get(csvPath));
		
		@SuppressWarnings({ "unchecked", "rawtypes" })
		CsvToBean <IndianCodeCSV> csvToBean = new CsvToBeanBuilder(reader)
                                             .withType(IndianCodeCSV.class)
                                             .withIgnoreLeadingWhiteSpace(true)
                                             .build();
		Iterator<IndianCodeCSV> codeCSVIterator = csvToBean.iterator();;
		int entries = 0;
		
		while(codeCSVIterator.hasNext()) {
			entries++;
			@SuppressWarnings("unused")
			IndianCodeCSV codeData = codeCSVIterator.next();
		}
		return entries;
		}catch (IOException e) {
			throw new CodeAnalyserException(e.getMessage(),
                    CodeAnalyserException.ExceptionType.Csv_File_Problem);
		}catch (IllegalStateException e) {
			throw new CodeAnalyserException(e.getMessage(),
					CodeAnalyserException.ExceptionType.Unable_To_Parse);
	   }	
	}
	
	@SuppressWarnings("deprecation")
	public boolean LoadIndiaCodeCSVData(String csvPath) throws CodeAnalyserException, IOException {
		
		CSVReader reader;
		try {
			reader = new CSVReader(new FileReader(csvPath),'|');
			@SuppressWarnings("unused")
			String [] nextLine;
			while((nextLine=reader.readNext()) != null) {
				return true;
			}
			if(reader != null) {
				reader.close();
			}
		}catch(IllegalStateException e) {
			throw new CodeAnalyserException(e.getMessage(),
					CodeAnalyserException.ExceptionType.Unable_To_Parse);
		}
		return false;
	}
	
}
