package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;

public class Utility extends Base {

	public static void initializerDriver() {
		
		try {
			file = new FileInputStream(".\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(file);
			
			if (prop.getProperty("browser").equals("chrome")) {
				driver =new ChromeDriver();
				driver.manage().window().maximize();
			}else {
				driver =new OperaDriver();
				driver.manage().window().maximize();

		}}
		
			catch (Exception e) {
			e.printStackTrace();
			}
	}

	public static void closeDriver() {
		try {
			Thread.sleep(2000);
			driver.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
