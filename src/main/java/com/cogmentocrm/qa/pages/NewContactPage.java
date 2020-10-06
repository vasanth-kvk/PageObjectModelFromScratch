package com.cogmentocrm.qa.pages;

import com.cogmentocrm.qa.base.Base;
import com.cogmentocrm.qa.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class NewContactPage extends Base {

    String companySearchText = "kvk";
    String companySelect = "KVK company";
    String categorySelect = "Affiliate";
    String selectContactBeforeXpath = "//div[@class='visible menu transition']//span[contains(text(),'";
    String selectContactAfterXpath = "')]";
    String additionalEmailAddressXpath = "//div[@class='three fields']/following-sibling::" +
            "div//input[@placeholder='Email address']";
    String selectUsingTextBeforeXpath = "//span[text()='";
    String selectUsingTextAfterXpath = "']";
    String timeZone = "America/Indiana/Winamac";
    String country = "Algeria";
    String bday = "22";
    String bdayMonth = "January";
    String yearBorn = "1996";


    //PageFactory
    @FindBy(xpath = "//div[text()='Create New Contact']")
    private WebElement newContactpage;
    @FindBy(xpath = "//input[@name='first_name']")
    private WebElement first_name;
    @FindBy(xpath = "//input[@name='last_name']")
    private WebElement last_name;
    @FindBy(xpath = "//input[@name='middle_name']")
    private WebElement middle_name;
    @FindBy(xpath = "//label[text()='Company']//parent::div//input[@class='search']")
    private WebElement company_name;
    @FindBy(css = "button.ui.small.fluid.positive.toggle.button")
    private WebElement accessButton;
    @FindBy(xpath = "//label[@for='tags']/div/input[@class='search']")
    private WebElement tagSearch;
    @FindBy(xpath = "//input[@placeholder='Email address']")
    private WebElement emailAddress;
    @FindBy(xpath = "//input[@placeholder='Personal email, Business, Alt...']")
    private WebElement personalMailAddress;
    @FindBy(xpath = "//label[text()='Email']//parent::div//button[@class='ui icon button']")
    private WebElement addEmailAddressButton;
    @FindBy(xpath = "//div[@name='category']")
    private WebElement categoryDropdown;
    @FindBy(xpath = "//div[@name='status']")
    private WebElement statusDropdown;
    @FindBy(xpath = "//span[text()='New']")
    private WebElement statusNew;
    @FindBy(xpath = "//span[text()='Active']")
    private WebElement statusActive;
    @FindBy(xpath = "//span[text()='Inactive']")
    private WebElement statusInactive;
    @FindBy(xpath = "//span[text()='On Hold']")
    private WebElement statusOnHold;
    @FindBy(xpath = "//span[text()='Terminated']")
    private WebElement statusTerminated;
    @FindBy(xpath = "//span[text()='Hot']")
    private WebElement statusHot;
    @FindBy(xpath = "//textarea[@name='description']")
    private WebElement description;
    @FindBy(xpath = "//div[@name='channel_type']")
    private WebElement socialChannel;
    @FindBy(xpath = "//span[text()='Twitter']")
    private WebElement socialTwitter;
    @FindBy(xpath = "//label[text()='Social Channels']//parent::div//span[text()='Facebook']")
    private WebElement socialFacebook;
    @FindBy(xpath = "//span[text()='LinkedIn']")
    private WebElement socialLinkedIn;
    @FindBy(xpath = "//span[text()='TikTok']")
    private WebElement socialTikTok;
    @FindBy(xpath = "//span[text()='Instagram']")
    private WebElement socialInstagram;
    @FindBy(xpath = "//label[text()='Time Zone']//parent::div//input[@class='search']")
    private WebElement timeZoneDropdown;
    @FindBy(xpath = "//div[@name='country']")
    private WebElement countryDropdown;
    @FindBy(xpath = "//input[@name='do_not_call']")
    private WebElement donotcallButton;
    @FindBy(xpath = "//input[@name='day']")
    private WebElement day;
    @FindBy(xpath = "//div[@name='month']")
    private WebElement month;
    @FindBy(xpath = "//input[@name='year']")
    private WebElement year;
    @FindBy(xpath = "//input[@name='fileField']")
    private WebElement image;
    @FindBy(xpath = "//button[@class='ui linkedin button' and text()='Save']")
    private WebElement saveContactButton;

    //Constructor
    public NewContactPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    //Method to create new contact from config.properties file
    public ViewContactPage createNewContactFromConfig() throws IOException, InterruptedException {

        Thread.sleep(2000);
        TestUtil.explicitWaitMethodSendKeys(driver, first_name, properties.getProperty("newcontactfirstname"), 10);
        TestUtil.explicitWaitMethodSendKeys(driver, last_name, properties.getProperty("newcontactlastname"), 10);
        company_name.sendKeys(companySearchText);
        verifyIsElementIsPresentAndClick(selectContactBeforeXpath, selectContactAfterXpath, companySelect);
        emailAddress.sendKeys(properties.getProperty("contactemail"));
        personalMailAddress.sendKeys(properties.getProperty("personalcontactemail"));
        addEmailAddressButton.click();
        verifyIsElementIsPresentAndSendKeys(additionalEmailAddressXpath, properties.getProperty("additionalcontactemail"));
        categoryDropdown.click();
        verifyIsElementIsPresentAndClick(selectUsingTextBeforeXpath, selectUsingTextAfterXpath, categorySelect);
        statusDropdown.click();
        statusNew.click();
        description.sendKeys("text");
        socialChannel.click();
        socialFacebook.click();
        timeZoneDropdown.click();
        verifyIsElementIsPresentAndClick(selectUsingTextBeforeXpath, selectUsingTextAfterXpath, timeZone);
        countryDropdown.click();
        verifyIsElementIsPresentAndClick(selectUsingTextBeforeXpath, selectUsingTextAfterXpath, country);
        day.sendKeys(bday);
        month.click();
        verifyIsElementIsPresentAndClick(selectUsingTextBeforeXpath, selectUsingTextAfterXpath, bdayMonth);
        year.sendKeys(yearBorn);
        image.sendKeys("C:\\Users\\Windows\\Pictures\\images.jfif");
        saveContactButton.click();

        return new ViewContactPage();
    }

    public void verifyIsElementIsPresentAndClick(String BeforeXpath, String AfterXpath, String textToBeSelected) {
        WebElement iselementPresent;
        try {
            iselementPresent = driver.findElement(By.xpath(BeforeXpath + textToBeSelected + AfterXpath));
            if(iselementPresent.isDisplayed()) {
                iselementPresent.click();
            }
            else {
            driver.findElement(By.xpath("//div[@data-additional='true']//b[text()='"+textToBeSelected+"']")).click();
            }
        } catch (NoSuchElementException e) {
            System.out.println( textToBeSelected +" not found in page");
        }
    }

    public void verifyIsElementIsPresentAndSendKeys(String additionalEmailXpath, String additionalEmailAddress) {
        WebElement iselementPresent;
        try {
            iselementPresent = driver.findElement(By.xpath(additionalEmailXpath));
            iselementPresent.sendKeys(additionalEmailAddress);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found in page");
        }
    }

    //To create a new contact from excel file
    public ViewContactPage createNewContactFromExcel(String fname,String lname,String company,String email,String personalEmail,
                                            String category,String status,String descriptionValue,String country,
                                            String contactDObDate,String contactDobMonth,String contactDobyear) throws IOException, InterruptedException {

        Thread.sleep(2000);
        TestUtil.explicitWaitMethodSendKeys(driver, first_name,fname,10);
        TestUtil.explicitWaitMethodSendKeys(driver, last_name,lname,10);
        company_name.sendKeys(company);
        verifyIsElementIsPresentAndClick(selectContactBeforeXpath, selectContactAfterXpath, company);
        emailAddress.sendKeys(email);
        personalMailAddress.sendKeys(personalEmail);
        addEmailAddressButton.click();
        verifyIsElementIsPresentAndSendKeys(additionalEmailAddressXpath, personalEmail);
        categoryDropdown.click();
        verifyIsElementIsPresentAndClick(selectUsingTextBeforeXpath, selectUsingTextAfterXpath, category);
        statusDropdown.click();
        clickStatus(status);
        description.sendKeys(descriptionValue);
        countryDropdown.click();
        verifyIsElementIsPresentAndClick(selectUsingTextBeforeXpath, selectUsingTextAfterXpath, country);
        day.sendKeys(contactDObDate);
        month.click();
        verifyIsElementIsPresentAndClick(selectUsingTextBeforeXpath, selectUsingTextAfterXpath, contactDobMonth);
        year.sendKeys(contactDobyear);
        //image.sendKeys("C:\\Users\\Windows\\Pictures\\images.jfif");
        saveContactButton.click();
        return new ViewContactPage();
    }

    // Method to select status in new contact page
    public void clickStatus(String status)
    {
        switch (status)
        {
            case "New":
                statusNew.click();
                break;
            case "Active":
                statusActive.click();
                break;
            case "Inactive":
                statusInactive.click();
                break;
            case "On Hold":
                statusOnHold.click();
                break;
            case "Terminated":
                statusTerminated.click();
                break;
            case "Hot":
                statusHot.click();
                break;
            default:
                System.out.println("Status not found");
        }
    }
}
