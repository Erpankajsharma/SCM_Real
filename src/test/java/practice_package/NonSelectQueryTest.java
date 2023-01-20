package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		int result = 0;
		try
		{
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45","root","root");
			Statement state = con.createStatement();
			String query = "insert into studentInfo values('Pankaj','BTM','Selenium',2);";
			result = state.executeUpdate(query);	
		}
		catch(Exception e) {
			
		}
		finally
		{
			if(result==1)
			{
				System.out.println("Data inserted successfully.");
			}
			else
			{
				System.out.println("Data not inserted.");
			}
			con.close();
		}
	}
}
