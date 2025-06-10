package selenium.base;

import selenium.driver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import selenium.driver.DriverManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class CommonToAllTest {

    @BeforeMethod
    public void setUp(){
        DriverManager.init();
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.down();
    }


}
