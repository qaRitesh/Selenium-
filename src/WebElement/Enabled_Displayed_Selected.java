package WebElement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Enabled_Displayed_Selected {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
  
		
		ChromeDriver E_D_S =new ChromeDriver();
		
		
		     E_D_S.get("http://localhost:8888/");
		
 //.getTitle()	
				//String ab=driver.getTitle();
//			System.out.println(ab);      /// title
				
//.getCurrentUrl()	
				//String ac=driver.getCurrentUrl();
//			System.out.println(ac);    //URL
		
		
 // login vtiger:				
				WebElement username=E_D_S.findElement(By.name("user_name"));	
				username.sendKeys("admin");	
				WebElement pass=E_D_S.findElement(By.name("user_password"));	
				pass.sendKeys("admin");
				E_D_S.findElement(By.xpath("//input[@title='Login [Alt+L]']")).click();
				
//click invetory:
				
	
				E_D_S.findElement(By.linkText("Inventory")).click();
		
//click create products..:					
				//.click()	
				        E_D_S.findElement(By.xpath("//img[@alt='Create Products...']")).click();
					    		
	//.isEnabled ()..
				        
				boolean product_calenderacutal=E_D_S.findElement(By.xpath("//img[@title='Open Calendar...']")).isEnabled();
				boolean product_calenderExpected=true;
				if (product_calenderacutal==product_calenderExpected) {
					System.out.println("it is calender enabled funshan");
				}else {
					System.out.println(" calender  not acutal enabled funshan");
				}
				
	//.isdisplayed()...
				boolean product_calcutlatoracutal=E_D_S.findElement(By.xpath("//img[@title='Open Calculator...']")).isDisplayed();
				boolean product_calcutlatorExpected= true;
				if (product_calcutlatoracutal==product_calcutlatorExpected) {
					System.out.println(" calender is display on ui screen");
				}else {
					System.out.println("calender is not display on ui screen");
				}
					
	//.isselected()..
				boolean product_price_vatacutal=E_D_S.findElement(By.xpath("//input[@id='tax1_check']")).isSelected();	
			    boolean	product_price_vatExpected=false;
				if (product_price_vatacutal==product_price_vatExpected) {
					System.out.println("Unit Price checkbox is not  unchecked");
				}else{
					System.out.println("Unit Price is checkbox checked");
	        
				}
	
	}

}
