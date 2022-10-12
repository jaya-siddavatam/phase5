package com.flipkart;

import java.util.function.Function;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FlipkartTesting {
	WebDriver driver;     
	
	 @Test
	public void flipkart() throws Exception  {
		
		driver.get("https://www.flipkart.com/search");
		driver.findElement(By.name("q")).sendKeys("iphone 13");
		driver.findElement(By.className("L0Z3Pu")).click();
		
		 Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(10,document.body.scrollHeight)");
		
		System.out.println("you have reached bottom of the page");
		
		
		//identifying the image with xpath
	      
		WebElement i = driver.findElement(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[2]/div/div/div/a/div[1]/div[1]/div/div/img"));
	    // Javascriptexecutor to check whether image is true or not
		
	      Boolean bool = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete " + "&& typeof arguments[0].naturalWidth != \"undefined\" " + "&& arguments[0].naturalWidth > 0", i);

	      if (bool) {
	         System.out.println("Image status is true");
	      } else {
	         System.out.println("Image status is false");
	      }
		
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .ignoring(NoSuchElementException.class);
        WebElement we = wait.until(new Function<WebDriver, WebElement>(){

            @Test
            public WebElement apply(WebDriver driver ){
                
                WebElement element = driver.findElement(By.className("_1_3w1N"));
      		  try {
      			Thread.sleep(3000);
      		} catch (Exception e) {
      			// TODO: handle exception
      		}
                String getText= element.getText();
                
                
                if(getText.equals("Login")) {
                    System.out.println(getText);
                    return element;
                }
                else {
                    System.out.println("Fluent Wait Fail");
                    return null;
                }         
                
            }
        });
        }
	@BeforeMethod
	public void beforeMethod() throws Exception {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Toshiba\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void afterMethod() {
		driver=null;
	}
}