package com.tcs.jdbc.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger; //important
import org.slf4j.LoggerFactory;

public class JDBCDemo {
	private static final Logger logger = LoggerFactory.getLogger(JDBCDemo.class);
	public static void main(String[] args) {
		String DB_URL = "jdbc:mysql://localhost:3306/practice";
		String DB_USER = "root";
		String DB_PASSWORD = "Nuvelabs123$";
		try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement statement = connection.createStatement();) {
//			create(statement); // create
			retrieve(statement);
//			update(statement);
//			delete(statement);
			List<String> regions = retriveWithCondition(statement, "A");//regions starting with 'A'
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static List<String> retriveWithCondition(Statement statement, String string) {
		return null;
	}

	private static void update(Statement statement) {
		
	}

	private static void retrieve(Statement statement) throws SQLException {
		ResultSet resultSet = statement.executeQuery("SELECT * from regions");
		List<String> regions = new ArrayList<String>();
		while (resultSet.next()) {
			logger.debug(resultSet.getInt(1)+"");
			logger.debug(resultSet.getString("REGION_NAME"));
			regions.add(resultSet.getNString("REGION_NAME"));
			
		}
	}

	private static void create(Statement statement) throws SQLException {
		statement.execute("INSERT INTO REGIONS VALUES(2, 'North America')");
	}
}