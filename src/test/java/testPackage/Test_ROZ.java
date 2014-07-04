package testPackage;


import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import org.webbitserver.helpers.UTF8Output;

import java.util.concurrent.TimeUnit;

public class Test_ROZ extends SetEnv {

    // Search sequence
    private static final String search1="Lenovo IdeaPad Y510p (59-407121)";
    private static final String search2="Gigabyte P35K (9WP35K000-UA-A-001)";

   // Lokators
    private static final String notebooks = "/html/body/header/div[3]/div/div/table/tbody/tr/td/div/a";
    private static final String search_field = "header-search-input-text";
    private static final String type ="/html/body/div[1]/div[3]/div/div[1]/div/div/div[2]/div/div[2]/a";
    private static final String add_compare ="/html/body/div[1]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a";
    private static final String compare = "/html/body/div[1]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a";
    //public   WebElement field = driver.findElement(By.className(search_field));
    // /html/body/div[1]/div[3]/div/div[1]/div/div/div[3]/div/div[1]/div[3]/a


    private void clean_search_field(){
        driver.findElement(By.className(search_field)).click();
        Actions builder = new Actions(driver);
        builder.sendKeys(Keys.chord(Keys.LEFT_CONTROL,"a"),Keys.DELETE);
        builder.perform();
 //       driver.findElement(By.className(search_field)).clear();
    }

    private void search(String S){
        driver.findElement(By.className(search_field)).click();
        driver.findElement(By.className(search_field)).sendKeys(S,Keys.ENTER);
    }

    @Test
    public void find_likely(){

        //WebElement field = driver.findElement(By.className(search_field));
        search(search1);
        String product_type1 = driver.findElement(By.xpath(type)).getText();

        //Deleting previous search sequence
        clean_search_field();

        search(search2);
        String product_type2 = driver.findElement(By.xpath(type)).getText();
        Assert.assertEquals(product_type1,product_type2);
        clean_search_field();
    }

   @Test (dependsOnMethods={"find_likely"})
    public void add_to_compare(){
        clean_search_field();


          search(search1);

        driver.findElement(By.xpath(add_compare)).click();

        //2
        clean_search_field();
        search(search2);
        driver.findElement(By.xpath(add_compare)).click();

       WebElement sort_all = (new WebDriverWait(driver, 20))
               .until(ExpectedConditions.elementToBeClickable(By.xpath(compare)));
       driver.findElement(By.xpath(compare)).click();
    }

}
