package practice_package;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertNull;

import org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert_Practice {

//	public static void main(String[] args) {
//		
//		assertEquals1();
//		
//	}
	
		@Test
		public void assertEquals1()
		{
			System.out.println("A");
			System.out.println("B");
			assertEquals("Pankaj", "Sharma");
			System.out.println("C");
			System.out.println("D");
		}
		
		@Test
		public void assertNotEquals1()
		{
			System.out.println("A");
			System.out.println("B");
			assertNotEquals(5, 10);
			System.out.println("C");
			System.out.println("D");
		}
		
		@Test
		public void assertNull1()
		{
			String a = null;
			System.out.println("A");
			System.out.println("B");
			assertNull(5);
			System.out.println("C");
			System.out.println("D");
		}
		
		@Test
		public void assertEqualsSoft()
		{
			System.out.println("A");
			System.out.println("B");
			assertEquals("Pankaj", "Sharma");
			SoftAssert sa=new SoftAssert();
			
			System.out.println("C");
			System.out.println("D");
		}

}
