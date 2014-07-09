package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by c248 on 09.07.2014.
 */

//This class was written in class
public class ComparisonPage extends BasePage {
    private static final By keyLocator = By.xpath("//td[@class='datail-tittle']");
    private static final String valueLocator = "//td[@class='datail-tittle']/ascestor::tr/td[%d]";

    public ComparisonPage(WebDriver driver){
        super(driver);
    }

    //public List<WebElement>
}
