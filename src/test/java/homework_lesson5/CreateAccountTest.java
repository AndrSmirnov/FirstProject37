package homework_lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {
@Test
public void positiveLoginTest() throws InterruptedException {
    // click in login btn by //a[@href='/register']
    driver.findElement(By.xpath("//a[@href='/register']")).click();

    Thread.sleep(3000);

    // fill First name by //input[@name='FirstName']
    WebElement inputFirstName = driver.findElement(By.xpath("//input[@name='FirstName']"));
    inputFirstName.click();
    inputFirstName.clear();
    inputFirstName.sendKeys("Andrei");

    // fill Last name by //input[@name='LastName']
    WebElement inputLastName = driver.findElement(By.xpath("//input[@name='LastName']"));
    inputLastName.click();
    inputLastName.clear();
    inputLastName.sendKeys("Smirnov");

    // fill email by //input[@name='Email']
    WebElement inputEmail = driver.findElement(By.xpath("//input[@name='Email']"));
    inputEmail.click();
    inputEmail.clear();
    inputEmail.sendKeys("asmirnoff.74@mail.ru");

    // fill password by //input[@name='Password']
    WebElement inputPassword = driver.findElement(By.xpath("//input[@name='Password']"));
    inputPassword.click();
    inputPassword.clear();
    inputPassword.sendKeys("qwertY74!");

    // fill Confirm Password by //input[@name='ConfirmPassword']
    WebElement inputConfirmPassword = driver.findElement(By.xpath("//input[@name='ConfirmPassword']"));
    inputConfirmPassword.click();
    inputConfirmPassword.clear();
    inputConfirmPassword.sendKeys("qwertY74!");

    //click on Register btn by //input[@name='register-button']
    driver.findElement(By.xpath("//input[@name='register-button']")).click();


    // validation by registered customer information //a[@href='/customer/info']
    // text: asmirnoff.74@mail.ru
    Assert.assertEquals(
            driver.findElement(
                            By.xpath("//a[@href='/customer/info']"))
                    .getText().trim(),
            "asmirnoff.74@mail.ru");

}
}