package com.scm.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {

	Connection con = null;
	
	public void connectToDB() throws SQLException
	{
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		con = DriverManager.getConnection(IPathConstants.DBURL, IPathConstants.DBUSERNAME, IPathConstants.DBPASSWORD);
	}
	
	public String executeQueryAndGetData(String query, int columnIndex, String expData) throws SQLException
	{
		ResultSet result = con.createStatement().executeQuery(query);
		boolean flag = false;
		while(result.next())
		{
			String data = result.getString(columnIndex);
			System.out.println(data);
			if(data.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expData+" project is created");
			return expData;
		}
		else
		{
			System.out.println("Project is not created");
			return "";
		}
	}
	
	public void closeDB() throws SQLException
	{
		con.close();
	}

}
