package tests.DemoWebShop.tests;

import org.testng.annotations.Test;
import tests.DemoWebShop.dto.UserDTO;
import utils.DataProviders;
import java.util.Random;

public class CreateAccountTest extends TestBase {

    @Test(dataProvider = "addNewContactCSVFile", dataProviderClass = DataProviders.class)

    public void positiveRegistrationTest(UserDTO userDTO) {
        app.getUserHelper().register(userDTO);
        app.getUserHelper().checkIfNewUserWasRegistered(userDTO);
        app.getUserHelper().clickLogOut();

        Random random = new Random();
        String email = "bill" + String.valueOf(random.nextInt(10)) + "@mail.ru";
        UserDTO userRegister = new UserDTO()
                .setFirstName("Bill")
                .setLastName("Clinton")
                .setEmail(email)
                .setPassword("12345BC$");
    }
}