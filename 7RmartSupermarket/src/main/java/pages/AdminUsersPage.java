package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class AdminUsersPage {
	public WebDriver driver;
	public AdminUsersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
@FindBy(xpath="//p[text()='Admin Users']/parent::div[@class='inner']/following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") WebElement adminUsersTileLink;	
@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement newButton;
@FindBy(xpath="//div[@class='col-sm-6']/h1[@class='m-0 text-dark' and text()='Admin Users']") WebElement pageTitle;
@FindBy(xpath="//h3[@class='card-title' and text()='Admin Users Informations']") WebElement newUserFieldSection;
@FindBy(xpath = "//input[@name='username' and @id='username']") WebElement usernameField;
@FindBy(xpath = "//input[@name='password' and @id='password']") WebElement passwordField;
@FindBy(xpath = "//select[@name='user_type' and @id='user_type']") WebElement userTypeDropdown;
@FindBy(xpath="//button[@type='submit' and @name='Create']") WebElement saveButton;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[not(@class='detail-row')]/td[1]") List<WebElement> usernameList;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement successAlert;

public AdminUsersPage adminUserPageNavigate() {
	adminUsersTileLink.click();
	return this;
}

public boolean isPageTitleVisibile() {
	boolean visible=pageTitle.isDisplayed();
	return visible;
}

public AdminUsersPage clickOnNewButton() {
	newButton.click();
	return this;
}

public boolean isNewUserSectionVisible() {
	boolean visible=newUserFieldSection.isDisplayed();
	return visible;
}

public AdminUsersPage enterUsername(String username) {
	
	usernameField.sendKeys(username);
	return this;
	
}
 
public AdminUsersPage enterPassword(String password) {
	passwordField.sendKeys(password);
	return this;
}

public AdminUsersPage selectUserType(String usertype) {
	PageUtility pageutility=new PageUtility();
	pageutility.selectValueUsingSelectByVisibleText(userTypeDropdown,usertype);
	return this;
}


public AdminUsersPage clickOnSaveButton() {
	saveButton.click();
	return this;
}

public boolean verifyNewlyAddedAdminIsListedUsingusername(String searchUsername) {
	PageUtility pageutility=new PageUtility();
	boolean elementListed=pageutility.elementListIterator(driver, usernameList, searchUsername);
	return elementListed;
}

public boolean isSuccessAlertDisplayed() {
	boolean visible=successAlert.isDisplayed();
	return visible;
}

}
