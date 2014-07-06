package testPackage;

/**
 * Created by Анатолий on 03.07.2014.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class SetEnv {

    public static WebDriver driver;

    @BeforeSuite
    public void Before(){
        driver = new FirefoxDriver();
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
