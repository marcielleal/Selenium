package test;

import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleTest {
  private WebDriver driver;
  private String driverPath = "./webdriver/chromedriver.exe";
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
   System.out.println("Iniciando o browser Chrome");
   System.setProperty("webdriver.chrome.driver", driverPath);
   driver = new ChromeDriver();
   baseUrl = "https://www.google.com.br/";
   //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }

  @Test
  public void testSiteGoogle() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.name("q")).clear();
    driver.findElement(By.name("q")).sendKeys("testando");
    assertTrue(driver.getTitle().toString().contains("Google"));
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