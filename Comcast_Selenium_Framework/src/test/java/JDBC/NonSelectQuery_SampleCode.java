package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery_SampleCode
{
	public static void main(String[] args) throws SQLException 
	{
		Connection conn=null;
		int result=0;
		try
		{
			Driver driverRef=new Driver();
			//Step 1:load/register mysql the database
			DriverManager.registerDriver(driverRef);
			
			//Step 2:connect to database
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
			System.out.println("=================Connecting the Data Base=================");
			
			//Step 3:create query statement
			Statement stat=conn.createStatement();
			String query = "insert into project values('TCS','Sunil','2/01/2022','SBI','Completed',6)";
			
			//Step 4:execute the query
			result = stat.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println("Exception Handled");

		}
		finally
		{
			//Step 5:Handle Exception
			if(result==1)
			{
				System.out.println("Project inserted successfully");
			}
			else
			{
				System.err.println("Project is not inserted...!");

			}
			//Step 6:close the connection
			conn.close();
			System.out.println("==============Close Data Base Connection=============");
		}
	}

}
