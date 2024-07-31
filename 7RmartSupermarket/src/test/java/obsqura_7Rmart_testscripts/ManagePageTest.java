package obsqura_7Rmart_testscripts;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManagePagesPage;
import utilities.ExcelUtility;

public class ManagePageTest extends Base{
@Test
	public void verifyUserIsAbleToSearchPageUsingTitle() {
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String searchTitle=ExcelUtility.getString(1, 0, "ManagePages");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
		assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
		ManagePagesPage managepagespage=new ManagePagesPage(driver);
		managepagespage.navigateToManagePages().clickOnManagePagesSearchButton().enterPageTitleToTextField(searchTitle).clickOnSearchToFetchResults();
		Boolean isSearchResultFetched=managepagespage.searchResultTableItem();
		assertTrue(isSearchResultFetched, "User is not able to fetch any pages with given title");
		managepagespage.clickOnResetButton();
		Boolean isNavigatedToListPage=managepagespage.verifyNavigationToManagePage();
		assertTrue(isNavigatedToListPage, "User is not able to navigate List Pages screen");
	}
	
	@Test
	public void verifyUserIsAbleToAddNewPages() {
		String username=ExcelUtility.getString(1, 0, "LoginPage");
		String password=ExcelUtility.getString(1, 1, "LoginPage");
		String pagetitle=ExcelUtility.getString(1, 1, "ManagePages");;
		String description=ExcelUtility.getString(1, 2, "ManagePages");;
		String pagename=ExcelUtility.getString(1, 3, "ManagePages");;
		String filepath=ExcelUtility.getString(1, 4, "ManagePages");;
		LoginPage loginpage=new LoginPage(driver);
		loginpage.waitForLoginCard().enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickOnSignInButton();
		boolean isHomePageNavigated= loginpage.verifyHomePageNavigated();
		assertTrue(isHomePageNavigated, "User is unable to login when username and passwords are correct");
		ManagePagesPage managepagespage=new ManagePagesPage(driver);
		managepagespage.navigateToManagePages();
		Boolean isNavigatedToListPage=managepagespage.verifyNavigationToManagePage();
		managepagespage.clickOnNewButton();
		Boolean isNavigatedToAddNewPage=managepagespage.verifyNavigationToAddPage();
		assertTrue(isNavigatedToAddNewPage, "User is not able to navigate Add New Pages screen");
		managepagespage.fillTitleTextField(pagetitle).fillDescriptionTextArea(description).fillPageNameField(pagename).uploadImageFile(filepath);
		Boolean isfileUploaded=managepagespage.verifyFileUpload();
		assertTrue(isfileUploaded, "User is not able to upload image file at Add New Pages screen");
		managepagespage.clickOnSaveButton();
		Boolean isAlertDisplayed=managepagespage.verifyAlertIsDisplayed();
		assertTrue(isAlertDisplayed, "Success Alert is thrown when save button is clicked");
		managepagespage.navigateToManagePages();
		assertTrue(isNavigatedToListPage, "User is not able to navigate List Pages screen");
		Boolean isPageListed=managepagespage.verifyNewlyAddedPageInPageListUsingTitle(pagetitle);
		assertTrue(isPageListed, "Newly Created page is not listed in Page List screen");
	}
	
	
}
