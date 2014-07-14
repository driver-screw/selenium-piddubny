//package testPackage;
//
//
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.SearchResultPage;
//import utils.Log4Test;
////import org.webbitserver.helpers.UTF8Output;
//
//import java.util.Map;
//
//public class Test_ROZ extends TestCondition {
//
//    @Test
//    public void find_likely(){
//
//        SearchResultPage page = new SearchResultPage(driver);
//        page.Open();
//        String type1 = page.search(1,true);
//        page.clean_search_field();
//        String type2 = page.search(2,true);
//        Assert.assertTrue(page.isSameType(type1, type2), Log4Test.fail(String.format("The types of products are different. \nType1 = %S\nType2 = %S",type1,type2)));
//    }
//
//   @Test (dependsOnMethods={"find_likely"})
//    public void add_to_compare(){
//       SearchResultPage page = new SearchResultPage(driver);
//
//       page.clean_search_field();
//       page.search(1,false);
//       page.add_compare();
//       page.clean_search_field();
//       page.search(2,false);
//       page.add_compare();
//       page.go_to_compare();
//       //Check for two elements in compare block
//       Assert.assertTrue(page.isCompareWorks(2), Log4Test.fail("There is no two elements in compare page"));
//
//    }
//
//    @Test (dependsOnMethods = {"add_to_compare"})
//    public void difference(){
//        SearchResultPage page = new SearchResultPage(driver);
//        Map prod1map = page.getInfoMap(1);
//        Map prod2map = page.getInfoMap(2);
//        page.diff_only();
//        Map prod1diffmap = page.getDifferenceMap(1);
//        Map prod2diffmap = page.getDifferenceMap(2);
//
//
//    }
//
//}
