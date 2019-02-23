package com.cts.payroll.app;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class ErrorLogWriter {

	public static void logError(String message) 
			throws PayrollAppException {
		FileWriter writer = null;
		String fileNameWithPath = "D:\\TaxProcessor\\error.log";
		try {
			writer = new FileWriter(fileNameWithPath);
			writer.write(new Date() + " " + message);
		} catch (IOException e) {
			e.printStackTrace();
			throw new PayrollAppException("Error when writing file '" 
				+ fileNameWithPath + "'. Exception message: " 
				+ e.getMessage());
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String args[]) {
		try {
			ErrorLogWriter.logError("Error when reading file");
		} catch (PayrollAppException e) {
			e.printStackTrace();
		}
	}
}
