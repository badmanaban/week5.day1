package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteIncident extends BaseClassIncident{

	//public static void main(String[] args) throws InterruptedException {
	@Test	
	public void runDelete() throws InterruptedException {		
		driver.findElement(By.id("filter")).sendKeys("incident",Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		WebElement frame4 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame4);
		
		WebElement findElement = driver.findElement(By.xpath("//select[@role='listbox']")); 
		Select s = new Select(findElement); 
		s.selectByVisibleText("Short description");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("test",Keys.ENTER);
		
		 driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		 Thread.sleep(2000);
		String no = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
			System.out.println(no);
		 driver.findElement(By.xpath("//button[text()='Delete']")).click();
		 driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		
		 Set<String> windowHandles2 = driver.getWindowHandles();
			List<String> l2 = new ArrayList<String>(windowHandles2);
			driver.switchTo().window(l2.get(0));
			
			WebElement framefr = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
			driver.switchTo().frame(framefr);
			 Thread.sleep(2000);
			 
			 WebElement findElement2 = driver.findElement(By.xpath("//select[@role='listbox']")); 
				Select s1 = new Select(findElement2); 
				s1.selectByVisibleText("Number");
			driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(no,Keys.ENTER);
			
			String text2 = driver.findElement(By.xpath("//td[text()='No records to display']")).getText(); 
			if(text2.contains("No records")) {
				System.out.println("Record deleted successfully");
				}
			 else {
				 System.out.println("Record not deleted"); 
				 }
			 	}

}
