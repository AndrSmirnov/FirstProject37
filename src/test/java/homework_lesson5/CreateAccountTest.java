package homework_lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

@Test
public void positiveLoginTest() {

    //  click on Register btn by: //a[@class='ico-register']
    driver.findElement(By.xpath("//a[@class='ico-register']")).click();

    // fill first name by: //input[@id='FirstName']
    WebElement inputFirstName =
            driver.findElement(By.xpath("//input[@id='FirstName']"));
    inputFirstName.click();
    inputFirstName.clear();
    inputFirstName.sendKeys("Andrei");

    // fill last name by: //input[@id='LastName']
    WebElement inputLastName =
            driver.findElement(By.xpath("//input[@id='LastName']"));
    inputLastName.click();
    inputLastName.clear();
    inputLastName.sendKeys("Smirnov");

    // fill email by: //input[@id='Email']
    WebElement inputEmail =
            driver.findElement(By.xpath("//input[@id='Email']"));
    inputEmail.click();
    inputEmail.clear();
    inputEmail.sendKeys("asmirnoff.74@mail.ru");

    // fill password by: //input[@id='Password']
    WebElement inputPassword =
            driver.findElement(By.xpath("//input[@id='Password']"));
    inputPassword.click();
    inputPassword.clear();
    inputPassword.sendKeys("qwertY74!");

    // confirm password: //input[@id='ConfirmPassword']
    WebElement inputConfirmPassword =
            driver.findElement(By.xpath("//input[@id='ConfirmPassword']"));
    inputConfirmPassword.click();
    inputConfirmPassword.clear();
    inputConfirmPassword.sendKeys("qwertY74!");

    // click register btn: //input[@id='register-button']
    driver.findElement(By.xpath("//input[@id='register-button']"))
            .click();

    WebElement registerElement =
            driver.findElement(By.xpath("//h1"));
    String actualResult = registerElement.getText().trim();
    Assert.assertEquals(actualResult, "Register");
}

}