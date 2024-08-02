package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;

public class AdminUsersPage {
	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility;
	public AdminUsersPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
@FindBy(xpath="//p[text()='Admin Users']/parent::div[@class='inner']/following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin']") private WebElement adminUsersTileLink;	
@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newButton;
@FindBy(xpath="//div[@class='col-sm-6']/h1[@class='m-0 text-dark' and text()='Admin Users']") private WebElement pageTitle;
@FindBy(xpath="//h3[@class='card-title' and text()='Admin Users Informations']")private  WebElement newUserFieldSection;
@FindBy(xpath = "//input[@name='username' and @id='username']") private WebElement usernameField;
@FindBy(xpath = "//input[@name='password' and @id='password']")private WebElement passwordField;
@FindBy(xpath = "//select[@name='user_type' and @id='user_type']") private WebElement userTypeDropdown;
@FindBy(xpath="//button[@type='submit' and @name='Create']") private WebElement saveButton;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr[not(@class='detail-row')]/td[1]") private List<WebElement> usernameList;
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
	pageutility.selectValueUsingSelectByVisibleText(userTypeDropdown,usertype);
	return this;
}


public AdminUsersPage clickOnSaveButton() {
	saveButton.click();
	return this;
}

public boolean verifyNewlyAddedAdminIsListedUsingusername(String searchUsername) {
	boolean elementListed=pageutility.elementListIterator(driver, usernameList, searchUsername);
	return elementListed;
}

public boolean isSuccessAlertDisplayed() {
	boolean visible=successAlert.isDisplayed();
	return visible;
}

public boolean getStatus(String statusupdateUsername) {
	boolean status=false;
	WebElement statusXpath=setUpXpathWith(statusupdateUsername);
	if(statusXpath.getText()=="Active") 
		status=true;
	else if(statusXpath.getText()=="Inactive")
		status=false;
	return status;
}

public AdminUsersPage clickOnUpdateIcon(String statusupdateUsername) {
	
	pageutility.scrollPageDown(driver, 0, 350);
	WebElement statusXpath=setUpXpathWith(statusupdateUsername);
	waitutility=new WaitUtility();
	waitutility.explicitWaitToBeVisible(driver, statusXpath);
	statusXpath.click();
	return this;
}

public WebElement setUpXpathWith(String statusupdateUsername)
{
	String xpathstring="//tbody/tr[not(@class='detail-row')]/td[text()='"+statusupdateUsername+"']/following-sibling::td/a[not(@class)]/span[@class='badge bg-success']";
	WebElement xpathwithreplacement=driver.findElement(By.xpath(xpathstring));
	return xpathwithreplacement;
	}

}
