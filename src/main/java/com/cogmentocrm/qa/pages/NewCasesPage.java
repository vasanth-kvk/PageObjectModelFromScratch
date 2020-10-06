package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;

public class NewCasesPage extends Base {


    //PageFactory
    @FindBy(xpath = "//input[@name='title']")
    private WebElement newCaseTitle;
    @FindBy(xpath = "//label[contains(text(),'Assigned To')]//parent::div//following-sibling::div//span[contains(text(),'Vasanth K')]")
    private WebElement assignedTo;
    public NewCasesPage() throws IOException {
    }


}
