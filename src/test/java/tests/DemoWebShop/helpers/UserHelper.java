package tests.DemoWebShop.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import tests.DemoWebShop.config.ApplicationManager;
import tests.DemoWebShop.dto.UserDTO;

public class UserHelper extends HelperBase{

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void fillConfirmPasswordOnRegister(String password) {
        typeText(password, By.xpath("//input[@name='ConfirmPassword']"));
    }

    public void fillPasswordOnRegister(String password) {
        typeText(password, By.xpath("//input[@name='Password']"));
    }

    public void fillEmailOnRegister(String email) {
        typeText(email, By.xpath("//input[@name='Email']"));
    }

    public void fillLastNameOnRegister(String lastName) {
        typeText(lastName, By.xpath("//input[@name='LastName']"));
    }

    public void fillFirstNameOnRegister(String firstName) {
        typeText(firstName, By.xpath("//input[@name='FirstName']"));
    }
    public void fillPasswordOnLogin(String password) {
        typeText(password, By.xpath("//input[@id='Password']"));
    }
    public void fillEmailOnLogin(String email) {
        typeText(email, By.xpath("//input[@id='Email']"));
    }
    public void clickLoginBtn() {
        ApplicationManager.getDriver().
                findElement(By.xpath("//input[@type='submit' and @value='Log in']")).click();
    }
    public void clickLoginOnNavBar() {
        ApplicationManager.getDriver().
                findElement(By.xpath("//a[@href='/login']")).click();
    }
    public void clickLogOut() {

        ApplicationManager.getDriver().
                findElement(By.xpath("//a[@href='/logout']")).click();
    }
    public void clickOnRegisterBtn() {
        ApplicationManager.getDriver().
                findElement(By.xpath("//input[@name='register-button']")).click();
    }
    public void clickRegisterOnNavBar() {
        ApplicationManager.getDriver().
                findElement(By.xpath("//a[@href='/register']")).click();
    }
    public void login(UserDTO userDTO) {
        fillEmailOnLogin(userDTO.getEmail());
        fillPasswordOnLogin(userDTO.getPassword());
        clickLoginBtn();
    }
    public void register(UserDTO userDTO) {
        clickRegisterOnNavBar();
        pause(5000);
        fillFirstNameOnRegister(userDTO.getFirstName());
        fillLastNameOnRegister(userDTO.getLastName());
        fillEmailOnRegister(userDTO.getEmail());
        fillPasswordOnRegister(userDTO.getPassword());
        fillConfirmPasswordOnRegister(userDTO.getPassword());
        clickOnRegisterBtn();
    }

    public void checkIfNewUserWasRegistered(UserDTO userDTO) {
        Assert.assertEquals(
                ApplicationManager.getDriver().findElement(
                                By.xpath("//a[@href='/customer/info']"))
                        .getText().trim(),
                userDTO.getEmail().trim());
    }
}