package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class sample {
public static void main(String[] args) throws SQLException {
	Connection con = null;
	
	Driver driver=new Driver();
	
	//step1 : Register the database
	DriverManager.registerDriver(driver);
	//step2 : get connection for the database
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
	
	//step3 : Issue create statement
	Statement state = con.createStatement();
	String query = "select * from studentInfo;";
	
	//step4 : Execute Query
	ResultSet result = state.executeQuery(query);
	
	while(result.next())
	{
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
	}
}
}

