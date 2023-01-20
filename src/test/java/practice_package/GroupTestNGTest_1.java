package practice_package;

import org.testng.annotations.Test;

public class GroupTestNGTest_1 {

	@Test(groups = "smoke")
	public void simple1()
	{
		System.out.println("test 1");
	}
	
	@Test(groups = {"regression","smoke"})
	public void simple2()
	{
		System.out.println("test 2");
	}
}
