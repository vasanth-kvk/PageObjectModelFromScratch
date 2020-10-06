package com.cogmentocrm.qa.testcases;

import com.cogmentocrm.qa.base.Base;
import com.cogmentocrm.qa.pages.ContactsPage;
import com.cogmentocrm.qa.pages.HomePage;
import com.cogmentocrm.qa.pages.LoginPage;
import com.cogmentocrm.qa.pages.SideMenu;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.core.Appender;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTest extends Base {

    Logger log = Logger.getLogger(Appender.class.getName());
    LoginPage loginPage;
    HomePage homePage;
    SideMenu sideMenu;
    ContactsPage contactsPage;

    public HomePageTest() throws IOException {
        super();
    }
    @BeforeMethod
    public void setUp() throws IOException {
        initialize();
        log.info("Setup method for logging");
        //initializing webpage objects
        loginPage = new LoginPage();
        homePage = new HomePage();
        sideMenu = new SideMenu();
        contactsPage = new ContactsPage();
    }
    @Test
    public void validateAccountName() throws IOException {
        homePage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        Assert.assertEquals(homePage.validateAccountHolderName(),"Vasanth K");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
