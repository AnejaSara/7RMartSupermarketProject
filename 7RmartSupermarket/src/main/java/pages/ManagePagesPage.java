package pages;


import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.FileUtility;
import utilities.PageUtility;
import utilities.WaitUtility;

public class ManagePagesPage {

	public WebDriver driver;
		public ManagePagesPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='javascript:void(0)' and @onclick='click_button(2)']") private WebElement listpagesearchbutton;
	@FindBy(xpath="//p[text()='Manage Pages']/parent::div[@class=\"inner\"]/following-sibling::a[@href='https://groceryapp.uniqassosiates.com/admin/list-page']") private WebElement managePageTile;
	@FindBy(xpath="//input[@type='text' and @placeholder='Title']") private WebElement titleTextField;
	@FindBy(xpath="//input[@type='text' and @placeholder='Title']/parent::div[@class='col-sm-12 form-group']/following-sibling::div[@class='card-body']/button[@name='Search']") private WebElement searchButtonForResult;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']/table[@class='table table-bordered table-hover table-sm']/tbody/tr")private List<WebElement> searchpageresultlist;
	@FindBy(xpath="//div[@class='card-body table-responsive p-0']/table[@class='table table-bordered table-hover table-sm']/tbody/tr/td") private List<WebElement> resultnotfound;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-page' and @type='button']") private WebElement resetbutton;
	@FindBy(xpath="//div[@class='col-sm-6']/h1[text()='List Pages']") private WebElement pagetitle;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/pages/add']")private WebElement newbutton;
	@FindBy(xpath="//div[@class='col-sm-6']/h1[@class='m-0 text-dark'and text()='Add Pages']") private WebElement newpageTitle;
	@FindBy(xpath="//input[@name='title' and @placeholder='Enter the Title']") private WebElement pageTitleTextField;
	@FindBy(xpath="//div[@class='note-editing-area']/div[@class='note-editable card-block' and @role='textbox']") private WebElement descriptionTextField;
	@FindBy(xpath="//input[@name='page' and @placeholder='Enter Page Name']") private WebElement pageNameTextField;
	@FindBy(xpath="//label[text()='Image']/following-sibling::input[@type='file']") private WebElement chooseFileButton;
	@FindBy(xpath="//label[text()='Image']/following-sibling::input[@type='file']/following-sibling::div") private WebElement uploadImagePreview;
	@FindBy(xpath="//div[@class='card-footer']/button[@type='submit' and text()='Save']") private WebElement saveButton;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") private WebElement successAlert;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/descendant::tr") private List<WebElement> pagesList;
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/descendant::tr/td[1]") private List<WebElement> titleColumnList;
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
		PageUtility pageutility=new PageUtility();
		boolean elementListed=pageutility.elementListIterator(driver, titleColumnList, searchTitle);
		return elementListed;
	}
}
