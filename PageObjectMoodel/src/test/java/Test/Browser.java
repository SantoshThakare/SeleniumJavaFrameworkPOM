package Test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Base;

public class Browser extends Base {
	@SuppressWarnings("static-access")
	@BeforeTest
	public void triggerDriver() {
		try {
			utility.initializerDriver();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@DataProvider(name = "LoginData")
	public Object[][] LoginData() {
		Object[][] data = utility.getLoginData();
		return data;
	}

	@Test(dataProvider = "LoginData")
	public void LoginPage(String username, String password) {
		try {

			String url = prop.getProperty("baseURL");
			driver.get(url);
			driver.findElement(By.id("email")).sendKeys("username");
			Thread.sleep(2000);
			driver.findElement(By.id("email")).sendKeys("password");
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("static-access")
	@AfterTest
	public void terminateDriver() {
		try {
			utility.closeDriver();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
