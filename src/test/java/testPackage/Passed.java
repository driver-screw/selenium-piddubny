package testPackage;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 20.06.14
 * Time: 21:10
 * To change this template use File | Settings | File Templates.
 */
public class Passed {
   @Test
    public void passed(){

        Assert.assertEquals(1,1);
    }
}
