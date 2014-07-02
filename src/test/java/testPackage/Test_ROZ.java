package testPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Test_ROZ {

    public static WebDriver driver= new FirefoxDriver();

    @BeforeSuite
    public void Before(){

    driver.get("http://rozetka.com.ua/");
    driver.manage().window().maximize();

    }

    @Test
    public void add_to_compare(){

        //кликаем по вкладке НОУТБУКИ
        driver.findElement(By.xpath("/html/body/header/div[3]/div/div/table/tbody/tr/td/div/a")).click();



    }
}
