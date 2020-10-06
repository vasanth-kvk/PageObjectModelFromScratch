package com.cogmentocrm.qa.util;

import com.cogmentocrm.qa.base.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestUtil extends Base {

    public static long PAGE_LOAD_TIMEOUT = 40;
    public static long IMPLICIT_WAIT_TIMEOUT = 40;
    public static ArrayList<Object[]> data = new ArrayList<Object[]>();
    public static Excel_Reader reader;

    public TestUtil() throws IOException {
        super();
    }

    public static void explicitWaitMethodOnClick(WebDriver driver, WebElement element, int timeOut) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public static void explicitWaitMethodSendKeys(WebDriver driver, WebElement element, String value, int timeOut) {
        new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public static ArrayList<Object[]> getContactDataFromExcel()
    {
        reader = new Excel_Reader(properties.getProperty("contactdataexcelpath"));
        int rowsInSheet = reader.getRowCount("Contacts");
        System.out.println(rowsInSheet);

        for(int rowNum=2;rowNum<=rowsInSheet;rowNum++)
        {
            String fname = reader.getCellData("Contacts","firstname",rowNum);
            String lname = reader.getCellData("Contacts","lastname",rowNum);
            String company = reader.getCellData("Contacts","company",rowNum);
            String email = reader.getCellData("Contacts","email",rowNum);
            String personalEmail = reader.getCellData("Contacts","personalemail",rowNum);
            String category = reader.getCellData("Contacts","category",rowNum);
            String status = reader.getCellData("Contacts","status",rowNum);
            String description = reader.getCellData("Contacts","description",rowNum);
            String country = reader.getCellData("Contacts","country",rowNum);
            String dob = reader.getCellData("Contacts","dob",rowNum);
            List<String>  dateOfBirth = new ArrayList<>();
            dateOfBirth = dobSplit(dob);
            String date,month,year;
            date = dateOfBirth.get(0);
            month = dateOfBirth.get(1);
            year = dateOfBirth.get(2);

            System.out.println(fname+lname+" "+company+" "+email+" "+personalEmail+" "+category+" "+status+" " +
                    ""+description+" "+country+" "+date+" "+month+" "+year);


            Object ob[] ={fname,lname,company,email,personalEmail,category,status,description,country,date,month,year};
            data.add(ob);
        }
        return data;
    }

    private static List<String> dobSplit(String dob) {
        List<String> dateOfBirth = new ArrayList<>();
        dateOfBirth = Arrays.asList(dob.split("-"));
        return dateOfBirth;
    }
    }
