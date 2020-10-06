package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
public class SideMenu extends Base {

    @FindBy(xpath = "//a[@href='/contacts']")
    private WebElement Contacts;
    @FindBy(xpath ="//a[@href='/calendar']" )
    private WebElement Calendar;
    @FindBy(xpath = "//a[@href='/cases']")
    private WebElement cases;

    public SideMenu() throws IOException {
        PageFactory.initElements(driver,this);
    }
    public ContactsPage clickOnContactsLink() throws IOException {
        Contacts.click();
        return new ContactsPage();
    }

    public CalendarPage clickOnCalendarLink() throws IOException {
        Calendar.click();
        return new CalendarPage();
    }

    public CasesPage clickOnCasesLink() throws IOException {
        cases.click();
        return new CasesPage();
    }
}
