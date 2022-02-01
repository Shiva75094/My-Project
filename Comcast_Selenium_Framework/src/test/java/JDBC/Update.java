package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update 
{
	public static void main(String[] args) throws Throwable 
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		System.out.println("Connecting to Data Base");
		Statement stmt = null;
		stmt=conn.createStatement();
		String sql="update project set project_id='TCS_PROJ_3004' where Project_id='wipro'";
		stmt.executeUpdate(sql);
		System.out.println("Data is update");

	}
}
