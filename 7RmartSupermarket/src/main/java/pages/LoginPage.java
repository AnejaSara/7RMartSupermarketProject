package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@class='card']/div[@class='card-body login-card-body']") private WebElement logincard;
	@FindBy(xpath="//input[@name='username']") private WebElement usernameField;
	@FindBy(xpath="//input[@name='password']") private WebElement passwordField;
	@FindBy(xpath="//button[text()='Sign In']") private WebElement signInButton;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']") private WebElement redAlertbox;
	@FindBy(xpath="//li[@class='breadcrumb-item active' and text()='Dashboard']") private WebElement dashboardLabel;

public LoginPage enterUsernameOnUsernameField(String username) {

usernameField.sendKeys(username);
return this;
}

public LoginPage enterPasswordOnPasswordField(String password) {
	passwordField.sendKeys(password);
	return this;
}

public LoginPage clickOnSignInButton() {
	signInButton.click();
	return this;
}

public boolean verifyHomePageNavigated() {
	boolean homepagedisplayed=dashboardLabel.isDisplayed();
	return homepagedisplayed;
}

public boolean verifyRedAlertThrown() {
	boolean redalertthrown=redAlertbox.isDisplayed();
	return redalertthrown;
}

public LoginPage waitForLoginCard() {
	WaitUtility waitutility=new WaitUtility();
	waitutility.explicitWaitToBeVisible(driver, logincard);
	return this;
}
}
