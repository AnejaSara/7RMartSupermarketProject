package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageContactPage {

	public WebDriver driver;
	public ManageContactPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}

@FindBy(xpath="//p[text()='Manage Contact']/parent::div[@class=\"inner\"]/following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact']") private WebElement manageContactTile;
@FindBy(xpath="//div[@class='col-sm-6']/h1[@class='m-0 text-dark'and text()='Contact Us']") private WebElement contactUsPageTitle;
@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/descendant::td/a[@role='button']") private WebElement editActionButton;
@FindBy(xpath="//input[@name='phone' and @id='phone']") private WebElement phonenumberfield;
@FindBy(xpath="//input[@name='email' and @id='email']") private WebElement emailfield;
@FindBy(xpath="//textarea[@name='address' and @placeholder='Enter the Address']") private WebElement addressfield;
@FindBy(xpath="//textarea[@name='del_time' and @placeholder='Enter Delivery Time']") private WebElement deliveryTimeField;
@FindBy(xpath="//input[@name='del_limit' and @name='del_limit']") private WebElement deliveryChargeField;
@FindBy(xpath="//div[@class='card-footer center']/button[@type='submit' and @name='Update']") private WebElement updateButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertPath;

public ManageContactPage navigateToManageContact() {
	WaitUtility waitutility=new WaitUtility();
	waitutility.explicitWaitToBeClicked(driver, manageContactTile);
	manageContactTile.click();
	return this;
}

public boolean verifyNavigationToContactUsPage() {
	boolean pageTitleDisplayed=contactUsPageTitle.isDisplayed();
	return pageTitleDisplayed;
}

public ManageContactPage clickOnEditButton() {
	WaitUtility waitutility=new WaitUtility();
	waitutility.explicitWaitToBeClicked(driver, editActionButton);
	editActionButton.click();
	return this;
}

public ManageContactPage enterPhonenumber(String phoneNumber) 
{
	phonenumberfield.clear();
	phonenumberfield.sendKeys(phoneNumber);
	return this;
	}

public ManageContactPage enterEmailId(String emailId) 
{
	emailfield.clear();
	emailfield.sendKeys(emailId);
    return this;
	}
public ManageContactPage enterAddress(String address) 
{
	addressfield.clear();
	addressfield.sendKeys(address);
    return this;
	}
public ManageContactPage enterDeliveryTime(String deliveryTime) 
{
	deliveryTimeField.clear();
	deliveryTimeField.sendKeys(deliveryTime);
    return this;
}
public ManageContactPage enterDeliveryCharge(String deliveryCharge) 
{
	deliveryChargeField.clear();
	deliveryChargeField.sendKeys(deliveryCharge);
    return this;
	}

public ManageContactPage clickOnUpdateButton()
{	WaitUtility waitutility=new WaitUtility();
    waitutility.explicitWaitToBeClicked(driver, updateButton);
    updateButton.click();
    return this;
	}
public boolean verifySuccessAlertThrown() {
	WaitUtility waitutility=new WaitUtility();
	waitutility.explicitWaitToBeVisible(driver, alertPath);;
	boolean greenBackground=false;
	String alertBackgroundColour=alertPath.getCssValue("background");
	if(alertBackgroundColour.contains("rgb(40, 167, 69)")) {
		greenBackground=true;
	}
	return greenBackground;
}


}
