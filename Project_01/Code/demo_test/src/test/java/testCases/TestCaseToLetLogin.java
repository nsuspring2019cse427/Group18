package testCases;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestCaseToLetLogin {

	 WebDriver driver;
	
	 
	 public void login(){
			try{	
				
				driver= new FirefoxDriver();
				driver.get(StaticVariables.baseUrl);
				driver.findElement(By.name("username")).clear();
				driver.findElement(By.name("username")).sendKeys(StaticVariables.UserName); //valid id
				driver.findElement(By.name("password")).clear();
				driver.findElement(By.name("password")).sendKeys(StaticVariables.userPwd); //valid pwd
					
				driver.findElement(By.xpath("//input[@type='submit' and @value=' Submit ']")).click();
				Thread.sleep(3000);
								
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	 
	 
	 @Test
		public void login_verification(){
			try{	
				
				login();									
				String expectedHomePageTitle = "Welcome "; 
				String expectedhomePagetitle = driver.getTitle();
				
				System.out.println(expectedhomePagetitle + " found as title\n");
				assertEquals("Wrong_page_found", expectedHomePageTitle, expectedhomePagetitle); 
				System.out.println("Successfully loggedin \n");
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	 
	 
	 @Test
		public void logout_verification(){
			try{	
				
				login();
				
				driver.findElement(By.linkText("Sign Out")).click();				
				driver.findElement(By.xpath("//input[@type='submit' and @value=' Submit ']")).getText();
				
				String expectedLoginPageTitle = "Login Page"; 
				String actualLoginPageTitle = driver.getTitle();
				
				assertEquals("Wrong_page_found", expectedLoginPageTitle, actualLoginPageTitle); 
				
				System.out.println(actualLoginPageTitle + " found as title\n");
				System.out.println("Successfully log out \n");
				
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		 
}
