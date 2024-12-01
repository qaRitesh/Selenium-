package Xpath_class;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FindElements {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		ChromeDriver Dj=new ChromeDriver();
		
	     Actions  Cj= new Actions(Dj);
		
	     // Lunck url;
	     	Dj.navigate().to("http://localhost:8888/");
	     		Thread.sleep(5000);
	     		
	    //LOGIN_PAGE: 		
		//Username:
	     		
	     	WebElement username=Dj.findElement(By.xpath("//input[contains(@name,'user_name')]"));
	     		Cj.sendKeys(username,"admin",Keys.TAB).build().perform();
		//password:
	     		
	     	WebElement password=Dj.findElement(By.xpath("//input[contains(@name,'password')]"));
	     		Cj.sendKeys(password,"admin",Keys.TAB).build().perform();
	     		
		//Color theme;
	     		WebElement theme=Dj.findElement(By.xpath("//select[contains(@name,'login_theme')]"));
	     			Select colortheme=new Select(theme);
	     		// which type select option:
	     			boolean selecttype =colortheme.isMultiple();
	     					if(selecttype==false) {
	     						System.out.println("it is single select dropdown itmes");
	     					}
	     					else {
	     						System.out.println("it is multiple select dropdown itmes");
	     					}
	     		//auto select color theme:
	     			WebElement autofirst=colortheme.getFirstSelectedOption();
	     					String firstselect=autofirst.getText();
	     		     					if(firstselect.equalsIgnoreCase("softed")) {
	     		     						System.out.println("pass it is auto first select softed");
	     		     					}else {
	     		     						System.out.println("fail it is can not auto select first softed");
	     		     					}
	     		//select self  color theme:
	     		     					colortheme.selectByValue("woodspice");
	     		     	
	     //Login button Click:
	     		    WebElement loginbutton=Dj.findElement(By.xpath("//input[contains(@name,'Login')]"));
	     		     		Cj.moveToElement(loginbutton).click().build().perform();			
	     
	     		     		
	    //HomE_PAGE: 
	     		//Marketing:
	     		    WebElement inventory= Dj.findElement(By.xpath("//a[contains(text(),'Marketing')]"));
	     		     	Cj.moveToElement(inventory).build().perform();
	     		//check      	
	     		     	
	     		   WebElement Accounts=Dj.findElement(By.linkText("Accounts"));
	     		     	Cj.click(Accounts).build().perform();
	     		     	
	     	//  check box click use findelemtns:   	
	     		
	     		     List<WebElement>checkox=Dj.findElements(By.xpath("//input[contains(@name,'selected_id')]"));
	     		     	int length=checkox.size();
	     		     		System.out.println(length);
	     		     	
	     		   for(int i=0;i<=length-1;i++) {
	     			   
//	     			  WebElement checkbox=Dj.findElement(By.xpath("(//input[contains(@name,'selected_id')])["+i+"]"));  
//	     			 checkbox.click();
	     			   
	     			   WebElement check= checkox.get(i);
	     			   check.click();
	     		   }
	     		   
	     		   	
	     		   
	     		  List<WebElement> a=Dj.findElements(By.xpath("//a"));
	     		   		int totalsize=a.size();
	     		   			System.out.println(totalsize);
	     		   			
	     		   			int blankcount=0;
	     		   			int noblankcount=0;
	     		   			
	     		   			for(int i=0;i<=totalsize-1;i++) {
	     		   				WebElement text=a.get(i);
	     		   			String output=	text.getText();
	     		   			
	     		   				if(output.equalsIgnoreCase("")) {
	     		   					blankcount=blankcount+1;
	     		   				}
	     		   				else {
	     		   				noblankcount=noblankcount+1;
	     		   				}
	     		   			}
	     		   			
	     		   			System.out.println("blank"+blankcount);
	     		   		System.out.println("noblank"+noblankcount);
	}

}
