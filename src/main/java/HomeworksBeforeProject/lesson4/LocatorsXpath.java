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

public class LocatorsXpath {

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
        /*
        /html/body//div[@class='column information']
        //div[@class='column information']
        //tagName[@attributeName='attributeValue']
        */

        WebElement topCarLink = driver.findElement(By.xpath("//li[@id='topcartlink']"));

        //any teg
        WebElement scriptElement = driver.findElement(By.xpath("//script[@type='text/javascript']"));

        //by text
        WebElement byText = driver.findElement(By.xpath("//strong[text()='Community poll']"));
        //так же можно найти по частичному тексту то же самое таким образом - //strong[contains(text(),' poll')]
        //by partialText
        WebElement byPartialText =
                driver.findElement(By.xpath("//h2[contains(text(),' Welcome to our ')]"));

        //with 2 attributes
        WebElement twoAttributesSearch =
                driver.findElement(By.xpath("//div[@id='flyout-cart' and @class='flyout-cart']"));
        WebElement twoAttributesSearchOf =
                driver.findElement(By.xpath("//div[@id='flyout-cart' or @class='flyout-cart']"));


    }
}