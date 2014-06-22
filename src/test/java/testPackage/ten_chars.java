package testPackage;

import junit.framework.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

/**
 * Created by Анатолий on 22.06.2014.
 */
public class ten_chars {
    @DataProvider(name = "test")
    public Object[][] createData1() {
        return new Object[][] {
                { "Ten_chars." },
                { "AnotherTe"},
                {"OneAnother"},
        };
    }



    @Test(dataProvider = "test")

    public void checkTenChar(String S){
       // String S="1234567890";
        System.out.println(S);
        Assert.assertEquals(10,S.length());
    }

}
