package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.lang.reflect.Array;
import java.util.*;


public class ToComparePage extends BasePage {
    // Search sequence
    private static final String search1="Lenovo IdeaPad Y510p (59-407121)";
    private static final String search2="Gigabyte P35K (9WP35K000-UA-A-001)";

    // Lokators
    private static final By search_field = By.className("header-search-input-text");
    private static final By type = By.xpath("//div[@class='title']/a");
    private static final By add_compare =By.xpath("//div[@class='g-i-list-compare']/a[@class='xhr lightblue']");
    private static final By compare = By.xpath("//div[@class='g-i-list-compare']/a[@class='lightblue underline']");
    private static final String check = "//table/thead/tr/td[%d]";
    private static final By diff = By.xpath("//div[@id='compare-menu']/ul[@class='menu-sort-filter']/li[2]");
    private static final String difference_table = "(//div[@class='scroll']/table/tbody/tr[@class='different' or @class='different bg-color'])[%d]/td[%d]";
    private static final String compare_table = "(//div[@class='scroll']/table/tbody/tr)[%d]/td[%d]";
    public ToComparePage(WebDriver driver) {
        super(driver);

    }

    public void clean_search_field(){
          driver.findElement(search_field).clear();
    }

    public String search(int i,boolean b){
        driver.findElement(search_field).click();
        switch (i) {
            case 1:
                driver.findElement(search_field).sendKeys(search1, Keys.ENTER);
                break;
            case 2:
                driver.findElement(search_field).sendKeys(search2, Keys.ENTER);
                break;
        }
        if (b==true)
        return driver.findElement(type).getText();
        else return "0";
    }

    public boolean isSameType(String product_type1, String product_type2){
       return (product_type1.equals(product_type2));

    }

    public void add_compare(){
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(add_compare));
        driver.findElement(add_compare).click();
        System.out.println("I hope its click on THE BUTTON");
    }

    public void go_to_compare(){
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(compare));
        driver.findElement(compare).click();
    }

    public boolean isCompareWorks(int n){
        try {
            driver.findElement(By.xpath(String.format(check, n + 1)));
            return true;
        }
        catch (NoSuchElementException e){
            return false;
        }
    }
    public void diff_only(){
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(diff));
        driver.findElement(diff).click();
    }

    public Map getInfoMap(int number_of_product){
        int i=1;
        Map prodmap = new HashMap < String, String>();
        do {

            try {
                String S1 = driver.findElement(By.xpath(String.format(compare_table, i, 1))).getText();
                String S2 = driver.findElement(By.xpath(String.format(compare_table, i, number_of_product+1))).getText();
                prodmap.put(S1,S2);
                System.out.println("Check " + i + " string. '" + driver.findElement(By.xpath(String.format(compare_table, i, 1))).getText() + "'");
                System.out.println("\n"+ S2);
            } catch (NoSuchElementException e) {
                System.out.println("You all will CAPUT! Nothing find on " + i + " string.\nAnd this is cyrillic check: раз два три");
            }
            i++;
        }
        while (driver.findElements(By.xpath(String.format(compare_table, i, 1))).size()>0);
        return prodmap;
    }


    public Map getDifferenceMap(int number_of_product){
        int i=1;
        Map diffprodmap = new HashMap < String, String>();
        do {
            try {
                String S1 = driver.findElement(By.xpath(String.format(difference_table, i, 1))).getText();
                String S2 = driver.findElement(By.xpath(String.format(difference_table, i, number_of_product+1))).getText();
                diffprodmap.put(S1,S2);
                System.out.println("Check " + i + " string. '" + driver.findElement(By.xpath(String.format(difference_table, i, number_of_product+1))).getText() + "'");
                System.out.println("\n" + S2);
            } catch (NoSuchElementException e) {
                System.out.println("You all will CAPUT! Nothing find on " + i + " string.\nAnd this is cyrillic check: раз два три");
            }
        i++;
        }
        while (driver.findElements(By.xpath(String.format(difference_table, i, 1))).size()>0);
        return diffprodmap;
    }
    //Does anyone know how to do this block???
    public void getKeyWithDiffValue(Map map1, Map map2){

        for( Iterator<String> it = map1.keySet().iterator(); it.hasNext(); ){
            if (!map2.equals(it.next()) ) {
               //Object S1[1]=s1;
            }
        }
    }
}
