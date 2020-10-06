package com.cogmentocrm.qa.testcases;

import com.cogmentocrm.qa.base.Base;
import com.cogmentocrm.qa.pages.ContactsPage;
import com.cogmentocrm.qa.pages.HomePage;
import com.cogmentocrm.qa.pages.LoginPage;
import com.cogmentocrm.qa.pages.SideMenu;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SideMenuTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    SideMenu sideMenu;
    ContactsPage contactsPage;

    public SideMenuTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setUp() throws IOException {
        initialize();
        //initializing webpage objects
        loginPage = new LoginPage();
        homePage = new HomePage();
        sideMenu = new SideMenu();
        contactsPage = new ContactsPage();
    }
    @Test
    public void verifyContactsLink() throws IOException {
        homePage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        sideMenu.clickOnContactsLink();
        Assert.assertEquals(contactsPage.getpageLabel(),"Contacts");
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
