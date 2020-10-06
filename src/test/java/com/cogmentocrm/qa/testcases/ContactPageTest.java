package com.cogmentocrm.qa.testcases;

import com.cogmentocrm.qa.base.Base;
import com.cogmentocrm.qa.dataproviders.NewContactDataProvider;
import com.cogmentocrm.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.IOException;

public class ContactPageTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    SideMenu sideMenu;
    ContactsPage contactsPage;
    NewContactPage newContactpage;
    ViewContactPage viewContactPage;
    public ContactPageTest() throws IOException {
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
        newContactpage = new NewContactPage();
    }

    @Test(priority = 1)
    public void verifyCreateNewContact() throws IOException, InterruptedException {
        homePage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        contactsPage = sideMenu.clickOnContactsLink();
        newContactpage = contactsPage.clickNewbutton();
        viewContactPage = newContactpage.createNewContactFromConfig();
        Assert.assertEquals(viewContactPage.verifyContactName(properties.getProperty("newcontactfirstname")+" "+properties.getProperty("newcontactlastname")),"Jos Buttler");
    }
    @Test(priority = 2)
    public void verifyContactIsPresentInContactsPage() throws IOException {
        homePage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        contactsPage = sideMenu.clickOnContactsLink();
        viewContactPage = contactsPage.viewCreatedContact();
        Assert.assertEquals(viewContactPage.verifyContactName(properties.getProperty("newcontactfirstname")+" "+properties.getProperty("newcontactlastname")),"Jos Buttler");
    }

    @Test(dataProvider = "contactData", dataProviderClass = NewContactDataProvider.class, priority = 3)
    public void verifyContact(String fname,String lname,String company,String email
                                ,String personalEmail,String category,
                                String status,String description,String country,
                                String date,String month,String year)throws IOException, InterruptedException
    {
        homePage = loginPage.login(properties.getProperty("username"),properties.getProperty("password"));
        contactsPage = sideMenu.clickOnContactsLink();
        newContactpage = contactsPage.clickNewbutton();
        viewContactPage = newContactpage.createNewContactFromExcel(fname,lname,company,email,personalEmail,
                category,status,description,country,date,month,year);
        Assert.assertEquals(viewContactPage.verifyContactName(fname+" "+lname),fname+" "+lname);
        sideMenu.clickOnContactsLink();
        viewContactPage = contactsPage.viewCreatedContactFromExcel(fname+" "+lname);
        Assert.assertEquals(viewContactPage.verifyContactName(fname+" "+lname),fname+" "+lname);
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
