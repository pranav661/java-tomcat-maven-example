package SampleProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Java_File {
	public WebDriver driver;
	
	@BeforeMethod
	public void before()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

@Test 
public void m1()
{
	driver.get("http://ec2-3-15-199-12.us-east-2.compute.amazonaws.com:8080/java-tomcat-maven-example/");
	String browserText=driver.findElement(By.xpath("//h2")).getText();
	System.out.println(browserText);
	Assert.assertTrue(browserText.equals("Hello World!"));
	driver.quit();
}

}  
