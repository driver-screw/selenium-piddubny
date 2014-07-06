package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.BasePage;



/**
 * Created by c248 on 04.07.2014.
 */
public class TicketsPage extends BasePage {


    // To rewrite xPath with full className
    private static final String infantsTicketsLocator = "//div[@class='infants_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String childrensTicketsLocator = "//div[@class='children_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final String adultTicketsLocator = "//div[@class='adults_block passengers_wrapper']/div[@class='persons']/div[%d]";
    private static final  By errorPopup = By.className("error_popup");
    private static final By findBtn = By.id("start_search");


    public TicketsPage(WebDriver driver) {
        super(driver);
        url = "http://rozetka.com.ua/travel/IEV/MOW/";

    }




    public void buyTickets(int adults,int childrens, int infants){


        WebElement wait = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(By.xpath(String.format(adultTicketsLocator,5))));

        switch (adults) {
            case 0:  driver.findElement(By.xpath(String.format(adultTicketsLocator, 1))).click();break;
            case 1:  break;
            default: driver.findElement(By.xpath(String.format(adultTicketsLocator, adults))).click();
        }

        switch (childrens) {
            case 0:
                break;
            default:
                driver.findElement(By.xpath(String.format(childrensTicketsLocator, childrens))).click();
        }

        switch (infants) {
            case 0:
                break;
            default:
                driver.findElement(By.xpath(String.format(infantsTicketsLocator,infants))).click();
        }

        driver.findElement(findBtn).click();


    }

    public boolean isError(){

        return driver.findElements(errorPopup).size()>0;
    }
}
