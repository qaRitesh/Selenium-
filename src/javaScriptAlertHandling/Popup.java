package javaScriptAlertHandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Popup {
			
	//manage.window.minimize();
	//manage.window.maximize();
				
			//SwitchTo.alert.accept();
			//SwitchTo.alert.dismiss();
			//SwitchTo.alert.gettext();
			//SwitchTo.alert.sendkeys();
	
	public static void main(String[] args) throws InterruptedException {
		Popup pop=new Popup();
				pop.windowSize();
				pop.loging();
				pop.marketingPage();		
	}
	
	WebDriver localhost=new ChromeDriver();
	Actions mouse=new Actions(localhost);
	
	
	
	public void windowSize() throws InterruptedException {
		
		localhost.get("http://localhost:8888");
		
		//screen_size maximize:
		localhost.manage().window().maximize();
		Thread.sleep(5000);
		
			//screen_size minimize:
		localhost.manage().window().minimize();
		Thread.sleep(5000);
			
		//screen_size maximize:
				localhost.manage().window().maximize();
			
	}
	
	public void loging() throws InterruptedException {
		
		//username_insert:
				WebElement username=localhost.findElement(By.xpath("//input[@name='user_name']"));
				username.clear();
				username.sendKeys("admin");
				
			//password_insert:	
				WebElement password=localhost.findElement(By.xpath("//input[@name='user_password']"));
				password.clear();
				password.sendKeys("admin");
				
			//sing click:
				WebElement sing=localhost.findElement(By.xpath("//input[@name='Login']"));
				sing.click();
			//	Thread.sleep(5000);
	}
	
	public void marketingPage() throws InterruptedException {
		
		//Marketing mouseover:
		WebElement marketingSubmenu=localhost.findElement(By.xpath("//a[text()='Marketing']"));
		mouse.moveToElement(marketingSubmenu).build().perform();
		
		//click Accountpage:
		WebElement clickAccount=localhost.findElement(By.linkText("Accounts"));
		mouse.click(clickAccount).build().perform();
		Thread.sleep(3000);
		
		//click check  one item_box:
		WebElement iteamno10=localhost.findElement(By.xpath("//input[@id='126']"));
		mouse.click(iteamno10).build().perform();
		Thread.sleep(3000);
		
		//click delete buttom top side:
		WebElement delete=localhost.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]"));
		mouse.click(delete).build().perform();
		Thread.sleep(3000);
		
		
		//popup text match:
		String popup= localhost.switchTo().alert().getText();
		String popuptext="Deleting this account(s) will remove its related Potentials & Quotes. Are you sure you want to delete the selected 1 records?";
		if(popup.equals(popuptext)) {
			System.out.println("Popup String is be same and  match");
		}else {
			System.out.println("popup String is be not same and not match");
		}
		Thread.sleep(5000);
		
		//popup use sendkeys insert popup massage:
			// localhost.switchTo().alert().sendKeys();
		
		// dismiss and cancel popup screen:	
		localhost.switchTo().alert().dismiss();
		
		// item deselect
		WebElement iteamno=localhost.findElement(By.xpath("//input[@id='126']"));
		mouse.click(iteamno).build().perform();
		Thread.sleep(3000);
		
		//click check  one item_box:
				WebElement itemno9=localhost.findElement(By.xpath("//input[@id='127']"));
				mouse.click(itemno9).build().perform();
				Thread.sleep(3000);
				
				//click delete buttom top side:
				WebElement delete2=localhost.findElement(By.xpath("(//input[@class='crmbutton small delete'])[1]"));
				mouse.click(delete2).build().perform();
				Thread.sleep(3000);
		
	// delete item no 9	:
				localhost.switchTo().alert().accept();
		
		
	}
	

}
