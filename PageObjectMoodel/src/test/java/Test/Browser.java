package Test;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utility.Base;

public class Browser extends Base {
	@SuppressWarnings("static-access")
	@BeforeClass
	public void triggerDriver() {
		try {
			utility.initializerDriver(prop.getProperty("browser"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}


	@DataProvider(name = "LoginData")
	public Object[][] LoginData() {
		Object[][] data = utility.getLoginData();
		return data;
	}
	@DataProvider(name = "Data")
	public Object[][] datatest(){
		Object[][] data = new Object[2][2];
		data[0][0] = "santoshthakare5000@gmail.com";
		data[0][1] = "Santosh1234";
		data[1][0] = "amol@gmail.com";
		data[1][1] = "password1234";
		return data;
	}


//	@Test(dataProvider = "Data")
	public void LoginPage(String username, String password) {
		try {

			String url = prop.getProperty("baseURL");
			driver.get(url);
			driver.findElement(By.id("email")).sendKeys("username");
			Thread.sleep(2000);
			driver.findElement(By.id("pass")).sendKeys("password");
			Thread.sleep(2000); 


		} catch (Exception e) {
			e.printStackTrace();
		}

	} 

//	@Test 
//	public void LoginPage() {
//		try {
//
//			String url = prop.getProperty("baseURL");
//			driver.get(url);
//			System.out.println("Value from property File Username : "+ prop.getProperty("emailId"));
//			driver.findElement(By.id("email")).sendKeys(prop.getProperty("emailId"));
//			Thread.sleep(2000);
//			System.out.println("Value from property File Password : "+ prop.getProperty("Password"));
//
//			driver.findElement(By.id("pass")).sendKeys(prop.getProperty("Password"));
//			Thread.sleep(2000); 
//
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	} 
	
	@SuppressWarnings("static-access")
	@Test 
	public void LoginPage(String env) {
		try {
			List<List<String>> values = new LinkedList<List<String>>();
			values.addAll((utility.excelReader() ));
			
			String url = prop.getProperty("baseURL");
			driver.get(url);
			System.out.println("Value from Excel File Username : "+ values.get(0).get(0));
			driver.findElement(By.id("email")).sendKeys(values.get(0).get(0));
			Thread.sleep(2000);
			System.out.println("Value from Excel  File Password : "+ values.get(0).get(1));

			driver.findElement(By.id("pass")).sendKeys(values.get(0).get(1));
			Thread.sleep(2000); 


		} catch (Exception e) {
			e.printStackTrace();
		}

	} 

	
	@SuppressWarnings("static-access")
	@AfterClass
	public void terminateDriver() {
		try {
			utility.closeDriver();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
