package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class FileUtility {
	
	public void fileUploadUsingSendkeys(WebElement uploadButton,String filepath ) {
				uploadButton.sendKeys(filepath);
	}
	
	public void fileUploadUsingRobotClass(WebElement uploadPdfButton,String filepath) throws AWTException {
		
		uploadPdfButton.click();
		StringSelection ss = new StringSelection(filepath);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null); 
		Robot robot = new Robot(); 
		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER); 
		robot.keyRelease(KeyEvent.VK_ENTER); 
	    robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(90);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		
		
	}
}
