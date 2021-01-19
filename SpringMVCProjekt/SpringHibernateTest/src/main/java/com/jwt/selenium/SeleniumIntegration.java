package com.jwt.selenium;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumIntegration {

	private WebDriver d;
	private WebDriverWait driverwait;
	private String baseUrl;

	@BeforeClass
	public void setUp() {
		d = new ChromeDriver();
		baseUrl = "http://localhost:8090/SpringMVCHibernateCRUD/";
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.manage().window().maximize();
		d.get(baseUrl);

	}

	@BeforeMethod
		private void pressButtons() throws InterruptedException {
		WebElement buttonElement = d.findElement(By
				.cssSelector("table:nth-child(2) tbody:nth-child(1) tr:nth-child(4) td:nth-child(6) > a:nth-child(1)"));
		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(1000);
		buttonElement.click();
		Thread.sleep(3000);
		WebElement textChanging3 = d.findElement(By.id("email"));
		textChanging3.clear();
		textChanging3.sendKeys("fabiansuchan@aol.de");
		Thread.sleep(3000);
		WebElement textChanging4 = d
				.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/table[1]/tbody[1]/tr[1]/td[2]/input[1]"));
		textChanging4.clear();
		textChanging4.sendKeys("PeterThisisAmeil");
		textChanging4.clear();
		textChanging4.sendKeys("This is a change");
		Thread.sleep(3000);
		WebElement textChanging1 = d.findElement(By.id("address"));
		textChanging1.clear();
		textChanging1.sendKeys("Test123");
		Thread.sleep(3000);
		WebElement textChanging2 = d.findElement(By.id("telephone"));
		textChanging2.clear();
		textChanging2.sendKeys("0412312313");
		Thread.sleep(3000);
		WebElement textchangeaccept = d
				.findElement(By.xpath("/html[1]/body[1]/div[1]/form[1]/table[1]/tbody[1]/tr[5]/td[1]/input[1]"));
		textchangeaccept.click();

		}

	

	@Test
	private void newBook() throws InterruptedException {
		WebElement newElement = d.findElement(By.cssSelector("body:nth-child(2) div:nth-child(1) h3:nth-child(3) > a:nth-child(1)"));
		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Thread.sleep(3000);
		newElement.click();
		WebElement newName = d.findElement(By.id("name"));
		newName.sendKeys("Uwe");
		Thread.sleep(3000);
		WebElement newEmail = d.findElement(By.id("email"));
		newEmail.sendKeys("newMail@gmx.net");
		Thread.sleep(3000);
		WebElement newAdress = d.findElement(By.id("address"));
		newAdress.sendKeys("Wilhemweg");
		Thread.sleep(3000);
		WebElement newTelephone = d.findElement(By.id("telephone"));
		newTelephone.sendKeys("015332312");
		Thread.sleep(3000);
		WebElement newConfirm = d.findElement(By.cssSelector("table:nth-child(1) tbody:nth-child(2) tr:nth-child(5) td:nth-child(1) > input:nth-child(1)"));
		newConfirm.click();
		Thread.sleep(3000);
		
		
		
		

	}

	@AfterClass
	public void tearDown() throws InterruptedException {
		Thread.sleep(1000);
		d.close();
	}

}
