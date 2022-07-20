package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.crm.kiboko.GenericUtility.Iconstants;
import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {

	public static void main(String[] args) throws Throwable {

		Driver driver=new Driver();
		//Step 1: load or register mysql database
		DriverManager.registerDriver(driver);
		
		// Step 2: connect to database
		Connection conn = DriverManager.getConnection(Iconstants.JDBC_URL_String, Iconstants.JDBC_Username,Iconstants.JDBC_Password);
		
		//step 3: create query statment
		Statement stat = conn.createStatement();
		try {
		ResultSet result = stat.executeQuery("select * from students_info");
		while(result.next())
		{
			System.out.println(result.getInt(1)+ "\t" + result.getString(2));
		}
		}
		catch(Exception e)
		{
		}
		finally {
		
		conn.close();
		}
		}

}
