package utilities;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	 public void selectValueUsingSelectByVisibleText(WebElement dropdown,String VisibleText){
		Select select=new Select(dropdown);
		select.selectByVisibleText(VisibleText);
	 }
	 
	 public void selectValueUsingSelectByIndexValue(WebElement dropdown,int index){
		Select select=new Select(dropdown);
		select.selectByIndex(index);
	 }
	 
	 public void selectValueUsingSelectByValue(WebElement dropdown,String value){
		Select select=new Select(dropdown);
		select.selectByValue(value);
	 }
	 
	 public void dragAndDropElements(WebDriver driver, WebElement sourceElement, WebElement targetElement){			
		    Actions actions=new Actions(driver);
		    actions.dragAndDrop(sourceElement, targetElement).build().perform();
		}
	 
	 public String getAlertText(WebDriver driver,WebElement alertElement) {
		 String alertText=driver.switchTo().alert().getText();
		 return alertText;
	 }
	 
	 public void acceptAlert(WebDriver driver,WebElement alertElement) {
		 driver.switchTo().alert().accept();
	 }
	 
	 public void dismissAlert(WebDriver driver,WebElement alertElement) {
		 driver.switchTo().alert().dismiss();
	 }
	 
	 public void fillValueInAlert(WebDriver driver,WebElement alertElement,String fillInValue) {
		 driver.switchTo().alert().sendKeys(fillInValue);	
		 driver.switchTo().alert().accept();
	 }
	 
	 public void clickOnIframe(WebDriver driver,WebElement iframeElement, WebElement elementWithinIFrame) {
			driver.switchTo().frame(iframeElement);
			elementWithinIFrame.click();
		}
	 
	 public void scrollPageDown(WebDriver driver, int x, int y) {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(x,y)", "");
		  }
	 
	 public void scrollPageUp(WebDriver driver) {
		 JavascriptExecutor js=(JavascriptExecutor) driver;
		 js.executeScript("window.scrollBy(0,-350)", "");
	 }
	 
	 public void mouseHover(WebDriver driver,WebElement dragElement) {
		 Actions actions=new Actions(driver);
	    actions.moveToElement(dragElement).build().perform();
	 }
	 
	 public void doubleClick(WebDriver driver,WebElement doubleClickElement) {
		 Actions actions=new Actions(driver);
		 actions.doubleClick(doubleClickElement).build().perform();
	 }
	 
	 public void rightClick(WebDriver driver,WebElement rightClickElement) {
		 Actions actions=new Actions(driver);
	    actions.contextClick(rightClickElement).build().perform();
	 }
	 
	 public boolean isElementVisible(WebElement elementToCheckVisibility)
	 {
		 if(elementToCheckVisibility.isDisplayed())
		 return true;
		 else
		return false;
	 }
	 
	 
	 public boolean elementListIterator(WebDriver driver, List<WebElement> listXpath, String searchElement ) {
		 boolean elementFound=false;
		 List<WebElement> elementList=listXpath;
			for(WebElement currentElement:elementList) {
				String elementText=currentElement.getText();
				if(searchElement.equals(elementText)) {
					elementFound=true;
					break;
				}}
			return elementFound;
			}
	 
	 
}