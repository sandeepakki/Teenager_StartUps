package TeenagerStarup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

class CreatingBlog extends BaseClass{
	
	@Test
	public void testCreatingBlog()
	{
		driver.findElement(By.xpath("//a[contains(text(),'BLOG')]")).click();
		driver.findElement(By.linkText("Write your own Blog")).click();
		WebElement w1= driver.findElement(By.id("id_permission_for"));
		Select sl = new Select(w1);
		sl.selectByVisibleText("Blogger");
		driver.findElement(By.name("reason")).sendKeys("Please grant me access to publish blog");
		driver.findElement(By.xpath("//button[contains(text(),'Request Access')]")).click();
		String s1=driver.findElement(By.xpath("//p[contains(text(),'Your request for profile Blogger is')]")).getText();
		System.out.println(s1);
		SoftAssert SA=new SoftAssert();
		SA.assertEquals("Your request for profile Blogger is Pending","s1");
		
	}

}
