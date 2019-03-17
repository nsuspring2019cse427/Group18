package testCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTests {

private WebDriver driver;

@Before
public void initialize(){
initializeDriver("chrome");
}

@Test
public void testForInvalidCredentials(){
driver.get("https://www.facebook.com/");
WebElement email = driver.findElement(By.name("email"));
email.sendKeys("dev@gmail.com");
WebElement pass = driver.findElement(By.name("pass"));
pass.sendKeys("password");
driver.findElement(By.id("u_0_2")).click();
try{
driver.findElement(By.xpath("//div[text()='Please re-enter your password']"));
}catch(WebDriverException e){
Assert.fail();
}
}

@Test
public void testForInvalidCredentialsGmail(){
driver.get("https://accounts.google.com/signin");
WebElement email = driver.findElement(By.name("identifier"));
email.sendKeys("sadianisa13@gmail.com");
driver.findElement(By.xpath("//span[@class='RveJvd snByac']")).click();
WebElement pass = driver.findElement(By.name("password"));
pass.sendKeys("Tintin_2012");
driver.findElement(By.id("signIn")).click();
try{
String text = driver.findElement(By.id("errormsg_0_Passwd")).getText();
text = text.trim();
Assert.assertEquals("The email or password you entered is incorrect. ?", text);
}catch(WebDriverException e){
Assert.fail();
}
}

@Test
public void testForValidCredentials(){
driver.get("https://www.facebook.com/");
WebElement email = driver.findElement(By.name("email"));
email.sendKeys("summer.wine13@yahoo.com");
WebElement pass = driver.findElement(By.name("pass"));
pass.sendKeys("ILoveTheeAllah_1991");
driver.findElement(By.id("u_0_2")).click();
try {
Thread.sleep(10000);
} catch (InterruptedException e1) {
// TODO Auto-generated catch block
e1.printStackTrace();
}
try{
driver.findElement(By.xpath("//span[text()='News Feed']"));
}catch(WebDriverException e){
Assert.fail();
}
}

@After
public void tearDown(){
driver.close();
driver.quit();
}

private void initializeDriver(String browser) {
if("chrome".equalsIgnoreCase(browser))
{
System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
ChromeOptions options = new ChromeOptions();
options.addArguments("start-maximized");
options.addArguments("--test-type");
options.addArguments("chrome.switches","--disable-extensions");
driver = new ChromeDriver(options);
}
else
{
driver = new FirefoxDriver();
driver.manage().window().maximize();
}
}
}