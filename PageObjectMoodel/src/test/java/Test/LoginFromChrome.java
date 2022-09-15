package Test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Utility.Base;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginFromChrome extends Base  {
	static WebDriver driver;
	static FileInputStream file;
	static Properties prop;
	static {
		WebDriverManager.chromedriver().setup();
		WebDriverManager.firefoxdriver().setup();

		}
	@Test
	@Parameters("browser")
	public void chromeLogin(String browser) {
		try {
			if (browser.equals("chrome")) {
				driver =new ChromeDriver();
				driver.manage().window().maximize();
			}else {
				driver =new FirefoxDriver();
				driver.manage().window().maximize();

			}
			FileInputStream file = new FileInputStream(".\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(file);
			String url = prop.getProperty("baseURL");
			driver.get(url);
			Thread.sleep(2000);
			driver.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
}
