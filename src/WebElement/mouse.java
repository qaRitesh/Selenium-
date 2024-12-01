package WebElement;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput.ScrollOrigin;
import org.openqa.selenium.support.ui.Select;

public class mouse {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver mouseover=new ChromeDriver();
	
//login vtiger:		
		mouseover.get("http://localhost:8888/");
	String	code=mouseover.getPageSource();
System.out.println(code);
		
		//username_texbox: textbox_size
		Dimension username_boxsize = mouseover.findElement(By.xpath("//input[@name='user_name']")).getSize();
					int hight_userbox=username_boxsize.getHeight();
					 int width_userbox=username_boxsize.getWidth();
					 System.out.println("This is hight of username_textbox = "+ hight_userbox + " This is Widht of username_textbox = " +width_userbox);
					 
		//username_login:
		WebElement username_login=mouseover.findElement(By.xpath("//input[@name='user_name']"));
					username_login.clear();
					username_login.sendKeys("admin");
		//password_login:		
		WebElement password_login=mouseover.findElement(By.xpath("//input[@name='user_password']"));
					password_login.clear();
					password_login.sendKeys("admin");
		
					
		//select  class use:
					
		//default theme color:
					WebElement defaultlogin_theme=	mouseover.findElement(By.xpath("//select[@name='login_theme']"));
								Select autocolortheme=	new Select(defaultlogin_theme);
						WebElement	auto_coclorcheck	=autocolortheme.getFirstSelectedOption();
						String auto_color  =auto_coclorcheck.getText();
						if(auto_color.equalsIgnoreCase("softed")) {
							System.out.println("it is Auto_Color softed select ");
						}else {
							System.out.println("it is not select Autonmatic  color in softed");
						}
						
						
		// color themes:
				WebElement login_theme=	mouseover.findElement(By.xpath("//select[@name='login_theme']"));
					Select choice_color=new Select(login_theme);
								choice_color.selectByValue("bluelagoon");
					
					
		//sign in click:
			WebElement signin_click=mouseover.findElement(By.xpath("//input[@name='Login']"));
						signin_click.click();
		
			Thread.sleep(5000);			
				
						
// Actions class use:
			
			   //  sendkeys , Click , dubleClick , contextClick , MovetoElement , ClickAndhold , release , DragAndDrop{},Scrolling():
						
						Actions actobj=new Actions(mouseover);
					
		//marketing {MOUSEOVER}:
					WebElement weMarketing=mouseover.findElement(By.xpath("//a[text()='Marketing']"));					
								actobj.moveToElement(weMarketing).build().perform();
										//Actions				//Actions  //Action
								
		//marketing in said click Leads {Right click}:				
					WebElement wecalendar=mouseover.findElement(By.linkText("Leads"));
				//	WebElement wecalendar=mouseover.findElement(By.xpath("//a[text()='Campaigns']"));    it is not work
								actobj.contextClick(wecalendar).build().perform();
								
								Thread.sleep(5000);
								
		//my home page {DragandDrop} :
						WebElement weDrag=mouseover.findElement(By.xpath("//b[contains(text(),'Top Sales Orders')]"));
					WebElement weDrop=	mouseover.findElement(By.xpath("//b[contains(text(),'Tag Cloud')]"));
								actobj.clickAndHold(weDrag).moveToElement(weDrop).release().build().perform();
															//same
							//actobj.dragAndDrop(weDrag, weDrop).build().perform();					
							
		//scrolling method use:
								
					//	actobj.scrollByAmount(28, 1141).build().perform();							
							WebElement scrolling=mouseover.findElement(By.xpath("//div[@id='stuff_1']"));	
						ScrollOrigin	myrecent=	ScrollOrigin.fromElement(scrolling);		
										actobj.scrollFromOrigin(myrecent, 10,25 ).build().perform();
					//	actobj.scrollToElement(scrolling).build().perform();
								
		// refresh,reload:
							//	mouseover.navigate().refresh();
//							mouseover.navigate().back();
//							mouseover.navigate().forward();
//							mouseover.navigate().to("http://localhost:8888");
										

							
	}

}
