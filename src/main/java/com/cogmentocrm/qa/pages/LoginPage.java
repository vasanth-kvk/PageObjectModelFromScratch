package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class LoginPage extends Base{

    //Page Factory
    @FindBy(xpath = "//input[@name='email']")
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(css = "div.submit.button")
    WebElement loginBtn;

    //constructor of Loginpage class
    public LoginPage() throws IOException {
        //initializing page objects using driver
        PageFactory.initElements(driver,this);
    }

    //To verify Login page title
    public String getLoginPageTitle()
    {
        return driver.getTitle();
    }
    // To verify login function
    public HomePage login(String login_uname, String login_pswd) throws IOException {
    username.sendKeys(login_uname);
    password.sendKeys(login_pswd);
    loginBtn.click();
    //returning HomePage object
    return new HomePage();
    }

}
