package HomeworksBeforeProject.lesson4;
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

public class ByXPath {
    WebDriver driver;

    @BeforeClass
    public void init() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--lang=en");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        //implicit waiting's
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        driver.navigate().to("https://demowebshop.tricentis.com/");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testXpath(){
        //1
        WebElement byTagAndClassValue = driver.findElement(
                By.xpath("//span[@class='span.ui-helper-hidden-accessible']"));
        //2
        WebElement byTagAndIdValue = driver.findElement(
                By.xpath("//div[@id='bar-notification']"));
        //3
        WebElement byTagAndText = driver.findElement(
                By.xpath("//span[text()='Categories']"));
        //4
        WebElement byTagAndPartialText = driver.findElement(
                By.xpath("//strong[contains(text(),'News')]"));
        //5
        WebElement byTagAndIdValue2 = driver.findElement(
                By.xpath("//input[@id='pollanswers-1']"));
        //6
        WebElement byTagAndTwoAttributes = driver.findElement(
                By.xpath("//input[@id='pollanswers-3' and @name='pollanswers-1']"));
        //7
        WebElement byTagAndClassAndId = driver.findElement(
                By.xpath("//div[@class='poll' and @id='poll-block-1']"));
        //8
        WebElement byTagAndText2 = driver.findElement(
                By.xpath("//span[text()='Wishlist']"));
        //9
        WebElement byTagAndAttribute = driver.findElement(
                By.xpath("//span[@aria-live='polite']"));
        //10
        WebElement byTagAndPartialText2 = driver.findElement(
                By.xpath("//strong[contains(text(),'Popular')]"));
    }
}