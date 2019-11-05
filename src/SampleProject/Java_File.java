package com.SampleProject1;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Java_File {
	public WebDriver driver;
	
	@BeforeMethod
	public void before() throws MalformedURLException
	{
		/*System.setProperty("webdriver.chrome.driver", "C:\\New Workspace\\chromedriver.exe");
		driver = new ChromeDriver();*/
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		String host = "35.230.246.81";
        driver = new RemoteWebDriver(new URL("http://" + host + ":4444/grid/register"), dc);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

@Test 
public void m1()
{
	driver.get("http://ec2-52-14-14-57.us-east-2.compute.amazonaws.com:8080/java-tomcat-maven-example/");
	String browserText=driver.findElement(By.xpath("//h2")).getText();
	System.out.println(browserText);
	Assert.assertTrue(browserText.equals("Hello World!"));
	driver.quit();
}

}  
