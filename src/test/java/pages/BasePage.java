package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by c248 on 04.07.2014.
 */
abstract public class BasePage {
    protected String url="http://rozetka.com.ua/";
    protected WebDriver  driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void Open(){
        driver.get(url);
    }
    public boolean isOpened(){
        return (driver.getCurrentUrl().equals(url));
    }




}