package linkedin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ConnectWithUsers {
	static WebDriver driver= new ChromeDriver();
	static int cnt=0;
	//sleep Time
	public static void GetSomeSleep(int x) throws InterruptedException {
		Thread.sleep(x);
	}
	
	
	//login into the linkedin
	public static void LoginToLinkedin(String user,String pass) throws InterruptedException {
		driver.findElement(By.id("session_key")).click();
		driver.findElement(By.id("session_key")).sendKeys(user);//set email
		GetSomeSleep(2000);
		driver.findElement(By.id("session_password")).click();
		driver.findElement(By.id("session_password")).sendKeys(pass);//set password\
		driver.findElement(By.className("sign-in-form__submit-button")).click();//click login
		GetSomeSleep(2000);
	    driver.findElement(By.linkText("My Network")).click();//click on My network (Link type)
		GetSomeSleep(3000);

	}
	
	public static void MyNetworkPage() throws InterruptedException {
		int i=0;
		for(i=0;i<2; i++) ////page down 3 times by clicking on "Show more results"
		{	driver.findElement(By.xpath("//*[text()='Show more results']"));GetSomeSleep(3000);}
		//get all "Connect" buttons in page
		List<WebElement> elements = driver.findElements(By.xpath("//*[text()='Connect']"));
		for(WebElement element : elements) {//click on each element in the list above^
			try {
				element.click();
				GetSomeSleep(1000);
				}
			catch (Exception e) {
				System.out.println("");
				}
			
		}
		elements.clear();
	}
	
	
	
	public static void main(String[] args) throws InterruptedException {
		//setup
		System.setProperty("webdriver.chrome.driver", "C://Program Files//Selenium//exe//chromedriver.exe");
		driver.get("https://www.linkedin.com");
		try {
		LoginToLinkedin("enter_your_email","your_pass"); // login into Linkedin
		GetSomeSleep(1000);
		MyNetworkPage();//go to My Network page
		
		driver.close();
		}
		catch (Exception e) {
			System.out.println("");
			}
	}

}
