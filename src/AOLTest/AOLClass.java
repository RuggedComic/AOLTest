package AOLTest;

import java.util.Collection;
import java.util.Iterator;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AOLClass {
    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();
        String baseUrl = "http://www.aol.com";
        String subUrl1 = "http://www.aol.com/news";
        String subUrl2 = "http://www.aol.com/sports";
        String subUrl3 = "http://www.aol.com/entertainment";
        String subUrl4 = "";
        String subUrl5 = "http://mail.aol.com/?icid=aol.com-nav";
        String expectedTitle = "AOL - News, Sports, Weather, Entertainment, Local & Lifestyle";
        String searchText = "AOL Autos";
        String linkSelect = "Site Map - AOL Autos - Autoblog";
        String actualTitle = "";
        driver.get(baseUrl);

        System.out.println("Page title is: " + driver.getTitle());

        actualTitle = driver.getTitle();
        
        if(driver.getPageSource().contains("News"))
        	{
            	System.out.println("News text appears on page");
        		
        		if (driver.getPageSource().contains(subUrl1))
        		{
        			System.out.println("News text and link present");
        		}
        	}
        	else
        	{
        		System.out.println("News text does not appears on page");
        	}

        if(driver.getPageSource().contains("Sports"))
    		{
        		System.out.println("Sports text appears on page");
        		
        		if (driver.getPageSource().contains(subUrl2))
        		{
        			System.out.println("Sports text and link present");
        		}
    		}
    		else
    		{
    			System.out.println("Sports text does not appears on page");
    		}
        
        if(driver.getPageSource().contains("Entertainment"))
    		{
        		System.out.println("Entertainment text appears on page");
        		
        		if (driver.getPageSource().contains(subUrl3))
        		{
        			System.out.println("Entertainment text and link present");
        		}
    		}
    		else
    		{
    			System.out.println("Entertainment text does not appears on page");
    		}
        if(driver.getPageSource().contains("Web"))
    		{
        		System.out.println("Web text appears on page");
        		
        		if (driver.getPageSource().contains(subUrl4))
        		{
        			System.out.println("Web text and link present");
        		}
    		}
    		else
    		{
    			System.out.println("Web text does not appears on page");
    		}
        
        if(driver.getPageSource().contains("Mail"))
    		{
        		System.out.println("Mail text appears on page");
        		
        		if (driver.getPageSource().contains(subUrl5))
        		{
        			System.out.println("Mail text and link present");
        		}
    		}
    		else
    		{
    			System.out.println("Mail text does not appears on page");
    		}       
        if (actualTitle.contentEquals(expectedTitle))
        	{
            	System.out.println("Page title matches");
        	}
        	else
        	{
        		System.out.println("Page title does not match");
        	}
        
        System.out.println("Search for AOL Autos");
        System.out.println("-------");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(searchText);
        element.submit();
        
        System.out.println("Search Results selection");
        System.out.println("-------");
    
        WebDriverWait wait = new WebDriverWait(driver, 10);

        Collection<WebElement> links = driver.findElements(By.tagName("a"));
        Iterator<WebElement> i = links.iterator();
        
        while (i.hasNext())
        	{
                 WebElement element1 = i.next();
                 try
                 	{
                	 if (element1.getText().contains(linkSelect))
                 		{
                			wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText(linkSelect)));
                			driver.findElement(By.linkText(linkSelect)).click();
                 		}
                 	}
                 catch (NoSuchElementException e)
                 	{
                	 	System.out.println("Waiting for page to complete loading");
                 	}
                 }
        	} 
//       driver.quit();
    };