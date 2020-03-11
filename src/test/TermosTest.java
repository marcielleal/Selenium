package test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TermosTest {
	  private WebDriver driver;
	  private String driverPath = "./webdriver/chromedriver.exe";
	  private String baseUrl;
	  //private boolean acceptNextAlert = true;
	  private StringBuffer verificationErrors = new StringBuffer();

	  @Before
	  public void setUp() throws Exception {
	    System.out.println("Iniciando o browser Chrome");
	   	System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
	    baseUrl = "https://residencia.jfrn.jus.br/termos_jf/";
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testSiteGoogle() throws Exception {
		  driver.get(baseUrl);
		  driver.findElement(By.id("presentes-parte-autora")).sendKeys("testes ufrn");
		  driver.findElement(By.id("btn-generate")).click();
		  assertTrue(driver.findElement(By.id("presentes-parte-autora")).getText().contains("ufrn"));
	  }

	  @After
	  public void tearDown() throws Exception {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) {
	      fail(verificationErrorString);
	    }
	  }
}