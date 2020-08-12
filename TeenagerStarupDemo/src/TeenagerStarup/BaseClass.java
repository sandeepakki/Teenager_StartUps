package TeenagerStarup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

public class BaseClass {

	public static WebDriver driver;
	
	@BeforeTest
	public void OpenBrowser()
	{
		String browser="Firefox";
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver","C:\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		driver.get("https://www.teenagerstartups.com/accounts/login/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.close();
	}
	@BeforeClass()
	public void Login()
	{
		driver.findElement(By.id("id_username")).sendKeys("sandeepakki03@gmail.com");
		driver.findElement(By.id("id_password")).sendKeys("San@30041994");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
	}
	
	@AfterClass()
	public void Logout() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.linkText("LOGOUT"));
	}
	
}
