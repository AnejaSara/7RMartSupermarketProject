package obsqura_7Rmart_testscripts;

import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

import pages.LoginPage;
import utilities.ExcelUtility;
@Test
public class ManageContactTest extends Base {
	String username=ExcelUtility.getString(1, 0, "LoginPage");
	String password=ExcelUtility.getString(1, 1, "LoginPage");
	String phone=ExcelUtility.getString(1, 0, "ContactUs");
	String email=ExcelUtility.getString(1, 1, "ContactUs");	
	String address=ExcelUtility.getString(1, 2, "ContactUs");
	String deliveryTime=ExcelUtility.getString(1, 3, "ContactUs");
	String delivaryChargeLimit=ExcelUtility.getString(1, 4, "ContactUs");
	LoginPage loginpage=new LoginPage(driver);
	

}

