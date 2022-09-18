package Utility;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.opera.OperaDriver;


public class Utility extends Base {

	public static void initializerDriver() {

		try {
			file = new FileInputStream(".\\src\\main\\resources\\config.properties");
			Properties prop = new Properties();
			prop.load(file);

			if (prop.getProperty("browser").equals("chrome")) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			} else {
				driver = new OperaDriver();
				driver.manage().window().maximize();

			}
		}

		catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Object[][] getLoginData() {
		try {
			excelFile = new FileInputStream(FILE_PATH);
			xWorkbook = new XSSFWorkbook(excelFile);
			
			xSheet = xWorkbook.getSheet("TestData");
			int lastRow = xSheet.getLastRowNum();
			
			data = new Object[lastRow][lastRow];
			int k=0;
			for (int i = 1; i < lastRow; i++) {
				String username = xSheet.getRow(i).getCell(k).getStringCellValue();
				String password = xSheet.getRow(i).getCell(k).getStringCellValue();
				System.out.println("Row" + i + " username: " +username);
				System.out.println("Row" + i + " password: " +username);
				System.out.println();
				data[i][0]= username;
				data[i][1]=password;

			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return data;
	
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
