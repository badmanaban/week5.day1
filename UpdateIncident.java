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

public class UpdateIncident extends BaseClassIncident {

	//public static void main(String[] args) throws InterruptedException {
		@Test
		public void runUpdate() throws InterruptedException {
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
			
			WebElement urgency = driver.findElement(By.xpath("//select[@id='incident.urgency']")); 
			Select se = new Select(urgency); 
			se.selectByVisibleText("1 - High");	
			
			WebElement state = driver.findElement(By.xpath("//select[@id='incident.state']")); 
			Select sel = new Select(state); 
			sel.selectByVisibleText("In Progress");	
			
			driver.findElement(By.xpath("//button[text()='Update']")).click();
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
			driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
			
			String text = driver.findElement(By.xpath("//select[@id='incident.urgency']/option")).getText();
			System.out.println(text);
			
			if(text.contains("High")) {
				System.out.println("Record updated successfully");
				}
			 else {
				 System.out.println("Record not updated"); 
				 }
	}

}
