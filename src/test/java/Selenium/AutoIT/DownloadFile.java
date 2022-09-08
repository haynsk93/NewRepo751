package Selenium.AutoIT;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DownloadFile {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		
		String dPath =System.getProperty("user.dir");
System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Udemy\\Grid\\chromedriver.exe");


HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
chromePrefs.put("profile.default_content_settings.popups", 0);
chromePrefs.put("download.default_directory", dPath);


       ChromeOptions c = new ChromeOptions();
       c.setExperimentalOption("prefs", chromePrefs);
		
		
		ChromeDriver driver = new ChromeDriver(c);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.ilovepdf.com/pdf_to_word");
		driver.findElement(By.id("pickfiles")).click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec("C:\\Selenium\\Udemy\\AutoIT\\FileUpload.exe");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("processTaskTextBtn")));
		
		driver.findElement(By.id("processTaskTextBtn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pickfiles")));
		
		driver.findElement(By.id("pickfiles")).click();
		File f =new File(dPath+"/Document+1 (1).docx");
		                     //give a forward slash to concantinate with object.
		
		Thread.sleep(2000);
		if(f.exists())
		{
			System.out.println("File Downloaded");
			f.delete();
		}
		driver.quit();
	}

}
