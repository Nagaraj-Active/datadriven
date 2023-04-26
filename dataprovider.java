package Datadriven;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dataprovider {
WebDriver driver;
@BeforeClass
void lunch()
{
	WebDriverManager.chromedriver().setup();
    driver=new ChromeDriver();
    driver.get("https://www.facebook.com");
    driver.manage().window().maximize();
}

@Test(dataProvider = "dp")
void login(String username, String pswd) throws InterruptedException, AWTException
{
	WebElement mail = driver.findElement(By.xpath("//input[@type='text']"));
    mail.sendKeys(username);
    WebElement pwd=driver.findElement(By.xpath("//input[@name='pass']"));
    pwd.sendKeys(pswd);
    Robot rt=new Robot();
    rt.keyPress(KeyEvent.VK_ENTER);
    rt.keyRelease(KeyEvent.VK_ENTER);
Thread.sleep(3000);
}
@AfterClass
void logout()
{
	driver.quit();
}
@DataProvider(name="dp")
String[][] login_data()
{
	String[][]data= {
			{"raj@123","135467/"},
			{"rajmannale.com","aadfdf"},
			{"rajmannale@gmail.com","Nagu@123"},
			{"rajmannale@gmail.com","Nagu@1010"}
	};
	return data;
}
}
