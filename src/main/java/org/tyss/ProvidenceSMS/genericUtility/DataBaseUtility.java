package org.tyss.ProvidenceSMS.genericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.jdbc.Driver;


public class DataBaseUtility {
Connection connection;
	public void openDBConnection(String dburl, String dbun, String dbpwd) throws SQLException
	{
		Driver dbDriver = new Driver();
		DriverManager.registerDriver(dbDriver);
		connection=DriverManager.getConnection(dburl, dbun, dbpwd);
		
		
	}
	public List<String> getDataFromDB(String query, String coloumnName) throws SQLException 
	{
		Statement statement = connection.createStatement();
		ResultSet result = statement.executeQuery(query);
		List<String> list =  new ArrayList<>();
		while(result.next())
		{
			list.add(result.getString(coloumnName));
		}
		return list;
	}
	
	public void closeDB() throws SQLException {
		connection.close();
	}

}
