package com.prokarma.selenium.test;

import org.testng.annotations.Test;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class QueryTest {
  @Test
  public void queryTest() {
	        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addExtensions(new File("D:\\Allow-Control-Allow-Origin_-__v1.0.3.crx"));
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			ChromeDriver driver= new ChromeDriver(capabilities);
			//WebDriver driver = new FirefoxDriver();
			//throw new Exception("My Exception");
			driver.navigate().to("http://localhost:1234/#!/");
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement loginEmail=driver.findElement(By.id("login-username"));
			loginEmail.sendKeys("mohan");
			WebElement loginPassword=driver.findElement(By.cssSelector("input[type='password']"));
			loginPassword.sendKeys("sai123");
			WebElement loginSubmit=driver.findElement(By.cssSelector("button[type='submit']"));
			loginSubmit.click();
			WebElement ques=driver.findElement(By.xpath("//side-nav-directive/div/div[1]/a[3]"));
			ques.click();
			Select listbox = new Select(driver.findElement(By.xpath("//select[@id='searchby']")));
			listbox.selectByValue("ByID");
			WebElement searchById=driver.findElement(By.xpath("//div/span[1]/input"));
			searchById.sendKeys("4221");
			WebElement search=driver.findElement(By.xpath("//*[@id='myForm']/button"));
			search.click();
			driver.quit();
  }
}
