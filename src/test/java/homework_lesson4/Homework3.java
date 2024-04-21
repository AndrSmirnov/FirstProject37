package homework_lesson4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework3 {
    WebDriver driver;

    @BeforeClass
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        driver.navigate().to("https://demowebshop.tricentis.com/");
    }
    @AfterClass
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void testCss() {
        WebElement byId =
                driver.findElement(By.cssSelector("#poll-voting-progress-1"));

        WebElement byClass =
                driver.findElement(By.cssSelector(".footer"));

        WebElement byAttrNameAndValue =
                driver.findElement(By.cssSelector("[action='/search']"));

        WebElement byAttrName =
                driver.findElement(By.cssSelector("[action]"));

        WebElement byAttrNameAndPartlyValue =
                driver.findElement(By.cssSelector("[action*='earc']"));

        WebElement byAttrNameAndStartsWithInValue =
                driver.findElement(By.cssSelector("[action^='/sear']"));

        WebElement byAttrNameAndOverWithValue =
                driver.findElement(By.cssSelector("[action$='rch']"));

        WebElement byTagAndClassValue =
                driver.findElement(By.cssSelector("div.master-wrapper-content"));
        WebElement byTagIdValueAndClassValue =
                driver.findElement(By.cssSelector("div#bar-notification.bar-notification"));

          //BY xpath
        WebElement twoAttrSearc =
                driver.findElement(By.xpath("//div[@id='newsletter-subscribe-block' and @class='newsletter-subscribe-block']"));

        WebElement byPartialText =
                driver.findElement(By.xpath("//div[contains(text(),'items in your')]"));

        WebElement byTagAndAttr =
                driver.findElement(By.xpath("//div[@class='count']"));

        WebElement byTextContains =
                driver.findElement(By.xpath("//div[contains(text(),'You have no')]"));

        WebElement byTextStartsWith =
                driver.findElement(By.xpath("//a[starts-with(.,'Digital')]"));

        WebElement byTagAndAttr8 = driver.findElement
                (By.xpath("//div[@class='master-wrapper-page']"));

        WebElement byText = driver.findElement
                (By.xpath("//p[text()='Welcome to the new Tricentis store!']"));

    }

    }