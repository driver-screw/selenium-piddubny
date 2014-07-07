package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;
import utils.Log4Test;

/**
 * Created by c248 on 04.07.2014.
 */
public class BuyTickets extends SetEnv {

    @Test
    public void buy2infantTickets(){
        TicketsPage page= new TicketsPage(driver);
        page.Open();
        page.buyTickets(0,0,2);
        Assert.assertTrue(page.isError(), Log4Test.fail("Oh NO!! We can buy tickets for only infants!"));
        Assert.assertTrue(false, Log4Test.fail("This should not work!"));
    }
}
