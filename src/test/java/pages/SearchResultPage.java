package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.Log4Test;

import java.lang.reflect.Array;
import java.util.*;


public class SearchResultPage extends BasePage {
    private static final By add_compare =By.xpath("//div[@class='g-i-list-compare']/a[@class='xhr lightblue']");
    private static final By compare = By.xpath("//div[@class='g-i-list-compare']/a[@class='lightblue underline']");

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public boolean isSameType(String product_type1, String product_type2){
        Log4Test.info("Check for product same type.");
       return (product_type1.equals(product_type2));
    }

    public void add_compare(){
        Log4Test.info("Add product to compare.");
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(add_compare));
        driver.findElement(add_compare).click();
    }

    public void go_to_compare(){
        Log4Test.info("Click on 'go to compare' BTN.");
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(compare));
        driver.findElement(compare).click();
    }
}
