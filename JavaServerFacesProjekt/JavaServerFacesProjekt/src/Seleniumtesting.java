
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Seleniumtesting {

	WebDriver d = new ChromeDriver();
	WebDriverWait wait = new WebDriverWait(d, 20);
	private String baseUrl;
	JavascriptExecutor js = ((JavascriptExecutor) d);

	@BeforeClass
	public void setUp() throws InterruptedException {
		// System Set Property kann hier stehen falls es initaliziert werden sollte
		d = new ChromeDriver();
		baseUrl = "http://localhost:8090/JavaServerFacesProjekt";
		d.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		d.manage().window().maximize();
		Thread.sleep(5000);
		d.get(baseUrl);

	}

	@BeforeMethod
	private void textChangeName() throws InterruptedException {
		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		WebElement clickElement = d.findElement(By.xpath("//tbody/tr[1]/td[7]/input[1]"));
		clickElement.click();
		Thread.sleep(3000);

		WebElement textChanging1 = d.findElement(By.id("form:id"));
		textChanging1.clear();
		textChanging1.sendKeys("fabiansuchan@aol.de");
		Thread.sleep(3000);
		WebElement textChanging2 = d.findElement(By.id("form:email"));
		textChanging2.clear();
		textChanging2.sendKeys("fabiansuchan@aol.de");
		Thread.sleep(3000);
		WebElement textChanging3 = d.findElement(By.id("form:password"));
		textChanging3.clear();
		textChanging3.sendKeys("secret EscapeRoom");
		Thread.sleep(3000);
		WebElement update = d.findElement(By.id("form:updateBtn"));
		Thread.sleep(3000);
		update.click();
		Thread.sleep(3000);
	}

	@Test
	private void newItem() throws InterruptedException {
		WebElement newObj = d.findElement(By.xpath("/html[1]/body[1]/form[1]/center[1]/input[1]"));
		d.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		newObj.click();
		Thread.sleep(3000);
		WebElement newName = d.findElement(By.id("createStudentForm:name"));
		newName.sendKeys("Hans");
		Thread.sleep(3000);
		WebElement newEmail = d.findElement(By.id("createStudentForm:email-id"));
		newEmail.sendKeys("Hans");
		Thread.sleep(3000);
		WebElement newPassword = d.findElement(By.id("createStudentForm:password-id"));
		newPassword.sendKeys("Hans");
		Thread.sleep(3000);
		WebElement newConfirm = d.findElement(By.cssSelector(
				"form.form-horizontal div.form-group:nth-child(9) div.col-sm-4:nth-child(2) div.col-sm-2:nth-child(1) > input.btn.btn-success.btnWidth"));
		newConfirm.click();
		Thread.sleep(3000);

	}

	@AfterClass
	private void afterTest1() throws InterruptedException {
		Thread.sleep(8000);
		d.close();
	}

}