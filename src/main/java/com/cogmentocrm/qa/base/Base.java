package com.cogmentocrm.qa.base;

import com.cogmentocrm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {
    //declaring global variables
    public static WebDriver driver;
    public static Properties properties;
    public static FileInputStream file;

    public Base() throws IOException {
        //load config.properties file
        properties = new Properties();
        file = new FileInputStream("C:\\Users\\Windows\\Documents\\CogmentoCRMTestAutomation\\src\\main\\java\\com\\cogmentocrm\\qa\\config\\config.properties");
        properties.load(file);
        System.out.println(properties.getProperty("url"));
    }

    //method to initialize driver and timeouts
    public void initialize()
    {
        String browserName = properties.getProperty("browser");
        if (browserName.equals("chrome"))
        {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\Windows\\Documents\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT_TIMEOUT,TimeUnit.SECONDS);
        driver.get(properties.getProperty("url"));

    }

}
