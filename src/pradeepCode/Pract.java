package pradeepCode;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class Pract {
	public static void main(String[] args) throws IOException {
		WebDriver driver= new ChromeDriver();
		driver.get("http://localhost:8888/");
		
//takeScreenShort:		
		TakesScreenshot tss=(TakesScreenshot) driver;
		File source=tss.getScreenshotAs(OutputType.FILE);
		File target=new File("src\\abc.file.jpeg");
		Files.copy(source, target);
		
//find-date formation
	DateFormat	df=new SimpleDateFormat("dd_MM_yyyy hh:mm:ss a");
	String dateTime=df.format(new Date());
	
//			TimeZone.setDefault(SimpleTimeZone.UTC_TIME);

		
		List<WebElement> list=driver.findElements(By.tagName("a"));
		for(WebElement strval:list) {
			String s=strval.getAttribute("href");
			System.out.println(s);
			URL uri=new URL(s);
			HttpURLConnection httpUrlConnection=(HttpURLConnection)uri.openConnection();
			int responceCode=httpUrlConnection.getResponseCode();
			if(responceCode==200) {
				System.out.println("user are able to find the brokenlinks");
			}else {
				System.out.println("user are unable to find the brokenlinks");
			}
			
		}
		
		
		
		
		}
	}