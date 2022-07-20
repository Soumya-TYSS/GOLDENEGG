package com.crm.kiboko.GenericUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;

import com.mysql.cj.jdbc.Driver;

/**This is a generic class to connect to DataBase and disconnect
 * 
 * @author Pai
 *
 */
public class DataBaseUtility {
	static Driver driver;
	static Connection conn;
	static ResultSet result;
	
	/**This method will perform the mysql database connection
	 * @throws SQLException
	 */
	public void connectToDB() throws SQLException
	{
		try {
			//Register to database
			driver=new Driver();
			DriverManager.registerDriver(driver);
			
			// Connecting to DB
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root", "root");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	/**This method is used to close the data base connection
	 * 
	 * @throws SQLException
	 */
	public void closeDB() throws SQLException {
		try {
			conn.close();
			}
		catch(Exception e)
		{
			
		}
	}
	/**This method will execute the query
	 * 
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executingQuery(String query) throws SQLException
	{
		result=conn.createStatement().executeQuery(query);
		return result;
	}
	
	public int excuteUpdate(String query) throws SQLException
	{
		int result=conn.createStatement().executeUpdate(query);
		return result;
	}
	
	

}
