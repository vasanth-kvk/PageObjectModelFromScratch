package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class HomePage extends Base {
    //PageFactory
    @FindBy(xpath = "//span[contains(text(),'Vasanth K')]")
    private WebElement accountHolderName;

    //constructor of Homepage class
    public HomePage() throws IOException {
        PageFactory.initElements(driver,this);
    }

    public String validateAccountHolderName() {
        String accHolderName=accountHolderName.getText();
        return accHolderName;
    }
}
