package obsqura_7Rmart_testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ConstantsFile;
import utilities.ScreenshotUtility;

public class Base {
	public WebDriver driver;
	public Properties prop;
	FileInputStream fs;
	public ScreenshotUtility screenshotutility;
	
	@BeforeMethod(alwaysRun=true)
	@Parameters("Browser")
	public  void initializeBrowser(String Browser ) throws Exception {
		try 
		{
			prop = new Properties();
			fs = new FileInputStream(ConstantsFile.CONFIGFILE);
			prop.load(fs);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		if(Browser.equalsIgnoreCase("chrome"))
		{
         driver=new ChromeDriver();	
		}
		else if (Browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else if (Browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver(); 	
		}
		
		else
		{
			throw new Exception("Browser is not correct");
		}
		
		driver.get(prop.getProperty("url")); 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();    
	}
	
	@AfterMethod(alwaysRun = true)
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			screenshotutility = new ScreenshotUtility();
			screenshotutility.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
