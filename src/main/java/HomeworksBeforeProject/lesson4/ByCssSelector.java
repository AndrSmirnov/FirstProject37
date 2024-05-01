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

public class ByCssSelector {

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
        //1
        WebElement byAttributeNameValue = driver.findElement(By.cssSelector("[title='Error']"));
        //2
        WebElement byAttrNameAndStartsWithInValue = driver.findElement(By.cssSelector("[rel^='shortcut']"));
        //3
        WebElement byAttrNameAndOverWithValue = driver.findElement(By.cssSelector("[value$='arch']"));
        //4
        WebElement byTag = driver.findElement(By.cssSelector("form"));
        //5
        WebElement byTagAndClassValue = driver.findElement(By.cssSelector("div.header-logo"));
        //6
        WebElement byTagAndIdValueAndClassValue = driver.findElement(
                By.cssSelector("input#small-searchterms.search-box-text"));
        //7
        WebElement byTagAndIdAndAttribute = driver.findElement(By.cssSelector("input#small-searchterms[name='q']"));
        //8
        WebElement byAttrNameAndPartlyValue = driver.findElement(By.cssSelector("[type*='t/javas']"));
        //9
        WebElement byTagAndClassValue2 = driver.findElement(By.cssSelector("span.ui-helper-hidden-accessible"));
        //10
        WebElement byAttributeNameValue2 = driver.findElement(By.cssSelector("[role='status']"));

    }
}