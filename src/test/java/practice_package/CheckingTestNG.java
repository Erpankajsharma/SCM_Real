package practice_package;

import org.apache.hc.core5.reactor.Command.Priority;
import org.testng.annotations.Test;

public class CheckingTestNG {
	
	@Test
	public void create() {
		System.out.println("Created.");
	}
	
	@Test(priority = -1)
	public void update() {
		System.out.println("updated.");
	}
	
	@Test(priority = -1)
	public void deleted() {
		System.out.println("deleted.");
	}

}
