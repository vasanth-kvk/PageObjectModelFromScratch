package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import com.cogmentocrm.qa.util.TestUtil;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.io.IOException;

public class CasesPage extends Base {

    @FindBy(xpath = "//button[text()='New']")
    private WebElement newButton;

    public CasesPage() throws IOException {
    }

    public NewCasesPage clickOnNewButton() throws IOException {
        TestUtil.explicitWaitMethodOnClick(driver,newButton,10);
        return new NewCasesPage();
    }
}
