package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import LoginPojo.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	protected static WebDriver driver;
	protected static WebElement element;
	protected static FileInputStream file;
	protected static FileInputStream excelFile;
	protected static Properties prop;
	protected static Utility utility;
	protected static XSSFWorkbook xWorkbook;
	protected static XSSFSheet xSheet;
	protected static XSSFCell xCell;
	protected static XSSFRow xRow; 
	protected static Object [][] data;
	protected static LoginPage loginP;
	static {
		
		WebDriverManager.chromedriver().setup();
		WebDriverManager.operadriver().setup();

	}
	final static String FILE_PATH = System.getProperty("user.dir")+
			File.separator+ "src"+
			File.separator+ "main"+
			File.separator+ "resources"+
			File.separator+ "repository"+
			File.separator+ "LoginTestData.xlsx";
	public Base() {
		try {
			file = new FileInputStream(".\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(file);
		} catch (Exception e) {
			e.printStackTrace();	
		}
	}
			
}
