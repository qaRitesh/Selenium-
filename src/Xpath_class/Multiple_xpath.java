package Xpath_class;



import java.awt.RenderingHints.Key;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Multiple_xpath {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
		ChromeDriver Driver=new ChromeDriver();
		
		Actions abc= new Actions(Driver);
		 
		Driver.navigate().to("http://localhost:8888/");
		
		Thread.sleep(5000);
		
		//username_texbox: textbox_size
				Dimension username_boxsize = Driver.findElement(By.xpath("//input[@name='user_name']")).getSize();
							int hight_userbox=username_boxsize.getHeight();
							 int width_userbox=username_boxsize.getWidth();
							 System.out.println("This is hight of username_textbox = "+ hight_userbox + " This is Widht of username_textbox = " +width_userbox);
							 
		//username_login:					 
							 WebElement username= Driver.findElement(By.xpath("//input[@name='user_name']"));
			abc.sendKeys(username, "admin").sendKeys(username,Keys.TAB).build().perform();
		//password_login:
			WebElement password= Driver.findElement(By.xpath("//input[contains(@name,'user_password')]"));
			abc.sendKeys(password,"admin",Keys.TAB).build().perform();
		
		
	//select  class use:
		
		//check which types items select  { single_select and multiple_select}	
			WebElement color_theme= Driver.findElement(By.xpath("//select[contains(@name,'login_theme')]"));
			   Select choose=new Select(color_theme);
			    Boolean	check=choose.isMultiple();
			    if(check==false) {
			    	System.out.println("it is provided single select items");
			    }
			    else {
			    	System.out.println("it is provided multiple select items");
			    }
		   
		 //default theme color:
		// check auto select item by default 
				 WebElement first=  choose.getFirstSelectedOption();
				 String expeted=first.getText();
				
				 if(expeted.equalsIgnoreCase("softed")) {
					 System.out.println("It is auto select softed");
				 }
				 else {
					 System.out.println("it is not auto select softed");
				 }
		//choose a bluelagoon color theme:
				 choose.selectByVisibleText("bluelagoon");
		
		//login  button click:
			WebElement loginclick= Driver.findElement(By.xpath("//input[contains(@name,'Login')]"));	
			abc.moveToElement(loginclick).click().build().perform();
			
		//Click marketing;
			WebElement marketing= Driver.findElement(By.xpath("//a[contains(text(),'Marketing')]"));
				abc.moveToElement(marketing).click().build().perform();
				 Thread.sleep(2000);
			
			
		//all  data is select:
				for(int i=1;i<=4;i++) {
					Driver.findElement(By.xpath("(//input[contains(@name,'selected_id')])["+ i +"]")).click();	
				}		
		// check all checkbox select or not:	
				boolean selectall=Driver.findElement(By.xpath("(//input[contains(@name,'selectall')])")).isSelected();
							if(selectall==true) {
								System.out.println("all check box is selected");
							}
							else{
								System.out.println("all check box is not select");
							}
					Thread.sleep(5000);		
			
					
		//chick All checkbox is unchecked:
					Driver.findElement(By.xpath("(//input[contains(@name,'selectall')])")).click();
					Thread.sleep(5000);
					
					
		//select only starting 3 checkbox;				
							for(int i=1;i<=3;i++) {
								Driver.findElement(By.xpath("(//input[contains(@name,'selected_id')])["+ i +"]")).click();	
							}
							Thread.sleep(5000);	
		// check all select or not:	
								boolean selectnotall=Driver.findElement(By.xpath("(//input[contains(@name,'selectall')])")).isSelected();
											if(selectnotall==false) {
												System.out.println("all check box is  not selected");
											}
											else{
												System.out.println("all check box is  select");
											}
							Thread.sleep(5000);			
			
							
			//chick All checkbox is checked:					
							Driver.findElement(By.xpath("(//input[contains(@name,'selectall')])")).click();
							boolean selectedall=Driver.findElement(By.xpath("(//input[contains(@name,'selectall')])")).isSelected();
							if(selectedall==true) {
								System.out.println("all check box is selected");
							}
							else{
								System.out.println("all check box is not select");
							}						
	}

}