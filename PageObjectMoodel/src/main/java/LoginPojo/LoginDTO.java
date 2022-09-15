package LoginPojo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDTO {
	
	@FindBy(id = "email")
	WebElement emailId;
	 
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(name= "login")
	WebElement loginBtn;
	
	public LoginDTO(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
	
	public void setEmailId(String em) {
		emailId.sendKeys(em);
	}
	
	public void setPassword(String pd) {
		password.sendKeys(pd);
	}

	public void clicklogin() {
		loginBtn.click();
	}
}
