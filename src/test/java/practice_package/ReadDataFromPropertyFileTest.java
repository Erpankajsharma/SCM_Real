package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFileTest {

	public static void main(String[] args) throws IOException {
		
		//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		FileInputStream fis = new FileInputStream("./src/test/resources/commonData.properties");
		Properties p=new Properties();
		p.load(fis);
		
		String Url = p.getProperty("url");
		String un = p.getProperty("username");
		String pwd = p.getProperty("password");
		String brow = p.getProperty("browser");
		
		System.out.println(Url);
		System.out.println(un);
		System.out.println(pwd);
		System.out.println(brow);
		
	}

}
