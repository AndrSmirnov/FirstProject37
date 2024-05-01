package levelone;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AddItemToCart extends TestBase {

    @BeforeClass
    public void preconditions(){
        // click in login  btn by //a[@href='/login']
        driver.findElement(By.xpath("//a[@href='/login']")).click();

        // fill email by //input[@id='Email']
        WebElement inputEmail = driver.findElement(By.xpath("//input[@id='Email']"));
        inputEmail.click();
        inputEmail.clear();
        inputEmail.sendKeys("asmirnoff.74@mail.ru");

        // fill password by //input[@id='Password']
        WebElement inputPassword = driver.findElement(By.xpath("//input[@id='Password']"));
        inputPassword.click();
        inputPassword.clear();
        inputPassword.sendKeys("qwertY74!");

        // click login btn by //input[@type='submit' and @value='Log in']
        driver.findElement(By.xpath("//input[@type='submit' and @value='Log in']")).click();

    }

    @AfterMethod
    public void methodPostCondition() {
        // разлогиниться
        driver.findElement(
                By.xpath("//a[@href='/logout']")).click();
    }

    @Test
    public void positiveAddItemToCartTest () {
        //click on add cart btn for the 2nd item
        driver.findElement(By.xpath("//input[contains(@onclick, 'catalog/31/1/1')]")).click();
        //click on Shopping cart link
        driver.findElement(By.xpath("//span[text()='Shopping cart']")).click();

        // validation by item information added in a cart //a[@href='/customer/info']

        Assert.assertEquals(
                driver.findElement(
                                By.xpath("//a[@class='product-name']"))
                        .getText().trim(),
                "14.1-inch Laptop");


    }
}