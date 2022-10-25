package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class InsertdatatoDB {

	public static void main(String[] args) throws Throwable {
		
		Driver driverref=new Driver();
		DriverManager.registerDriver(driverref);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test_yantra", "root", "root");
		Statement stat=conn.createStatement();
		String query = "insert into students(first_name,last_name,address)values('mahesh','kencha','aloor_k')";
		int result = stat.executeUpdate(query);
		if(result==1)
		{
			System.out.println("user is created");
		}
		else
		{
			System.out.println("user is not created");
		}
		conn.close();
	}

}
