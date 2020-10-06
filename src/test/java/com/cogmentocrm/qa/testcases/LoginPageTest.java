package com.cogmentocrm.qa.testcases;

import com.cogmentocrm.qa.base.Base;
import com.cogmentocrm.qa.pages.HomePage;
import com.cogmentocrm.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginPageTest extends Base {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialize();
        //initializing webpage object
        loginPage = new LoginPage();
    }

    @Test
    public void verifyLoginPageTitle()
    {
        String loginPageTitle = loginPage.getLoginPageTitle();
        Assert.assertEquals(loginPageTitle,"Cogmento CRM");
    }
    @Test
    public void verifyLogin() throws IOException {
        homePage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
