package selenium.tests.pageObjectModelTests.vwo;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import selenium.base.CommonToAllTest;
import selenium.driver.DriverManager;
import selenium.pages.pageObjectModel.normal_POM.DashBoardPage;
import selenium.pages.pageObjectModel.normal_POM.LoginPage;
import selenium.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.annotations.Test;

import static selenium.driver.DriverManager.driver;
import static org.assertj.core.api.Assertions.*;
import org.testng.Assert;


public class TestVWOLogin_01_NormalScript_POM {
    @Description("Verify that with invalid email, pass, error message is shown on the app.vwo.com")
    @Test
    public void test_negative_vwo_login(){


        // Driver Manager Code - 1
        // Page Class Code (POM Code) - 2
        WebDriver driver = DriverManager.getDriver();

        LoginPage loginPage = new LoginPage(driver);
        String error_msg = loginPage.loginToVWOLoginInvalidCreds(PropertiesReader.readKey("invalid_username"), PropertiesReader.readKey("invalid_password"));

        // Assertions - 3
        assertThat(error_msg).isNotNull().isNotBlank().isNotEmpty();
        Assert.assertEquals(error_msg,PropertiesReader.readKey("error_message"));

    }

    @Owner("PRAMOD")
    @Description("TC#2-Verify that valid creds dashboard page is loaded")
    @Test
    public void testLoginPositiveVWO() {

        LoginPage loginPage_VWO = new LoginPage(driver);
        loginPage_VWO.loginToVWOLoginValidCreds(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        DashBoardPage dashBoardPage  = new DashBoardPage(driver);
        String usernameLoggedIn = dashBoardPage.loggedInUserName();


        assertThat(usernameLoggedIn).isNotBlank().isNotNull().isNotEmpty();
        Assert.assertEquals(usernameLoggedIn,PropertiesReader.readKey("expected_username"));


    }
}


