package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StartProjectTest {

    @Test
    public void openGooglePage() {
        //connection thought folder tools and
        //WebDriver driver = new ChromeDriver();
        //WebDriver driver = new FirefoxDriver();

        //Connection with webDriverManager
      //
      //  WebDriverManager.firefoxdriver().setup();
      //  WebDriver driver = new FirefoxDriver(firefoxOptions);
        //----------------------------------------

        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.addPreference("intl.accept_languages","en");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver(firefoxOptions);
        //-----------------
        driver.navigate().to("https://www.google.com/");
        System.out.println("we open google");


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

     // WebElement element = driver.findElement(By.xpath("//img[@alt='Google']")); -> only first element

        List<WebElement> elements = driver.findElements(By.xpath("//img[@alt='Google']"));

    //    driver.navigate().refresh();
    //    driver.navigate().forward();
    //    driver.navigate().back();

        String url = driver.getCurrentUrl();
        System.out.println(url);

     //    all 3 asserts check the same
     //   Assert.assertTrue(elements.size() > 0);
     //   Assert.assertTrue(!elements.isEmpty());
        Assert.assertFalse(elements.isEmpty());

        driver.quit();
    }
}