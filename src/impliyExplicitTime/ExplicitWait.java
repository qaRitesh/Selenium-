package impliyExplicitTime;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		
		
		
		ChromeDriver	driver=new ChromeDriver();
		
		
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
			
			
						//Explicit_Wait
						//polling time:
			
			WebDriverWait explicit= new WebDriverWait(driver,Duration.ofSeconds(15));			
			explicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@name='user_password']")));
			
			
				WebElement password=driver.findElement(By.xpath("//input[@name='user_password']"));
				password.clear();
				password.sendKeys("admin");
				
				
//sing click:
				
				WebElement sing=driver.findElement(By.xpath("//input[@name='Login']"));
				sing.click();				
						
				
// home_page:	
				
				WebElement quickbuttom= driver.findElement(By.xpath("//select[@id='qccombo']"));
				quickbuttom.click();
				
			explicit.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//select[@id='qccombo']")));
			
						
				List<WebElement> quickmenu=driver.findElements(By.xpath("//select[@id='qccombo']/option"));
				for(int i=0;i<quickmenu.size()-1;i++) {
					
					WebElement qm=quickmenu.get(i);
					String optiontext=qm.getText();
					System.out.println(optiontext);
				}
				
	}
	
		//	Custom_Wait:
	/*
	 * public static boolean customwait(WebDriver driver,String xpath,int time) throws InterruptedException {
	 * driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
	 * 
	 * for(int i=0;i<time;i++) {
	 * 
	 * try{ 
	 * driver.findElement(By.xpath(xpath));
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
	 *  return true;
	 * 
	 * }catch(NullPointerException e) { 
	 * Thread.sleep(500); 
	 * }
	 *  }
	 * 
	 * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60)); return
	 * false;
	 * 
	 * }
	 */
	

}
