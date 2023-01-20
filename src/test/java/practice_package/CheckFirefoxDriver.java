package practice_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckFirefoxDriver {

	public static void main(String[] args) {
		
		WebDriver d=new FirefoxDriver();
		d.manage().window().maximize();
		d.get("https://github.com/");

	}

}
