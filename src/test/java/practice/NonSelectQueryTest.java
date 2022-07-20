package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
       
	
	public static void main(String[] args) throws Throwable {
		Connection conn=null;
		// if it is a non select query return type is int i.e +1 or -1
		int result=0;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","root");
	   Statement stat=conn.createStatement();
	   result=stat.executeUpdate("insert into students_info (regno, firstname, middlename, lastname) values('9', 'Gokul','Kanan', 'T')");
		}
		catch(Exception e)
		{
		}
 finally
 {
	if(result==1)
		System.out.println("Project inserted successfully");
	else
	{
		System.out.println(result);
		//err because to get in red colour
		System.err.println("Project is not inserted");
	}
	 conn.close();
 }
		
		System.out.println("====== close database connection");
	}

}