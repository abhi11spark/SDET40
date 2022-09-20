package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchDataFromDatabase {

	public static void main(String[] args) throws SQLException {
		//create object for the driver
		Driver dbdriver =new Driver();
		//register the driver instance the jdbc
		DriverManager.registerDriver(dbdriver);
		//get/establish the database connection
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/providence","root","root");
		try {
			//create the statement
			Statement statement = connection.createStatement();
			//Execute the query
			 ResultSet result = statement.executeQuery("select * from commondata");
			 //verify or iterate or fetch data
			 while(result.next()) {
				 System.out.println(result.getString("emp_name"));
			 }
		}
			 finally {
				 //close the db connection
				 connection.close();//mandatory
				 System.out.println("connection close succesfully");
			 }

	
	}	
	
}
