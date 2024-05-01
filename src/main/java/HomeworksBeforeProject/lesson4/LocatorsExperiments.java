package HomeworksBeforeProject.lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class LocatorsExperiments {

    @Test
    public void testLocators1(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        //implicit waiting's
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.navigate().to("https://ilcarro.web.app/search");

        //By id
        WebElement elementCityID = driver.findElement(By.id("city"));
        System.out.println(elementCityID.getAttribute("type"));

        //By class
        WebElement elementPhoneClass = driver.findElement(By.className("telephone"));
        System.out.println(elementPhoneClass.getText());

        //By name
        WebElement elementName =
                driver.findElement(By.name("value-of-the-attribute-of-the-name->name"));

        //By linkText -> full text

        WebElement elementPhoneText = driver.findElement(By.linkText("866-720-5721"));
        System.out.println(elementPhoneText.getAttribute("class"));

        //By tagName
        List<WebElement> listDiv = driver.findElements(By.tagName("div"));
        WebElement firstDiv = listDiv.get(0);
        System.out.println(firstDiv.getAttribute("class"));
        System.out.println(driver.findElements(By.tagName("div")).get(0).getAttribute("class"));

        //By partialLinkText -> part of text
        WebElement elementPhonePartialText = driver.findElement(By.partialLinkText("720-5721"));
        System.out.println(elementPhonePartialText.getAttribute("class"));

        driver.quit();


    }
}