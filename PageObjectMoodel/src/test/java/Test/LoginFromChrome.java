package Test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utility.Base;

public class LoginFromChrome extends Base {
	@SuppressWarnings("static-access")
	@BeforeTest
	public void triggerDriver() {
		try {
			utility.initializerDriver();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	public void chromeLogin() {
		try {

			String url = prop.getProperty("baseURL");
			driver.get(url);

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
