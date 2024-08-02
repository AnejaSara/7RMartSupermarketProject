package pages;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListProductsSearchPage {
	
	public WebDriver driver;
	public ListProductsSearchPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class=' nav-link' ]") private WebElement manageproductlink;
    @FindBy(xpath="//a[@onclick='click_button(2)']") private WebElement pagesearchbutton;
    @FindBy(xpath="//div[@class='card-body']/descendant::input[@name='un']") private WebElement titlefield;
    @FindBy(xpath = "//button[@type='submit' and @name='Search']") private WebElement productsearchbutton;
    @FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr") private List<WebElement> productsearchresult;
    @FindBy(xpath="//div[@class='dropdown']/ul[@class='dropdown-menu show']/li") private List<WebElement> productList;
   
    
    
    
    public ListProductsSearchPage productListPageNavigate() {
    	
    	manageproductlink.click();
    	return this;
    }
    
    
    public ListProductsSearchPage clickOnPageSearchButton() {
    	  pagesearchbutton.click();
    	  return this;
    }
    
    
    public ListProductsSearchPage enterProductNameInTitleField(String productname) {
    	       	titlefield.sendKeys(productname);
    	       	return this;
     }
    
    public ListProductsSearchPage clickOnProductSearchButton() {
    	productsearchbutton.click();
    	return this;
  }
    
    public boolean searchResultTableItem() {
    	 boolean isProductlisted=productsearchresult.isEmpty();
      	return isProductlisted;
    }
    
    public ListProductsSearchPage searchByProductId(String productid) {
    	
    	String xpathstring="//button[text()='"+productid+"']/parent::td/following-sibling::td/a[contains(@href, 'delete') and contains(@onclick, 'delete')]";
    	WebElement xpathwithproduct=driver.findElement(By.xpath(xpathstring));
    	xpathwithproduct.click();
    	return this;
    }

    
    
}
