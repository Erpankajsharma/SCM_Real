package practice_package;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider_TestNg {
	
	@Test(dataProvider = "data")
	public void travel(String src, String dst, int price)
	{
		System.out.println("from "+src+" -----> "+"to "+dst+" "+price);
	}
	
	@DataProvider
	public Object [][] data()
	{
		Object [][]objarr = new Object [3][3];
		
		objarr[0][0] = "bangalore";
		objarr[0][1] = "mysore";
		objarr[0][2] = "14";
		
		objarr[1][0] = "mysore";
		objarr[1][1] = "bangalore";
		objarr[1][2] = "10";
		
		objarr[2][0] = "mysore";
		objarr[2][1] = "bangalore";
		objarr[2][2] = "200";
		
		return objarr;
		
	}

}
