package Test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import LoginPojo.LoginPage;
import Utility.Base;

public class LoginPageTest extends Base{
	public LoginPageTest() {
		super();
	}
	

	@SuppressWarnings("static-access")
	@BeforeClass
	public void triggerDriver() {
		try {
			utility.initializerDriver(prop.getProperty("browser"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Test(priority = 0)
	public void validLoginPageWithConfigDataTest() {
		loginP = new LoginPage();
		loginP.validLoginTextBoxAllignment();
		
	}
	@Test(priority = 1)
	public void validLoginPageWithXLSXDataTest() {
		loginP = new LoginPage();
//		loginP.loginUser();
		loginP.loginUserUsingXlsx();
		String homePageTitle = loginP.verifyHomePage();
		assertEquals(homePageTitle, "Facebook");
		
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
