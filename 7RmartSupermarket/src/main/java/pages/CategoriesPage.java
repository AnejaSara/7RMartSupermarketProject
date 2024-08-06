package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class CategoriesPage {

	public WebDriver driver;
	PageUtility pageutility=new PageUtility();
	WaitUtility waitutility;
	public CategoriesPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
	
	@FindBy(xpath="//p[text()='Category']/parent::div[@class='inner']/following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-category']") private WebElement categoryTileLink;
	@FindBy(xpath="//a[@onclick='click_button(1)']") private WebElement newButton;
	@FindBy(xpath="//input[@id='category' and @type='text']") private WebElement categoryNameTextField;
	@FindBy(xpath="//li[not(@style='display: none;')]/span[text()='discount']") private WebElement discount;
	@FindBy(xpath="//label[text()='Image (300 x 300 px)']/following-sibling::input[@type='file']") private WebElement fileUploadButton;
	@FindBy(xpath="//label[text()='Show On Top Menu']/following-sibling::label[@class='radio-inline']/input[@type='radio' and @value='no']") private WebElement showTopOfMenuRadioButton;
	@FindBy(xpath="//label[text()='Show On Left Menu']/following-sibling::label[@class='radio-inline']/input[@type='radio' and @value='no']") private WebElement showOnleftRadioButton;
	@FindBy(xpath = "//button[@type='submit' and text()='Save']") private WebElement saveButton;
	@FindBy(xpath = "//label[text()='Image (300 x 300 px)']/following-sibling::input[@type='file']/following-sibling::div") private WebElement previewImage;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement alertPath;
	
	public CategoriesPage clickOnCategoryTile() {
		categoryTileLink.click();
		return this;
	}
	
	public CategoriesPage clickOnNewButton() {
		newButton.click();
		return this;
	}
	
	public CategoriesPage enterCategoryToTextField(String categoryName) {
		categoryNameTextField.sendKeys(categoryName);
		return this;
	}
	
	public CategoriesPage clickOnSelectGroup() {
		categoryNameTextField.click();
		return this;
	}
	
	public CategoriesPage clickOnDiscount() {
		discount.click();
		return this;
	}
	
	public CategoriesPage uploadImageFile(String filepath) {
		FileUtility fileUtility=new FileUtility();
		fileUtility.fileUploadUsingSendkeys(fileUploadButton, filepath);
		return this;
	}
	
	public boolean verifyFileUpload() {
		boolean imagePreviewDisplayed=previewImage.isDisplayed();
		return imagePreviewDisplayed;
	}
	
	public CategoriesPage clickOnTopMenuRadio() {
		showTopOfMenuRadioButton.click();
		return this;
	}
	public CategoriesPage clickOnLeftMenuRadio() {
		showOnleftRadioButton.click();
		return this;
	}
	
	public CategoriesPage saveCategory() {
		saveButton.click();
		return this;
	}
	
	public boolean verifySuccessAlertThrown() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitToBeVisible(driver, alertPath);
		boolean greenBackground=false;
		String alertBackgroundColour=alertPath.getCssValue("background");
		if(alertBackgroundColour.contains("rgb(40, 167, 69)")) {
			greenBackground=true;
		}
		return greenBackground;
	}
}
