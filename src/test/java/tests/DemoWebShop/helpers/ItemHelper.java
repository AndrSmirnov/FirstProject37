package tests.DemoWebShop.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.DemoWebShop.config.ApplicationManager;

public class ItemHelper extends HelperBase{


    public ItemHelper(WebDriver driver) {
        super(driver);
    }

    public void putSecondItemInCart() {
        ApplicationManager.getDriver().
                findElements(By.xpath("//input[@value='Add to cart']")).get(1).click();
    }

    public void clickShoppingCartBtn() {
        ApplicationManager.getDriver().
                findElement(By.xpath("//div[@class='footer']//a[@class='ico-cart']")).click();
    }

    public void checkIfItemAddedToCart() {
        Assert.assertEquals(
                ApplicationManager.getDriver().findElement(
                                By.xpath("//a[@class='product-name']"))
                        .getText().trim(),
                "14.1-inch Laptop");
    }
}