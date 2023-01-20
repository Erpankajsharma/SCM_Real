package practice_package;

import org.testng.annotations.Test;

public class GroupTestNGTest_3 {

	@Test(groups = {"regression","smoke"})
	public void simple5()
	{
		System.out.println("test 5");
	}
	
	@Test(groups = "system")
	public void simple6()
	{
		System.out.println("test 6");
	}
}
