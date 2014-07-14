package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import utils.Log4Test;

abstract public class BasePage {
    // Search sequence
    private static final String search1="Lenovo IdeaPad Y510p (59-407121)";
    private static final String search2="Gigabyte P35K (9WP35K000-UA-A-001)";

    protected String url="http://rozetka.com.ua/";
    //Lokators
    private static final By search_field = By.className("header-search-input-text");
    private static final By type = By.xpath("//div[@class='title']/a");

    public WebDriver  driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void Open(){
        Log4Test.info("Open url = "+url);
        driver.get(url);
    }
    public boolean isOpened(){
        return (driver.getCurrentUrl().equals(url));
    }

    public void clean_search_field(){
        Log4Test.info("Clear search field.");
        driver.findElement(search_field).clear();
    }

    public String search(int i,boolean b){

        driver.findElement(search_field).click();
        switch (i) {
            case 1:
                Log4Test.info("Search String = '"+search1+"'.");
                driver.findElement(search_field).sendKeys(search1, Keys.ENTER);
                break;
            case 2:
                Log4Test.info("Search String = '"+search2+"'.");
                driver.findElement(search_field).sendKeys(search2, Keys.ENTER);
                break;
        }
        if (b==true)
            return driver.findElement(type).getText();
        else return "0";
    }




}