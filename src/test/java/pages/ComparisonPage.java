package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.WebDriverWrapper;
import utils.Log4Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by c248 on 09.07.2014.
 */

//This class was written in class
public class ComparisonPage extends BasePage {
    private static final int PROD1_NUMBER = 2;
    private static final int PROD2_NUMBER = 3;

    private static final By keyLocator = By.xpath("//td[@class='datail-tittle']");
    private static final String valueLocator = "//td[@class='datail-tittle']/ancestor::tr/td[%d]";
    private static final String diffvalueLocator = "(//div[@class='scroll']/table/tbody/ancestor::tr[@class='different' or @class='different bg-color'])/td[%d]";
    private static final By diff = By.xpath("//div[@id='compare-menu']/ul[@class='menu-sort-filter']/li[2]");
    private static final String check = "//table/thead/tr/td[%d]";

    public ComparisonPage(WebDriverWrapper driver) {
        super(driver);
    }

    public void diff_only() {
        Log4Test.info("Click on DIFF_ONLY BTN.");
        WebElement sort_all = (new WebDriverWait(driver, 20)).
                until(ExpectedConditions.elementToBeClickable(diff));
        driver.findElement(diff).click();
    }

    protected List<WebElement> getKeyValue(){
        return driver.findElements(keyLocator);
    }

    protected List<WebElement> getProdValue(int i){
        return driver.findElements(By.xpath(String.format(valueLocator,i)));
    }
    protected List<WebElement> getProdDiffValue(int i){
        return driver.findElements(By.xpath(String.format(diffvalueLocator,i)));
    }

    public boolean isElementsPresentInCompareTable(int n) {
        Log4Test.info("Checking for "+n+" elements in compare table.");
        try {
            driver.findElement(By.xpath(String.format(check, n + 1)));
            return true;
        } catch (NoSuchElementException e) {
            Log4Test.error("There are no " + n + "-nd product in compare table.");
            return false;
        }
    }

    public String[] getOnlyDifferenceFromAll () {
        Log4Test.info("Get difference from all compare table.");
        List<WebElement> keys = getKeyValue();
        List<WebElement> prod1Values = getProdValue(PROD1_NUMBER);
        List<WebElement> prod2Values = getProdValue(PROD2_NUMBER);
        String[] res = new String[keys.size()];
        int j = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (!prod1Values.get(i).getText().equals(prod2Values.get(i).getText())) {
                res[j] = keys.get(i).getText();
                j++;
            }
        }
        return res;
    }

    public String[] getOnlyDifferenceFromDiff () {
        Log4Test.info("Get difference from diff compare table.");
        List<WebElement> keys = getKeyValue();
        List<WebElement> prod1Values = getProdDiffValue(PROD1_NUMBER);
        List<WebElement> prod2Values = getProdDiffValue(PROD2_NUMBER);
        String[] res = new String[keys.size()];
        int j = 0;
        for (int i = 0; i < keys.size(); i++) {
            if (!prod1Values.get(i).getText().equals(prod2Values.get(i).getText())) {
                res[j] = keys.get(i).getText();
                j++;
            }
        }
        return res;
    }

    public boolean isCompareWorks(String[] diffFromAll, String[] diffFromDiff ){
        Log4Test.info("Check for compare works right.");
        for(int i=0;i<diffFromAll.length;i++ ){
            if(diffFromAll[i]!=diffFromDiff[i]) {
                Log4Test.error("There is equal string difference only compare table.");
                return false;
            }
        }
        Log4Test.info("OK");
        return true;
    }

}
