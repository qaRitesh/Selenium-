package impliyExplicitTime;

import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ImplicitlyWait {

	public static void main(String[] args) {

		ChromeOptions window =new ChromeOptions();	
		window.addArguments("--incognito");
		window.addArguments("--start-maximized");
		
		
		
	ChromeDriver	driver=new ChromeDriver(window); 
	driver.get("http://localhost:8888");
	
	
	// This is old version 3:		Deprecated.
	
			//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 
	// This is new version 4:
	 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	
	
	
		//username_insert:
		WebElement username=driver.findElement(By.xpath("//input[@name='user_name']"));
		username.clear();
		username.sendKeys("admin");
		
		//password_insert:	
			WebElement password=driver.findElement(By.xpath("//input[@name='user_password']"));
			password.clear();
			password.sendKeys("admin");
			
		//sing click:
			WebElement sing=driver.findElement(By.xpath("//input[@name='Login']"));
			sing.click();
			
		//home_page Marketing:
			Actions mouseover=new Actions(driver);
			WebDriverWait ab=new WebDriverWait(driver,Duration.ofSeconds(15));
	
			WebElement market=driver.findElement(By.xpath("//a[text()='Marketing']"));
			mouseover.moveToElement(market).build().perform();
			
		
			// access all marketing menu use and text give.
			List<WebElement>markepage = ab.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='Marketing_sub']//a")));
			for(int i=0;i<=markepage.size()-1;i++) {
							
				WebElement text=markepage.get(i);
				String marketmanu=text.getText();
				System.out.println(marketmanu);
			}
			
			
			
			Date dt1=new Date();
			long before=dt1.getTime();
			
			try {
			 ab.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Sales']")));
			}catch(Exception e) {
				
			}
			 Date dt2=new Date();
				long after=dt2.getTime();
				long time=after-before;
				System.out.println(time);
			
				
				
			WebElement sales=driver.findElement(By.xpath("//a[text()='Sales']"));
			mouseover.moveToElement(sales).build().perform();
			

	}

}
