package courseProjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparisonPage;
import pages.SearchResultPage;
import testPackage.TestCondition;
import utils.Log4Test;

/**
 * Created by Анатолий on 13.07.2014.
 */
public class Find_n_AddToCompareTest extends TestCondition {
    @Test  /*(dependsOnMethods={"Find2ProductsTest.find_likely"})*/
    public void add_to_compare(){
        Log4Test.info("\nStart Test 'Find_n_AddToCompareTest'");
        SearchResultPage page = new SearchResultPage(driver);
        page.clean_search_field();
        page.search(1,false);
        page.add_compare();
        page.clean_search_field();
        page.search(2,false);
        page.add_compare();
        page.go_to_compare();
        //Check for two elements in compare block
        ComparisonPage compage = new ComparisonPage(driver);
        Assert.assertTrue(compage.isElementsPresentInCompareTable(2), Log4Test.fail("There is no two elements in compare page"));

    }
}
