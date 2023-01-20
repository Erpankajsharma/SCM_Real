package practice_package;

import org.testng.annotations.Test;

public class GroupTestNGTest_2 {

	@Test(groups = "smoke")
	public void simple3()
	{
		System.out.println("test 3");
	}
	
	@Test(groups = "regression")
	public void simple4()
	{
		System.out.println("test 4");
	}
}
