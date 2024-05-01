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

public class Homework_Lesson3_FindBy {

    @Test
    public void testLocators1() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.navigate().to("https://demowebshop.tricentis.com/");

        //By name
        WebElement elementName =
                driver.findElement(By.name("NewsletterEmail"));
        System.out.println(elementName.getAttribute("name"));

        //By tagName
        WebElement elementByTagName = driver.findElement(By.tagName("form"));
        System.out.println(elementByTagName.getAttribute("action"));

        //By class
        WebElement elementByClass = driver.findElement(By.className("footer-disclaimer"));
        System.out.println(elementByClass.getText());

        List<WebElement> listByTag = driver.findElements(By.tagName("span"));
        WebElement xElement = listByTag.get(10);
        System.out.println(xElement.getText());


        driver.quit();
    }
}