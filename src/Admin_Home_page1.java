import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Admin_Home_page1 {
	WebDriver driver;

		@Test(priority=1)
		public void login() 
		{
			driver.findElement(By.id("cyclosUsername")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@value='1']")).click();
			driver.findElement(By.xpath("//input[@value='2']")).click();
			driver.findElement(By.xpath("//input[@value='3']")).click();
			driver.findElement(By.xpath("//input[@value='4']")).click();
			driver.findElement(By.xpath("//input[@value='Submit']")).click();

			driver.findElement(By.id("memberUsername")).sendKeys("pinkubhui");
			driver.findElement(By.id("memberName")).sendKeys("pinkubhui");

	  
  }
		@Test(priority=2)
		public void personal() throws AWTException, InterruptedException 
		{

		String expected="Application status";
		WebElement ele=driver.findElement(By.xpath("//table[1]/tbody/tr[1]/td[1]"));
		String actual=ele.getText();
		System.out.println(actual);
		assertEquals(actual,expected);
		}
		
  @BeforeClass
  public void beforeClass() {
	 
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://localhost:8585/");

  }

  @AfterClass
  public void afterClass() {
	  driver.quit();
  }


}
