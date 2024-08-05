package obsqura_7Rmart_testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;


public class ManageContactTest extends Base {
 @Test
	public void verifyUserIsAbleToUpdateContact() {
	 String username=ExcelUtility.getString(1, 0, "LoginPage");
	 String password=ExcelUtility.getString(1, 1, "LoginPage");
	 String phone=ExcelUtility.getString(1, 0, "ContactUs");
	 String email=ExcelUtility.getString(1, 1, "ContactUs");	
	 String address=ExcelUtility.getString(1, 2, "ContactUs");
	 String deliveryTime=ExcelUtility.getString(1, 3, "ContactUs");
	 String delivaryChargeLimit=ExcelUtility.getString(1, 4, "ContactUs");
	 LoginPage loginpage=new LoginPage(driver);
	 loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
	 boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
	 assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
	 ManageContactPage managecontactpage=new ManageContactPage(driver);	
	 managecontactpage.navigateToManageContact();
	 boolean isContactPageNvaigated=managecontactpage.verifyNavigationToContactUsPage();
	 assertTrue(isContactPageNvaigated, "User is not able to navigate to contact us page when click on ocntact tile");
	 managecontactpage.clickOnEditButton().enterPhonenumber(phone).enterEmailId(email).enterAddress(address).enterDeliveryTime(deliveryTime).enterDeliveryCharge(delivaryChargeLimit).clickOnUpdateButton();
	 boolean successAlertThrown= managecontactpage.verifySuccessAlertThrown();
	 assertTrue(successAlertThrown, "User is unable to see the success alert when update button is clicked");
	
 }
}

