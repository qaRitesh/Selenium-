package javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class JavaScriptHandling {


	WebDriver webdriver=new ChromeDriver();
	JavascriptExecutor scripting= (JavascriptExecutor) webdriver;
	

	public void handling() throws InterruptedException {
		
		
		Actions ab=new Actions(webdriver);
		
		webdriver.navigate().to("http://localhost:8888/");
		String abc=webdriver.getPageSource();
		
		
		//UserName..
					///javaScript{ .value='' }
	WebElement	username=webdriver.findElement(By.xpath("//input[@name='user_name']"));	
			//username.sendKeys("admin");
			scripting.executeScript("arguments[0].value='admin'", username);

	//password..
			///javaScript{ .value='' }
	WebElement password=webdriver.findElement(By.xpath("//input[@name='user_password']"));
				//pg.sendKeys("admin");
				scripting.executeScript("arguments[0].value='admin'", password);
			
	//sing_in;:
				///javaScript { click }
			WebElement	sing=webdriver.findElement(By.xpath("//input[@name=\"Login\"]"));	
				scripting.executeScript("arguments[0].click()", sing);
	
							
	//marketing: 
				//javaScript{mouseover }
	WebElement marketing=webdriver.findElement(By.xpath("//a[text()='Marketing']"));
			//ab.moveToElement(marketing).build().perform();
			scripting.executeScript("if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}", marketing);
	
	//myhomepage text double click:
			//javaScript{double click }	
	WebElement hometext= webdriver.findElement(By.xpath("//td[contains(text(),'My Home')]"));
	scripting.executeScript("arguments[0].dispatchEvent(new MouseEvent('dblclick', { bubbles: true }));", hometext);
	System.out.println("vtiger");	
	Thread.sleep(5000);
	
	
	//scrollBy TopBottom:
	scripting.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	Thread.sleep(5000);
	
	//scrollIntoView:
	WebElement view =webdriver.findElement(By.xpath("//div[@id='stuff_11']"));
	scripting.executeScript("arguments[0].scrollIntoView(true)", view);
	
	//scrollby(X_axis,Y_axis):
	webdriver.get("http://www.youtube.com");
	scripting.executeScript("window.scrollBy(0,18000)");
	
	
	//driver.quit();
	}
	
	
	public void scoll() throws InterruptedException{
		
		
		webdriver.get("http://localhost:8888");
		
	// youtube source code.
		String sourceCode=webdriver.getPageSource();			
		Thread.sleep(5000);
		
	//	open w3.org 
		webdriver.get("https://validator.w3.org/");
	
	//click validate by Direct Input.
	WebElement	input=webdriver.findElement(By.xpath("//a[@href=\"#validate_by_input\"]"));
				input.click();
	
	//insert source code in textbox:
					WebElement	entertext=webdriver.findElement(By.xpath("//textarea[@id='fragment']"));		
							entertext.sendKeys(sourceCode);
							Thread.sleep(5000);
//	//click button:			
//							
//				WebElement submit=	webdriver.findElement(By.xpath("//fieldset[@id='extra_opt_direct']/following-sibling::p//a[@class='submit']"));	
//							submit.click();
							
			
							
	
	
		}
}
