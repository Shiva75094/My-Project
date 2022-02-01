package JDBC;

import static org.testng.Assert.assertTrue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.jdbc.Driver;

public class ProjectUnitTest 
{
	@Test
	public void projetUnitTest()
	{
	String ProjectName="TCS_PROJ_3003";
	Connection conn=null;

	try
	{
		Driver driverRef=new Driver();

		//Step 1:Load/Register mysql the database
		DriverManager.registerDriver(driverRef);

		//Step 2:Connect the Data Base
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("=================Connecting the Data Base=================");

		//Step 3:Create query statement
		Statement stat = conn.createStatement();
		String query = "select * from project";

		//Step 4:Execute the query
		ResultSet resultset = stat.executeQuery(query);
		boolean flag = false; 
		while(resultset.next())
		{
			String actProjectName = resultset.getString(12);
			if(actProjectName.equals(ProjectName))
			{
				flag=true;
			}
		}
		Assert.assertTrue(flag);
	}

	//Step 5:Handle Exception
	catch(Exception e)
	{
		System.out.println("Exception Handled");
	}
	finally
	{
		//Step 6:Close the Connection
		System.out.println("==================Close the Data Base Connection=================== ");
	}

  }
}

