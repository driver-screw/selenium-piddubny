package courseProjectTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ComparisonPage;
import testPackage.TestCondition;
import utils.Log4Test;

/**
 * Created by Анатолий on 14.07.2014.
 */
public class CompareDifferenceTest extends TestCondition{
    @Test /* (dependsOnMethods = {"Find_n_AddToCompareTest.add_to_compare()"})*/
    public void compareDifference(){
        Log4Test.info("\nStart Test 'CompareDifferenceTest'");
        ComparisonPage page = new ComparisonPage(driver);
        page.getOnlyDifferenceFromAll();
        page.diff_only();
        page.getOnlyDifferenceFromDiff();
        Assert.assertTrue(page.isCompareWorks(page.getOnlyDifferenceFromAll(), page.getOnlyDifferenceFromDiff()), Log4Test.fail("Compare not Works. There is equal strings"));



    }

}
