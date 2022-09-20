package org.sdet40.practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ModifyDataIntoDatabase {

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
		int result =statement.executeUpdate("insert into sdet40 values (1005, 'Abhishek', 8794561231,'tumakuru')");
		//verify or iterate or fetch the data
		System.out.println(result+"Data updated succesfully");
	    }
	finally
	{
	 //close the Database connection
		connection.close();//mandatory
		System.out.println("connection closed succesfully");
	}

}

}
