package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected static WebDriver driver;
	protected static WebElement element;
	protected static FileInputStream file;
	protected static Properties prop;
	static {
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.operadriver().setup();

	}
}
