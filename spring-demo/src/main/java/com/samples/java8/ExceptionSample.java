package com.samples.java8;

import java.io.IOException;
import java.sql.SQLException;

public class ExceptionSample {
	public static void main(String[] args) throws IOException, SQLException {
		try {
			int num = 1;
			if (num > 10) {
				throw new SQLException();
			}
			throw new IOException();
		} catch (IOException | SQLException e) {
			e.printStackTrace();
			throw (e);
		}
	}
}
