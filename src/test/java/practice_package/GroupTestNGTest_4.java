package practice_package;

import org.testng.annotations.Test;

public class GroupTestNGTest_4 {
	
	@Test(groups = {"regression","smoke"})
	public void simple7()
	{
		System.out.println("test 7");
	}
	
	@Test
	public void simple8()
	{
		System.out.println("test 6");
	}

}
