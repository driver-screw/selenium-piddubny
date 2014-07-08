package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


/**
 * Created by Анатолий on 06.07.2014.
 */
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
    private static final String table = "(//div[@class='scroll']/table/tbody/tr[@class='different' or @class='different bg-color'])[%d]/td[%d]";
    public ToComparePage(WebDriver driver) {
        super(driver);

    }

    public void clean_search_field(){
//        driver.findElement(By.className(search_field)).click();
//        Actions builder = new Actions(driver);
//        builder.sendKeys(Keys.chord(Keys.LEFT_CONTROL, "a"),Keys.DELETE);
//        builder.perform();
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

    public void isSameType(String product_type1, String product_type2){
        Assert.assertEquals(product_type1, product_type2);
    }

    public void add_compare(){
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(add_compare));
        driver.findElement(add_compare).click();

    }

    public void go_to_compare(){
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(compare));
        driver.findElement(compare).click();
    }

    public void isCompareWorks(int n){
         boolean presence;
        try {
            driver.findElement(By.xpath(String.format(check, n + 1)));
            presence=true;
        }
        catch (NoSuchElementException e){
            presence=false;
     }
        Assert.assertEquals(presence,true);
    }
    public void diff_only(){
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(diff));
        driver.findElement(diff).click();
    }
    public void is_diff(){
        int i=1;
        do {

            try {
                String S1 = driver.findElement(By.xpath(String.format(table, i, 2))).getText();
                String S2 = driver.findElement(By.xpath(String.format(table, i, 3))).getText();
                Assert.assertNotEquals(S1, S2);
                System.out.println("Check " + i + " string. '" + driver.findElement(By.xpath(String.format(table, i, 1))).getText() + "'");
                System.out.println(S1 + "\n" + S2);
            } catch (NoSuchElementException e) {
                System.out.println("You all will CAPUT! Nothing find on " + i + " string.\nAnd this is cyrillic check: раз два три");
            }
        i++;
        }
        while (driver.findElements(By.xpath(String.format(table, i, 2))).size()>0);

    }
}
