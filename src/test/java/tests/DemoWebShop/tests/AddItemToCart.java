package tests.DemoWebShop.tests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.DataProviders;

public class AddItemToCart extends  TestBase{

    @BeforeClass
    public void preConditions(){
        app.getUserHelper().clickLoginOnNavBar();
        app.getUserHelper().login(userLogin);
    }

    @AfterClass
    public void postConditions() {
        app.getUserHelper().clickLogOut();
    }

    @Test
    public void positiveAddItemToCartTest () {
        app.getItemHelper().putSecondItemInCart();
        app.getItemHelper().clickShoppingCartBtn();
        // validation
        app.getItemHelper().checkIfItemAddedToCart();
    }

}