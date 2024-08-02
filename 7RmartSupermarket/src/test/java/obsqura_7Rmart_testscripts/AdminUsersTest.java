package obsqura_7Rmart_testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.AdminUsersPage;
import pages.LoginPage;
import utilities.ExcelUtility;


public class AdminUsersTest extends Base {

	@Test
	public void verifyUserIsAbleToAddNewAdminUser() {
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String adminusername=ExcelUtility.getString(1, 0, "AdminUser");
		String adminpassword=ExcelUtility.getString(1, 1, "AdminUser");
		String usertype=ExcelUtility.getString(1, 2, "AdminUser");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
		assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.adminUserPageNavigate();
		boolean isAdminPageNavigated=adminuserspage.isPageTitleVisibile();
		assertTrue(isAdminPageNavigated, "User is not able to navigate to admin user page when admin tile is clicked");
		adminuserspage.clickOnNewButton();
		boolean isnewAdminNavigated=adminuserspage.isNewUserSectionVisible();
		assertTrue(isnewAdminNavigated, "User is not able to navigate to new admin user page when admin tile is new button");
		adminuserspage.enterUsername(adminusername).enterPassword(adminpassword).selectUserType(usertype).clickOnSaveButton();
		boolean isAlertDisplayed=adminuserspage.isSuccessAlertDisplayed();
		boolean isNameListed=adminuserspage.verifyNewlyAddedAdminIsListedUsingusername(adminusername);
		assertTrue(isAlertDisplayed&&isNameListed, "User is not able to view alert and name is not listed");
		}
	
	
	@Test
	public void verifyUserIsAbleToUpdateStatusOfAdminUser() {
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String updateusername=ExcelUtility.getString(1, 3, "AdminUser");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
		assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
		AdminUsersPage adminuserspage=new AdminUsersPage(driver);
		adminuserspage.adminUserPageNavigate();
		boolean isAdminPageNavigated=adminuserspage.isPageTitleVisibile();
		assertTrue(isAdminPageNavigated, "User is not able to navigate to admin user page when admin tile is clicked");
		boolean isStatusActive=adminuserspage.getStatus(updateusername);
		assertTrue(isStatusActive, "User is not able to find admin user in active status");
		adminuserspage.clickOnUpdateIcon(updateusername);
		boolean isNotStatusActive=adminuserspage.getStatus(updateusername);
		assertFalse(isNotStatusActive, "User is not able to find admin user in Inactive status");
	}
}
