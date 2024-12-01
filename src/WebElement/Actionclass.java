package WebElement;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.Select;

public class Actionclass {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

	WebDriver ChromeObj=	new ChromeDriver();
		
		Actions ActObj=new Actions(ChromeObj);
		
	ChromeObj.navigate().to("http://localhost:8888/");
		
	
	
	//login:
			Thread.sleep(5000);
			WebElement username=ChromeObj.findElement(By.xpath("//input[contains(@name,'user_name')]"));
			ActObj.sendKeys(username, "admin").build().perform();
			ActObj.sendKeys(Keys.TAB).build().perform();
		//	username.sendKeys(Keys.TAB);
			WebElement password=	ChromeObj.findElement(By.xpath("//input[contains(@name,'user_password')]"));		
		    ActObj.sendKeys(password, "admin").sendKeys(Keys.TAB).build().perform();
		    
		    WebElement login_theme=	ChromeObj.findElement(By.xpath("//select[contains(@name,'login_theme')]"));
		    		Select color=new Select(login_theme);
		    				color.selectByValue("woodspice");
		// chick login button:
		    WebElement Login=	ChromeObj.findElement(By.xpath("//input[contains(@name,'Login')]"));
		    ActObj.moveToElement(Login).click().build().perform();
		   // ActObj.click(Login).build().perform();
		    
		 Thread.sleep(5000);											
	// my home page:
		   WebElement TopAccount= ChromeObj.findElement(By.xpath("//b[contains(text(),'Top Accounts')]"));
		   WebElement myrecentfaq= ChromeObj.findElement(By.xpath("//b[contains(text(),'My Recent FAQs')]"));
		    ActObj.clickAndHold(TopAccount).moveToElement(myrecentfaq).release().build().perform();
		
		   WebElement myrecent_lo= ChromeObj.findElement(By.xpath("//div[contains(@id,'stuff_1')][6]"));
		  ScrollOrigin myrecent_loccation=ScrollOrigin.fromElement(myrecent_lo);
		    ActObj.scrollFromOrigin(myrecent_loccation, 20, 2250).build().perform();
		    
		    Thread.sleep(5000);
		    
		   WebElement sales= ChromeObj.findElement(By.xpath("//a[text()='Sales']"));
		    ActObj.moveToElement(sales).build().perform();
		    
		   WebElement salesorder= ChromeObj.findElement(By.linkText("Sales Order"));
		    ActObj.contextClick(salesorder ).build().perform();
		    	Thread.sleep(5000);
		    
		    				ChromeObj.findElement(By.xpath("//a [contains(text(),'Marketing')]")).click();
		    					Thread.sleep(5000);	
		    					ChromeObj.navigate().back();
		    					
		    WebElement sales_2= ChromeObj.findElement(By.xpath("//a[text()='Sales']"));
		      ActObj.moveToElement(sales_2).build().perform();	
		      
		   WebElement Accounts= ChromeObj.findElement(By.linkText("Accounts"));
		    ActObj.click(Accounts).build().perform();
		    	Thread.sleep(5000);
		    
		    ChromeObj.navigate().back();
		    	Thread.sleep(5000);
		    ChromeObj.navigate().forward();
		    	Thread.sleep(5000);
		    ChromeObj.navigate().refresh();
		 
		    
		    
		    
	}

}
