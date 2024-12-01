package WebElement;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import graphql.org.antlr.v4.runtime.tree.xpath.XPath;

public class basic {

	public static void main(String[] args) throws InterruptedException {

		// selenium webdriver javadoc
		//https://www.selenium.dev/selenium/docs/api/java/


		//	 System.setProperties("wedriver.Chrome.driver","c:\\users\\");

		WebDriver driver= new FirefoxDriver();
				

		driver.get("http://localhost:8888/");
		//					Thread.sleep(2000);   // limited  time to hold 
		//					driver.close();


		//.getTitle()	
		//String ab=driver.getTitle();
		//				System.out.println(ab);      /// title

		//.getCurrentUrl()	
		String ac=driver.getCurrentUrl();
		//				System.out.println(ac);    //URL


		// xpath				
		//					driver.findElement(By.xpath("//img[@alt='Create Products...']");	 
		//					
		//					driver.findElement(By.xpath("//img[@alt='Create Products...']" [2]); 
		//					
		//					driver.findElement(By.xpath("(//img[@alt='Create Products...'])[last()-1]");
		//					
		//					driver.findElement(By.xpath("//img[@alt='Create Products...  and @title=' ']");
		//					
		//					driver.findElement(By.xpath("//img[@alt='Create Products...  or @title=' ']");



		// login vtiger:				
		WebElement username=driver.findElement(By.name("user_name"));	

		username.sendKeys("admin");	
		WebElement pass=driver.findElement(By.name("user_password"));	
		pass.sendKeys("admin");
		driver.findElement(By.xpath("//input[@title='Login [Alt+L]']")).click();

		// click invetory:


		driver.findElement(By.linkText("Inventory")).click();

		//click create products..:					
		//.click()	
		driver.findElement(By.xpath("//img[@alt='Create Products...']")).click();

		//check innertext name:  carrect or not..

		//.gettext() =innertext always seen on user interface. 		
		String acutaltext=driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		String expected="Creating New Products";
		boolean check=acutaltext.equalsIgnoreCase(expected);

		if (check== true) {
			System.out.println("innertext value is same or yes");
		}else {
			System.out.println("innertext value is  not  same or no");
		}


		//check	serching find: 

		//.getAttribute()= value attribute value always seen on UI.
		String AcutalFind=driver.findElement(By.xpath("//input[@class='searchBtn']")).getAttribute("value");
		String Expected="Find";
		boolean Findbutton=	AcutalFind.equalsIgnoreCase(AcutalFind);
		if(Findbutton==true) {
			System.out.println("Find Button text is correct ");
		}else {
			System.out.println("Find Button is not correct");
		}

		//product text_box check blank or not:
		// Blank product text box
		String product_tb=driver.findElement(By.xpath("//input[@class='searchBtn']")).getAttribute("value");
		String Eprodu_tb="Find";
		boolean proct_tbcheck=	product_tb.equalsIgnoreCase(Eprodu_tb);
		if(proct_tbcheck==true) {
			System.out.println("Product  text_box is blank");
		}else {
			System.out.println("Product  text_box isnot  blank");
		}	

		//insert a data.
		driver.findElement(By.xpath("//input[@class='searchBtn']")).sendKeys("ritesh");	
		// find      
		String product_insert=driver.findElement(By.xpath("//input[@class='searchBtn']")).getAttribute("value");
		String Eprodu_insert="Find";
		boolean proct_insert=	product_insert.equalsIgnoreCase(Eprodu_insert);
		if(proct_insert==true) {
			System.out.println("Product  text_box find  insert attributed value");
		}else {
			System.out.println("Product  text_box  not mechat find insert attributed value ");
		}


		//			
	}  


}
