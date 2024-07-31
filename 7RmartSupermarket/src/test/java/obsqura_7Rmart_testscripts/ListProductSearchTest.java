package obsqura_7Rmart_testscripts;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import pages.ListProductsSearchPage;
import pages.LoginPage;
import utilities.ConstantsFile;
import utilities.ExcelUtility;
import utilities.WaitUtility;

public class ListProductSearchTest extends Base {
	@Test(priority=1)
	public void verifyUserAbleToSearchProductUsingProductName() {
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String productname=ExcelUtility.getString(1, 0,ConstantsFile.TESTDATAFILE, "ListProductSearchPage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
		assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
		ListProductsSearchPage listproductssearchpage=new ListProductsSearchPage(driver);
		listproductssearchpage.productListPageNavigate().clickOnPageSearchButton().enterProductNameInTitleField(productname).clickOnProductSearchButton();
		boolean isSearchResultEmpty=listproductssearchpage.searchResultTableItem();
		assertFalse(isSearchResultEmpty,"Product Search has results listed");
	}	
	
	
}
