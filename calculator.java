 package Datadriven;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class calculator 
{
	static WebDriver driver;
public static void main(String[] args) throws InterruptedException, IOException
{
WebDriverManager.chromedriver().setup();
driver=new ChromeDriver();
driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
driver.manage().window().maximize();
JavascriptExecutor js= (JavascriptExecutor)driver;
Thread.sleep(4000);
js.executeScript("window.scrollBy(0,450)");
String file="./src/test/resources/data.xlsx";
int rows=utility_file.getrowcount(file, "Sheet1");
System.out.println("File is uploaded");

for(int i=1;i<=rows;i++)
{
 //data from Excel file
String DepositAmount =utility_file.get_celldata(file, "sheet1",i, 0);
String length        =utility_file.get_celldata(file, "sheet1",i, 1);	
String interest_rate =utility_file.get_celldata(file, "sheet1",i, 2);	
String compounding   =utility_file.get_celldata(file, "sheet1",i, 3);	
String total         =utility_file.get_celldata(file, "sheet1",i, 4);		

//send above data to application
Object ad = driver.findElement(By.xpath("(//input[@minlength=2])[1]"));
((WebElement) ad).clear();
((WebElement) ad).sendKeys(DepositAmount);
Thread.sleep(2000);
Object bc=driver.findElement(By.xpath("(//input[@formcontrolname=\"cdLength\"])"));
((WebElement) bc).clear();
((WebElement) bc).sendKeys(length);
Thread.sleep(2000);
Object cd=driver.findElement(By.xpath("(//input[@minlength=\"2\"])[2]"));
((WebElement) cd).clear();
((WebElement) cd).sendKeys(interest_rate);
Thread.sleep(2000);                                                                                                                  
driver.findElement(By.xpath("//button[@type=\"submit\"]/div[1]")).click();
 

String actual = driver.findElement(By.xpath("//*[@id='displayTotalValue']")).getText();
Thread.sleep(2000);

if (actual.equalsIgnoreCase(total)) 
{
	System.out.println("Test passed");
	utility_file.setCellData(file,"sheet1",i,7,"passed");
	
}
else 
{
	System.out.println("test failed");
	utility_file.setCellData(file,"sheet1",i,7,"passed");
}

}
}}

