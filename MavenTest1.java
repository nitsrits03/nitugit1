package testPackage;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MavenTest1 {
	
	public String baseUrl = "https://www.makemytrip.com/";  
	String driverPath = "E:\\\\sel\\\\chromedriver\\\\chromedriver.exe";  
	public WebDriver driver ;   
	@Test             
	public void test() {      
	// set the system property for Chrome driver      
	System.setProperty("webdriver.chrome.driver", driverPath);  
	// Create driver object for CHROME browser  
	driver = new ChromeDriver();  
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  
	driver.manage().window().maximize();  
	driver.get(baseUrl);  
	// get the current URL of the page  
	String URL= driver.getCurrentUrl();  
	System.out.print(URL);  
	//get the title of the page  
	String title = driver.getTitle();                  
	System.out.println(title);  
	}     
	@BeforeTest  
	public void beforeTest() throws InterruptedException {    
	System.out.println("before test");  
	driver.findElement(By.xpath("//input[@id='hp-widget_sTo']")).click();
	driver.findElement(By.xpath("//input[@id='hp-widget_sTo']")).clear();
	Thread.sleep(3000);
	List<WebElement> toCities = driver.findElements(By.xpath("/*[@id=\"react-autowhatever-1-section-0-item-0\"]/div/div[1]/p[1]//*[text()='kolkata, India']\r\n"
			+ ""));
	System.out.println(toCities.size()+"\n");
	for(int t=0;t<=toCities.size();t++)
	{
		WebElement element = toCities.get(t);
		
	}
	Thread.sleep(3000);
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/label/span")).click();
	Thread.sleep(3000);
	
	String date = "03-MARCH-2021";
	String split1[]= date.split("-");
	String[] splitter = null;
	String moth_year = splitter[1];
	String day = splitter[0];
	char[] month_year = null;
	System.out.println(month_year);
	System.out.println(day);
	
	selectDate(month_year,day);
	
	driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/p/a//*text()='Search'"));
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollBy(0,3000");
	
	//view prices
	driver.findElement(By.xpath("")).click();
	
	// store the current window
	String parentWindow = driver.getWindowHandle();
	//book now
	driver.findElement(By.xpath("//*[@id=\"fli_list_item_1_RKEY:a95c32e1-1826-4909-8e86-21a06477f279:23_0\"]/div[3]/div[1]/div[2]/div[2]/div[2]/button")).click();
	for(String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle);
	}
	
	// Verifying text on the page
	String bodyText = driver.findElement(By.xpath("//*[@id=\"rev-header\"]/div/div/div/h4")).getText();
	Assert.assertEquals("Text not found", bodyText.contains("Review your booking"));
	}     
	
	@AfterTest  
	public void afterTest() {  
	driver.close();  

	}
	private static void selectDate(char[] month_year, String day) {
	
		
	}
}
