package testPackage;



import org.testng.annotations.Test;
import pages.ToComparePage;
//import org.webbitserver.helpers.UTF8Output;

import java.util.concurrent.TimeUnit;

public class Test_ROZ extends SetEnv {

    @Test
    public void find_likely(){

        ToComparePage page = new ToComparePage(driver);
        page.Open();
        String type1 = page.search(1,true);
        page.clean_search_field();
        String type2 = page.search(2,true);
        page.isSameType(type1,type2);
    }

   @Test (dependsOnMethods={"find_likely"})
    public void add_to_compare(){
       ToComparePage page = new ToComparePage(driver);

       page.clean_search_field();
       page.search(1,false);
       page.add_compare();
       page.clean_search_field();
       page.search(2,false);
       page.add_compare();
       page.go_to_compare();
       //Check for two elements in compare block
       page.isCompareWorks(2);

    }

}
