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

public class LocatorsCSS {

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
    public void testCSS() {
        //by id
        WebElement byId = driver.findElement(By.cssSelector("#topcartlink"));
        //by class
        WebElement byClass = driver.findElement(By.cssSelector(".header-logo"));

        //Attribute in DOM:: attributeName = "attributeValue"
        // [attributeName='attributeValue']
        //by name - в разных вариациях
        WebElement attributeNameValue = driver.findElement(By.cssSelector("[type='text/javascript']"));

        WebElement byAttrName = driver.findElement(By.cssSelector("[type]"));

        WebElement byAttrNameAndPartlyValue = driver.findElement(By.cssSelector("[type*='t/javas']"));

        WebElement byAttrNameAndStartsWithInValue = driver.findElement(By.cssSelector("[type^='text/ja']"));

        WebElement byAttrNameAndOverWithValue = driver.findElement(By.cssSelector("[type$='cript']"));

        //by tag
        WebElement byTag = driver.findElement(By.cssSelector("span"));

        //by tag and class
        //<tagName class="classValue">Text<tagName>
        //tagName.classValue
        WebElement byTagAndClassValue = driver.findElement(By.cssSelector("div.header"));
        //tagName#idValue.classValue
        WebElement byTagAndIdValueAndClassValue = driver.findElement(By.cssSelector("div#flyout-cart.flyout-cart"));
        //tagName.idValue[attributeName='attributeValue']
        WebElement byTagAndIdAndAttribute = driver.findElement(By.cssSelector("input#small-searchterms[type='text']"));


    }
}