package org.sdet40.practice;

import java.sql.SQLException;
import java.util.List;

import org.tyss.ProvidenceSMS.genericUtility.DataBaseUtility;
import org.tyss.ProvidenceSMS.genericUtility.IConstantUtility;

public class FetchDataFRromDataBase {

	public static void main(String[] args) throws SQLException {
		DataBaseUtility databaseUtility = new DataBaseUtility();
		//open connection
		databaseUtility.openDBConnection(IConstantUtility.DB_URL, "root", "root");
		List<String> data = databaseUtility.getDataFromDB("select * from sdet40;", "Emp_Table");
		System.out.println(data);
		databaseUtility.closeDB();
	}

}
