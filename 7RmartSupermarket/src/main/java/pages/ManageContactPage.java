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

}
