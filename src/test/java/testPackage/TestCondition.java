package testPackage;

/**
 * Created by Анатолий on 03.07.2014.
 */


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import selenium.WebDriverFactory;
import utils.PropertyLoader;



public class TestCondition {

    public static WebDriver driver;

    @BeforeSuite
    public void Before(){
        //PropertyLoader.loadProperty("browser.name")
        driver = WebDriverFactory.initDriver(PropertyLoader.loadProperty("browser.name"));

        System.out.println(PropertyLoader.loadProperty("browser.name"));
        //driver.get(url);
        driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }

    @AfterSuite
        public void After(){
        if (driver!=null){
        driver.quit();
     }
    }
}
