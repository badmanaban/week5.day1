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

public class Assign extends BaseClassIncident{
	@Test
	public void runassign() throws InterruptedException {

		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Incidents'])[2]")).click();
		driver.findElement(By.xpath("(//div[text()='Open'])[1]")).click();
		WebElement frame4 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame4);

		WebElement findElement = driver.findElement(By.xpath("//select[@role='listbox']"));
		Select s = new Select(findElement);
		s.selectByVisibleText("Short description");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys("test", Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);

		String text = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(text);
		driver.findElement(By.xpath("(//span[@class=\"icon icon-search\"])[5]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));

		driver.findElement(By.xpath("//input[@class='form-control']")).sendKeys("software", Keys.ENTER);
		driver.findElement(By.xpath("//a[text()='Software']")).click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(l1.get(0));

		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//textarea[@id='activity-stream-textarea']")).sendKeys("test jd");
		driver.findElement(By.xpath("//button[text()='Update']")).click();

		WebElement findElements = driver.findElement(By.xpath("//select[@role='listbox']"));
		Select s1 = new Select(findElements);
		s1.selectByVisibleText("Number");
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(text, Keys.ENTER);
		driver.findElement(By.xpath("//a[@class='linked formlink']")).click();
		Thread.sleep(2000);
		String text2 = driver.findElement(By.xpath("//input[@id='sys_display.incident.assignment_group']")).getAttribute("value");
		System.out.println(text2);
		if (text2.contains("Software")) {
			System.out.println("Assigned properly");

		} else {
			System.out.println("Not assigned");
		}

	}
}
