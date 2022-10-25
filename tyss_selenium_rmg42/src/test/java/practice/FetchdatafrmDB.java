package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class FetchdatafrmDB {

	public static void main(String[] args) throws Throwable {
		
	//step 1 : register or load the MYsql database	
	Driver driverref=new Driver();
	DriverManager.registerDriver(driverref);
	
	//step 2 : get connect to database
	Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra", "root", "root");
	
	//step 3 : create sql statement
	Statement stat=conn.createStatement();
	String query = "select * from students";
	
	//step 4 : execute statement/query
	ResultSet result = stat.executeQuery(query);
	
	while(result.next())
	{
		System.out.println(result.getInt(1)+"\t"+result.getString(2)+"\t"+result.getString(3)+"\t"+result.getString(4));
	}
	//step 5 : close the database connection
	conn.close();
	
	}

}
