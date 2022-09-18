package LoginPojo;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Base;

public class LoginPage extends Base{
	
	@FindBy(id = "email")
	WebElement emailId;
	 
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name= "login")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[@aria-label=\"Home\"]")
	WebElement homeBtn;
	
	public LoginPage() {
		
		PageFactory.initElements(driver,this);
	}
	public void loginUser() {
		try {
			emailId.sendKeys(prop.getProperty("emailId"));
			Thread.sleep(1000);
			password.sendKeys(prop.getProperty("password"));
			Thread.sleep(1000);
			loginBtn.click(); 
			homeBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("static-access")
	public void loginUserUsingXlsx() {
		try {
			List<List<String>> values = new LinkedList<List<String>>();
			values.addAll((utility.excelReader() ));
			emailId.sendKeys(values.get(0).get(0));
			Thread.sleep(1000);
			password.sendKeys(values.get(0).get(1));
			Thread.sleep(1000);
			loginBtn.click(); 
			homeBtn.click();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void validLoginTextBoxAllignment() {
		try {
			int us_X = emailId.getLocation().getX();
			int us_width = emailId.getSize().getWidth();
			System.out.println("US Width"+ us_width);
			int us_height = emailId.getSize().getHeight();
			System.out.println("US Height " + us_height);
			
			int pass_X = password.getLocation().getX();
			int pass_width = emailId.getSize().getWidth();
			System.out.println("US Width"+ pass_width);
			int pass_height = emailId.getSize().getHeight();
			System.out.println("US Height " + pass_height);
			
			if (us_X ==pass_X && us_width == pass_width  && us_height == pass_height ) {
				System.out.println("Username and password TextBox are in allinment");
		} else
		{
			System.out.println("Username and password TextBox are Not in allinment");

		}
			}catch (Exception e) {  
			e.printStackTrace();
		}
	}
	public String verifyHomePage() {
		String homePageTitle = driver.getTitle();
		return homePageTitle;
	}
}
