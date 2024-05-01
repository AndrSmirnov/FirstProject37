package tests.DemoWebShop.tests;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import tests.DemoWebShop.config.ApplicationManager;
import tests.DemoWebShop.dto.UserDTO;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    static ApplicationManager app = new ApplicationManager(System
            .getProperty("browser", Browser.CHROME.browserName()));

    static Logger logger = LoggerFactory.getLogger(TestBase.class);

    UserDTO userLogin = new UserDTO()
            .setEmail("asmirnoff.74@mail.ru")
            .setPassword("qwertY74!");

    @BeforeSuite
    public void startBrowser() {
        logger.info("run browser settings");
        app.init();
    }

    @AfterSuite
    public void tearDown() {
        logger.info("quit browser");
        app.quit();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] o) {
        logger.info("Start test:" + method.getName() + "with data" + Arrays.asList(o));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if(result.isSuccess()) {
            logger.info("PASSED " + result.getMethod().getMethodName());
        } else {
            logger.error("FAILED "
                    + result.getMethod().getMethodName()
                    + "Screenshot: " + app.getUserHelper().takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("------------------------------------");
    }
}