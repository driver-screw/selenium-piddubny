package testPackage;

/**
 * Created by Анатолий on 03.07.2014.
 */


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverFactory;
import selenium.WebDriverWrapper;
import utils.Log4Test;
import utils.PropertyLoader;



public class TestCondition {

    public static WebDriver driver;

    @BeforeSuite
    public void Before(){
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));
        System.out.println(PropertyLoader.loadProperty("browser.name"));
        driver.manage().window().maximize();
        Log4Test.info("\nStart Suite");
    }

    @AfterSuite
        public void After(){
        if (driver!=null){
        driver.quit();
        Log4Test.info("\nEnd Suite");
     }
    }
}
