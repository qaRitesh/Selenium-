package WebElement;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class size_location_select {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		WebDriver UI =new ChromeDriver();
		
//login vtiger:
		UI.get("http://localhost:8888/");
	WebElement Username=UI.findElement(By.name("user_name"));
				Username.clear();
				Username.sendKeys("admin");
		
	WebElement Password=UI.findElement(By.name("user_password"));
					Password.clear();
					Password.sendKeys("admin");
		UI.findElement(By.xpath("//input[@title='Login [Alt+L]']")).click();

		
		
		
//Click maketing :
		UI.findElement(By.linkText("Marketing")).click();
//click Create Campaign...:
		UI.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();
		

		
//check size in Campaign Information: 			pixel
		//Campaign Name textbox:
		 	Dimension campaignname_size=	UI.findElement(By.xpath("//input[@name='campaignname']")).getSize();
		 	int height=	campaignname_size.getHeight();
		 	int width= campaignname_size.getWidth();
		
		 	 System.out.println(height +","+ width);
		 	
		 	if (height>0 && width>0) {
		 		System.out.println("campaignname_textbox  Sixe is gretar then 0");
		 	}else {
		 		System.out.println("campaignname_textbox  Size is not  gretar then 0");
		 	}

		 	
// check location in Campaign Information:
		 ////Campaign Name textbox:
		 	Point campaignname_location=UI.findElement(By.xpath("//input[@name='campaignname']")).getLocation();
		 	int x=	campaignname_location.getX();
		 	int y= campaignname_location.getY();
		 	System.out.println(x +","+y);
		 	if (x>0 && y>0) {
		 		System.out.println("campaignname_textbox  location is gretar then 0");
		 	}else {
		 		System.out.println("campaignname_textbox location is not  gretar then 0");
		 	}
		 	
	
		 	
		 	
		 	
// SELECT Class (Dropdown)...	
		//There are two types of  use Single select and multi_select..
		 		
		 	//  isMultiple() == check it is single select dropdown or multi_select
	//	 	Single_select=selectByVisibleText / selectByvalue / selectByindex :
		 	
	//		Multi_select=	selectByVisibleText(); / selectByvalue(); / selectByindex(); :
		 		    	//  DeselectByVisibleText(); / DeselectByvalue(); / DEselectByindex(); / DeselectAll();	
		 
		 //Campaign Status..
		 	//check this is single select or multi_select..
		 	WebElement campaignstatus_select=UI.findElement(By.xpath("//select[@name='campaignstatus']"));
		 	
		 		Select campaignstatus_types=new Select(campaignstatus_select);
		 		
		 			boolean campaighststuesselect_types =campaignstatus_types.isMultiple();
		 			
		 				if(campaighststuesselect_types==false) {
		 					System.out.println("passed it is a Single Select types");
		 				}else{
		 					System.out.println("failed it is multi_select types");
		 				}
	
	//Campaign Type  _ Single select method use all in one :	 				
		 	
		 				
		 				//SelectbyVisibletext:			
		 				 WebElement	CampaignType_VisibleTexts=UI.findElement(By.xpath("//select[@name='campaigntype']"));
		 				 	Select CampaignType_byvisibles =new Select(CampaignType_VisibleTexts);
		 						CampaignType_byvisibles.selectByIndex(5);
		 				
		 	//SelectbyVisibletext:			
		 WebElement	CampaignType_VisibleText=UI.findElement(By.xpath("//select[@name='campaigntype']"));
		 	Select CampaignType_byvisible =new Select(CampaignType_VisibleText);
				CampaignType_byvisible.selectByVisibleText("Advertisement");
				
				
	//Campaign Status:
			//selectByValue:
		WebElement Camaignstatus_value=UI.findElement(By.xpath("//select[@name='campaignstatus']"));
			Select Camaignstatus_byvalue=new Select(Camaignstatus_value);	
				Camaignstatus_byvalue.selectByValue("Completed");
				
				
	//Expected Response:			
			//selectbyindex:	&&& 	getfirstselectoption:
				
		WebElement Expectedresponse_index=UI.findElement(By.xpath("//select[@name='expectedresponse']"));		
		Select Expectedresponse_byindex	=new Select(Expectedresponse_index);
		
				//getfirstselectoption:
				WebElement expectedresopen_default=Expectedresponse_byindex.getFirstSelectedOption();
						String  expected_option	=expectedresopen_default.getText();
						
						if(expected_option.equalsIgnoreCase("--None--")) {
							System.out.println("passed it defule select is none");
						}else {
							System.out.println("failed it  defule slect is not none");
						}
				
				//select a  option:
				Expectedresponse_byindex.selectByIndex(4);
				
				//after select option   getfirstselectoption:
			WebElement expectedrespone_afterselected =	Expectedresponse_byindex.getFirstSelectedOption();
						String expected_selectedoption= expectedrespone_afterselected.getText();
						if(expected_selectedoption.equalsIgnoreCase("poor")) {
							System.out.println("passed it  seleted option is poor ");
						}else {
							System.out.println("passed it  seleted option is not poor ");
						}
			

			List<WebElement> sb=Expectedresponse_byindex.getOptions();
					for(int i=0;i<=sb.size()-1;i++) {
						WebElement aa=sb.get(i);
						String bc=aa.getText();
						System.out.println(bc);
					}
			
			
			
	}
	
	

}
