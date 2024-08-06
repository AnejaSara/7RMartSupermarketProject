package obsqura_7Rmart_testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.CategoriesPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class CategoriesTest extends Base {
	
@Test
	public void verifyUserIsAbleToAddNewCategory() {
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String categoryName=ExcelUtility.getString(1, 0, "Categories");
		String filepath=ExcelUtility.getString(1, 1, "Categories");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
		assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
		CategoriesPage categoriespage=new CategoriesPage(driver);
		categoriespage.clickOnCategoryTile().clickOnNewButton().enterCategoryToTextField(categoryName).clickOnDiscount().uploadImageFile(filepath);
		/*boolean isImagePreviewed= categoriespage.verifyFileUpload();
		assertTrue(isImagePreviewed, "User is unable to login when username and passwords are correct");*/
		categoriespage.clickOnLeftMenuRadio().clickOnTopMenuRadio().saveCategory();
		boolean successAlertThrown= categoriespage.verifySuccessAlertThrown();
		 assertTrue(successAlertThrown, "User is unable to see the success alert when save button is clicked");
		
}
}