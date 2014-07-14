package courseProjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SearchResultPage;
import testPackage.TestCondition;
import utils.Log4Test;

/**
 * Created by Анатолий on 13.07.2014.
 */
public class Find2ProductsTest extends TestCondition {

    @Test
    public void find_likely() {
        Log4Test.info("\nStart Test 'Find2ProductsTest'");
        SearchResultPage page = new SearchResultPage(driver);
        page.Open();
        String type1 = page.search(1, true);
        page.clean_search_field();
        String type2 = page.search(2, true);
        Assert.assertTrue(page.isSameType(type1, type2), Log4Test.fail(String.format("The types of products are different. \nType1 = %S\nType2 = %S", type1, type2)));
    }
}