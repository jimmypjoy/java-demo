package com.samples.java;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class JDBCDemo {
	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String url = "jdbc:mysql://localhost:3306/demo?useSSL=false";
			String user = "root";
			String password = "root";

			connection = DriverManager.getConnection(url, user, password);
			System.out.println("Database metadata");
			DatabaseMetaData databaseMetaData = connection.getMetaData();
			System.out.println("Supports ResultSet.TYPE_SCROLL_INSENSITIVE: "
					+ databaseMetaData.supportsResultSetType(ResultSet.TYPE_SCROLL_INSENSITIVE));
			System.out.println("Supports ResultSet.CONCUR_UPDATABLE: " + databaseMetaData
					.supportsResultSetConcurrency(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE));

			statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
			String query = "select * from CUSTOMER";
			resultSet = statement.executeQuery(query);
			System.out.println("Printing resultset metadata####");
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			System.out.println("Column count : " + resultSetMetaData.getColumnCount());
			System.out.println("Table Name : " + resultSetMetaData.getTableName(1));
			System.out.println("Coulmun Name : " + resultSetMetaData.getColumnName(1));
			System.out.println("Coulmun Size : " + resultSetMetaData.getColumnDisplaySize(1));
			System.out.println("Printing total rows with scroll####");
			if (resultSet.last()) {
				int totalRows = resultSet.getRow();
				System.out.println("Total rows: " + totalRows);
				resultSet.beforeFirst();
			}
			System.out.println("Printing result ####");
			System.out.println("Id, first_name, last_name ,email");
			while (resultSet.next()) {
				System.out.println(resultSet.getInt("id") + "," + resultSet.getString("first_name") + ", :"
						+ resultSet.getString("last_name") + " ,:" + resultSet.getString("email"));
				if (resultSet.getInt("id") == 1) {
					System.out.println("Updating resultset ####");
					resultSet.updateString("first_name", "David1");
					resultSet.updateRow();
				}
			}
			resultSet.close();
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
