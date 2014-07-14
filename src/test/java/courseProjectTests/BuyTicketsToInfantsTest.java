package courseProjectTests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;
import testPackage.TestCondition;
import utils.Log4Test;

/**
 * Created by c248 on 04.07.2014.
 */
public class BuyTicketsToInfantsTest extends TestCondition {

    @Test
    public void buy2infantTickets(){
        Log4Test.info("\nStart Test 'BuyTicketsToInfantsTest'");
        TicketsPage page= new TicketsPage(driver);
        page.Open();
        page.buyTickets(0,0,2);
        Assert.assertTrue(page.isError(), Log4Test.fail("Oh NO!! We can buy tickets for only infants!"));

    }
}
