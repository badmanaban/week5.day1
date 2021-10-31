package week5.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateIncident extends BaseClassIncident {
	@Test
	public void runcreate() throws InterruptedException {
		driver.findElement(By.id("filter")).sendKeys("incident", Keys.ENTER);
		driver.findElement(By.xpath("(//div[text()='Create New'])[1]")).click();
		WebElement frame2 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));

		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//button[@id='lookup.incident.caller_id']")).click();

		Set<String> windowHandles = driver.getWindowHandles();
		List<String> l = new ArrayList<String>(windowHandles);
		driver.switchTo().window(l.get(1));

		driver.findElement(By.xpath("(//tbody[@class='list2_body']/tr/td[3]/a)[1]")).click();

		Set<String> windowHandles1 = driver.getWindowHandles();
		List<String> l1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(l1.get(0));

		WebElement frame3 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame3);

		driver.findElement(By.xpath("//input[@id='incident.short_description']")).sendKeys("test");
		Thread.sleep(2000);
		String text = driver.findElement(By.xpath("//input[@id='incident.number']")).getAttribute("value");
		System.out.println(text);
		driver.findElement(By.xpath("//button[@id='sysverb_insert_bottom']")).click();

		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> l2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(l2.get(0));

		WebElement frame4 = driver.findElement(By.xpath("//iframe[@id='gsft_main']"));
		driver.switchTo().frame(frame4);
		driver.findElement(By.xpath("//div[@class='input-group']/input")).sendKeys(text, Keys.ENTER);
		String text2 = driver.findElement(By.xpath("(//td[@class='vt']/a)[1]")).getText();
		if (text.equals(text2)) {
			System.out.println("Incident created successfully");
		} else {
			System.out.println("Incident not created");
		}

	}

}
