package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import org.openqa.selenium.By;

import java.io.IOException;

public class ViewContactPage extends Base {

    String contactName = properties.getProperty("newcontactfirstname")+" "+properties.getProperty("newcontactlastname");

    //PageFactory

    //Constructor
    public ViewContactPage() throws IOException {
    }

    //Method to verify contact name
    public String verifyContactName(String contactNameFromExcel)
    {
    return driver.findElement(By.xpath("//div[text()='"+contactNameFromExcel+"']")).getText();
    }

    }
