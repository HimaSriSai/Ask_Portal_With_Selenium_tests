package com.prokarma.selenium.test;

import org.testng.annotations.Test;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class PostYourQueryTest {
  @Test
  public void postYourQueryTest() {
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
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(16, TimeUnit.SECONDS).pollingEvery(3, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Post Your Query")));
		WebElement postQuery=driver.findElement(By.xpath("//div/div[1]/a[2]"));
		postQuery.click();
		Select listbox = new Select(driver.findElement(By.xpath("//select[@id='categorySelect']")));
		listbox.selectByValue("string:angular");
		WebElement postQues=driver.findElement(By.xpath("//*[@id='postQuery']/div[3]/div[2]/textarea"));
		postQues.sendKeys("What do you think about akhil?");
		WebElement quesSubmit=driver.findElement(By.xpath("//*[@id='postQuery']/div[4]/div[2]/button"));
		quesSubmit.click();
		driver.quit();
  }
}
