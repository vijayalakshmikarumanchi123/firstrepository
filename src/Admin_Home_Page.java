//This module is validate to check the Transaction valid data

import org.testng.annotations.Test;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;



public class Admin_Home_Page{
	WebDriver driver;
	WebElement Memberlogin, Fullname, Loginname, Password, Submit	;
  @Test(priority=1) //one method
  public void login() {
	
	  driver.findElement(By.xpath("//input[@id='cyclosUsername']")).sendKeys("admin");
	  driver.findElement(By.xpath("//input[@value='1']")).click();
	  driver.findElement(By.xpath("//input[@value='2']")).click();
	  driver.findElement(By.xpath("//input[@value='3']")).click();
	  driver.findElement(By.xpath("//input[@value='4']")).click();
	  driver.findElement(By.xpath("//input[@value='Submit']")).click();
  }
  @Test(priority=2)
  public void transaction() throws InterruptedException{
	  driver.findElement(By.id("memberUsername")).sendKeys("pinkubhui");
	  driver.findElement(By.id("memberName")).sendKeys("pinkubhui");
	  Thread.sleep(3000);
	  
	  
	 driver.findElement(By.xpath("//input[@linkurl='accountOverview?memberId=3']")).click();
	 Select paymenttype = new Select(driver.findElement(By.name("query(paymentFilter)")));
	 paymenttype.selectByVisibleText("Member payments");
	 driver.findElement(By.xpath("//input[@id='memberUsername']")).sendKeys("pinkubhui");
	 driver.findElement(By.xpath("//input[@id='memberName']")).sendKeys("pinkubhui");
	 //driver.findElement(By.xpath("//input[@id='_id1577439942330_708']")).sendKeys("02/11/19");
	 driver.findElement(By.xpath("//input[@class='date small']")).sendKeys("02/11/19");
	 driver.findElement(By.xpath("//input[@class='date small']")).sendKeys("03/11/19");
	driver.findElement(By.xpath("//input[@name='query(description)']")).sendKeys("Filled entire details");
	 driver.findElement(By.xpath("//input[@value='Search']")).click();
	 
	 
	 String expected ="Search transactions of pinkubhui on Member account";
	 WebElement res = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]"));
	 String actual =res.getText();
	 System.out.println(actual);
	 assertEquals(actual,expected);
	
  }


  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
	  driver = new ChromeDriver();
	  driver.get("http://localhost:8585/do/admin/home?fromMenu=true");
  }

  @AfterClass
  public void afterClass()
  {
	  driver.close();
  }

  

}
