package testPackage;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TicketsPage;

/**
 * Created by c248 on 04.07.2014.
 */
public class BuyTickets extends SetEnv {

    @Test
    public void buy2infantTickets(){
        TicketsPage page= new TicketsPage(driver);
        page.Open();
        page.buyTickets(0,0,2);
        Assert.assertTrue(page.isError());
    }
}
