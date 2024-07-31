package pages;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUtility;
import utilities.WaitUtility;

public class ManagePagesPage {

	public WebDriver driver;
	
	public ManagePagesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='javascript:void(0)' and @onclick='click_button(2)']") WebElement listpagesearchbutton;
	@FindBy(xpath="//p[text()='Manage Pages']/parent::div[@class=\"inner\"]/following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") WebElement managePageTile;
	@FindBy(xpath="//input[@type='text' and @placeholder='Title']") WebElement titleTextField;
	@FindBy(xpath="//input[@type='text' and @placeholder='Title']/parent::div[@class='col-sm-12 form-group']/following-sibling::div[@class='card-body']/button[@name='Search']") WebElement searchButtonForResult;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']/table[@class='table table-bordered table-hover table-sm']/tbody/tr") List<WebElement> searchpageresultlist;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']/table[@class='table table-bordered table-hover table-sm']/tbody/tr/td") List<WebElement> resultnotfound;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page' and @type='button']") WebElement resetbutton;
	@FindBy(xpath="//div[@class='col-sm-6']/h1[text()='List Pages']") WebElement pagetitle;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']") WebElement newbutton;
	@FindBy(xpath="//div[@class='col-sm-6']/h1[@class='m-0 text-dark'and text()='Add Pages']") WebElement newpageTitle;
	@FindBy(xpath="//input[@name='title' and @placeholder='Enter the Title']") WebElement pageTitleTextField;
	@FindBy(xpath="//div[@class='note-editing-area']/div[@class='note-editable card-block' and @role='textbox']") WebElement descriptionTextField;
	@FindBy(xpath="//input[@name='page' and @placeholder='Enter Page Name']") WebElement pageNameTextField;
	@FindBy(xpath="//label[text()='Image']/following-sibling::input[@type='file']") WebElement chooseFileButton;
	@FindBy(xpath="//label[text()='Image']/following-sibling::input[@type='file']/following-sibling::div") WebElement uploadImagePreview;
	@FindBy(xpath="//div[@class='card-footer']/button[@type='submit' and text()='Save']") WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement successAlert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/descendant::tr") List<WebElement> pagesList;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/descendant::tr/td[1]") List<WebElement> titleColumnList;
	public ManagePagesPage navigateToManagePages() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitToBeClicked(driver, managePageTile);
		managePageTile.click();
		return this;
	}
	
	public ManagePagesPage clickOnManagePagesSearchButton() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitToBeClicked(driver, listpagesearchbutton);
		listpagesearchbutton.click();
		return this;
	}
	
	public ManagePagesPage enterPageTitleToTextField(String pageTitleToSearch) {
		titleTextField.clear();
		titleTextField.sendKeys(pageTitleToSearch);
		return this;
	}
	
	public ManagePagesPage clickOnSearchToFetchResults() {
		WaitUtility waitutility=new WaitUtility();
		waitutility.explicitWaitToBeClicked(driver, searchButtonForResult);
		searchButtonForResult.click();
		return this;
	}
	
	public boolean searchResultTableItem() {
		if(searchpageresultlist.size()>1) 
			return true;
		else {
	if(resultnotfound.size()>1)			 
	      	return true; 
	    else
			return false;
		}
		}
	
	public ManagePagesPage clickOnResetButton() {
		resetbutton.click();
		return this;
	}
	
	public boolean verifyNavigationToManagePage() {
		boolean pageTitleDisplayed=pagetitle.isDisplayed();
		return pageTitleDisplayed;
	}
	
	public ManagePagesPage clickOnNewButton() {
		newbutton.click();
		return this;
	}
	
	public boolean verifyNavigationToAddPage() {
		 boolean addPageDisplayed=newpageTitle.isDisplayed();
		 return addPageDisplayed;
	}
	
	public ManagePagesPage fillTitleTextField(String title) {
		pageTitleTextField.sendKeys(title);
		return this;
	}
	
	public ManagePagesPage fillDescriptionTextArea(String description) {
		descriptionTextField.sendKeys(description);
		return this;
	}
	
	public ManagePagesPage fillPageNameField(String pagename) {
		pageNameTextField.sendKeys(pagename);
		return this;
	}
	
	public ManagePagesPage uploadImageFile(String filepath) {
		FileUtility fileUtility=new FileUtility();
		fileUtility.fileUploadUsingSendkeys(chooseFileButton, filepath);
		return this;
	}
	
	public boolean verifyFileUpload() {
		boolean imagePreviewDisplayed=uploadImagePreview.isDisplayed();
		return imagePreviewDisplayed;
	}
	
	public ManagePagesPage clickOnSaveButton() {
		saveButton.click();
		driver.navigate().back();
		return this;
	}
	
	public boolean verifyAlertIsDisplayed() {
		boolean alertdisplayed=successAlert.isDisplayed();
		return alertdisplayed;
	}
	
	public boolean verifyNewlyAddedPageInPageListUsingTitle(String searchTitle) {
		boolean titleListed=false;
		for(WebElement currentTitle:titleColumnList) {
			String getTitle=currentTitle.getText();
			if(searchTitle.equals(getTitle)) {
				titleListed=true;
				break;
			}}
		return titleListed;
		}
	
}
