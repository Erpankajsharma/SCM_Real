package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryLocalHostTest {

	public static void main(String[] args) throws SQLException {
		
		Connection con = null;
		int result = 0;
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		Statement state = con.createStatement();
		String query = "insert into project values('TY_Project_500','SCM','21/12/2022','Pankaj','ongoing',4);";
		result = state.executeUpdate(query);
		
		if(result==1)
		{
			System.out.println("data updated");
		}
		else
		{
			System.out.println("data not updated");
		}
		con.close();
	}

}
