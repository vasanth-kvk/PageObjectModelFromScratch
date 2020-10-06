package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import com.cogmentocrm.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.io.IOException;

public class ContactsPage extends Base {

    String viewContactBtnBeforeXpath = "//td[contains(text(),'";
    String viewContactBtnAfterXpath = "')]//parent::tr//i[@class='unhide icon']//parent::button";
    String contactName = properties.getProperty("newcontactfirstname")+" "+properties.getProperty("newcontactlastname");


    //PageFactory
    @FindBy(xpath = "//div[@id='dashboard-toolbar']//div[contains(.,'Contacts')]")
    private WebElement contactPageLabel;
    @FindBy(xpath = "//button[text()='New']")
    private WebElement newButton;

    //Constructor
    public ContactsPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    //Method to verify contactpage
    public String getpageLabel() {
        return contactPageLabel.getText();
    }

    //Method to click New button in contact page
    public NewContactPage clickNewbutton() throws IOException, InterruptedException {
        Thread.sleep(3000);
        TestUtil.explicitWaitMethodOnClick(driver, newButton, 10);
        return new NewContactPage();
    }

    // To view a particular contact
    public ViewContactPage viewCreatedContact() throws IOException {
        ViewContact(viewContactBtnBeforeXpath,viewContactBtnAfterXpath,contactName);
        return new ViewContactPage();
    }

    //Method to view contact created from excel file
    public ViewContactPage viewCreatedContactFromExcel(String contactNameFromExcel) throws IOException {
        ViewContact(viewContactBtnBeforeXpath,viewContactBtnAfterXpath,contactNameFromExcel);
        return new ViewContactPage();
    }

    //Method to click view contact button in contact page
    public void ViewContact(String viewContactBtnBeforeXpath, String viewContactBtnAfterXpath, String contactName)
    {
        WebElement iselementPresent;
        try {
            iselementPresent = driver.findElement(By.xpath(viewContactBtnBeforeXpath +contactName+ viewContactBtnAfterXpath));
            TestUtil.explicitWaitMethodOnClick(driver,iselementPresent,10);
        } catch (NoSuchElementException e) {
            System.out.println("Contact not found in page");
        }
    }


}
