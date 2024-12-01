package Xpath_class;

import java.util.Iterator;
import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Absolut_Relative {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		
//url_link:
		ChromeDriver url=new ChromeDriver();
		
		Actions mouse=new Actions(url);
		
		url.navigate().to("http://localhost:8888/");
		Thread.sleep(5000);
		
//login_page:
		
		//username:
		WebElement	username=url.findElement(By.xpath("//input[@name='user_name']"));
			mouse.sendKeys(username,"admin",Keys.TAB).build().perform();
		//paasword:
		WebElement	password=url.findElement(By.xpath("//input[@name='user_password']"));
			mouse.sendKeys(password,"admin",Keys.TAB).build().perform();
		
		//color_thems:
		WebElement colors=url.findElement(By.xpath("//select[@name='login_theme']"));
				Select option=new Select(colors);
				
					// which types_select option:
					boolean type_select=option.isMultiple();
						if(type_select==false) {
							System.out.println("it is only single select");
						}
						else {
							System.out.println("it is only multiple select");
						}	
					//auto_select coor theme:
							 WebElement auto_select=option.getFirstSelectedOption();
							 	String auto_first=auto_select.getText();
							 		if(auto_first.equalsIgnoreCase("softed")) {
							 			System.out.println("pass It is auto select first option is softed");
							 		}
							 		else {
							 			System.out.println("Fail it is not Auto select first option is softed");
							 		}
					//choose theme manual select:
							 		option.selectByValue("woodspice");
							 		
		//Login Butoon Click:
							WebElement login_button=url.findElement(By.xpath("//input[@name='Login']"));
								mouse.moveToElement(login_button).click().build().perform();
							
//Home_page:
								
			//marketing_page click:
				WebElement marketing_click=url.findElement(By.xpath("//a[text()='Marketing']"));			
							mouse.moveToElement(marketing_click).click().build().perform();
							
		//top table name:
							System.out.println(" ");
							System.out.println("home manu toptext name");
							
					List<WebElement>top_tablename_text=url.findElements(By.xpath("//table[@class='hdrTabBg']//a[contains(@href,'index.php?')]"));			
						for(int i=0;i<=top_tablename_text.size()-1;i++) {
							WebElement toptext_name =top_tablename_text.get(i);
								String text_name =toptext_name.getText();
							System.out.println(text_name);
						}
						
		//marketing_submenu_text:
						System.out.println(" ");
						System.out.println("marketing sub menu text");
						
						WebElement marketing_mouse=url.findElement(By.xpath("//a[text()='Marketing']"));			
						mouse.moveToElement(marketing_mouse).build().perform();
						
					List<WebElement>marketing_submenu=url.findElements(By.xpath("//div[@id='Marketing_sub']//a[contains(@href,'index.php?')]"));
							for(int i=0;i<=marketing_submenu.size()-1;i++) {
									WebElement marketing_text= marketing_submenu.get(i);
										String submenu_text=marketing_text.getText();
									System.out.println(submenu_text);
							}
							
		//marketing home_page:
							System.out.println(" ");
							System.out.println("marketing home page  market_submanu toptable textname");
							
					List<WebElement> second_submenu=url.findElements(By.xpath("//table[@class='level2Bg']//a[contains(@href,'index.php?')]"));
							for(int i=0;i<=second_submenu.size()-1;i++) {
								WebElement market_submenu=second_submenu.get(i);
									String market_subtext=market_submenu.getText();	
									System.out.println(market_subtext);
							}
							
//Quick Create:
					 WebElement Quick =url.findElement(By.xpath("//select[@id='qccombo']"));
					 	mouse.click(Quick).build().perform();
							System.out.println(" ");
							System.out.println("Quick Crate option");
							
							List<WebElement>Quickcreate_option=url.findElements(By.xpath("//select[@id='qccombo']//option"));
							for(int i=0;i<Quickcreate_option.size();i++) {
								WebElement Quick_option=Quickcreate_option.get(i);
									String choose=Quick_option.getText();
										System.out.println(choose);
							}
							
							
							
							
							
							
							
							
							
							
							
							
							
							
	}
}
