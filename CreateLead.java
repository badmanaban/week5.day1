package week5.day1;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends BaseClass {

	//public static void main(String[] args) {
	@Test
	public void runcreate() {
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("dotgo");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("bathu");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("jd");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9751093613");
		driver.findElement(By.name("submitButton")).click();
		
		
}
}






