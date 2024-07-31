package obsqura_7Rmart_testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{

	@Test(priority=1, description="This is for login with valid credentials",groups= {"smoke", "regression"})
	public void verifyLoginforCorrectUsernameAndCorrectPassword() {
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
		assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
	}
	
	@Test(priority=2, description="This is for login with invalid credentials", groups= {"regression"})
	public void verifyLoginforCorrectUsernameAndIncorrectPassword() {
		String username=ExcelUtility.getString(1, 2, "LoginPage");
		String password=ExcelUtility.getString(1, 3, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isAlertThrown=loginpage.verifyRedAlertThrown();
		assertTrue( isAlertThrown, "User does not get any red alert when username is correct and password is wrong");	
	}
	
	@Test(priority=3, description="This is for login with invalid credentials", groups= {"regression"})
	public void verifyLoginforIncorrectUsernameAndCorrectPassword() {
		String username=ExcelUtility.getString(1, 2, "LoginPage");
		String password=ExcelUtility.getString(1, 3, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isAlertThrown=loginpage.verifyRedAlertThrown();
		assertTrue( isAlertThrown, "User does not get any red alert when username is correct and password is wrong");	
	}
	
	@Test(priority=4,description="This is for login with invalid credentials", groups= {"regression"})
	public void verifyLoginforIncorrectUsernameAndIncorrectPassword() {
		String username=ExcelUtility.getString(1, 2, "LoginPage");
		String password=ExcelUtility.getString(1, 3, "LoginPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isAlertThrown=loginpage.verifyRedAlertThrown();
		assertTrue( isAlertThrown, "User does not get any red alert when username is correct and password is wrong");	
	}
}
