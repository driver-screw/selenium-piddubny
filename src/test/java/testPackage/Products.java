package testPackage;

import org.testng.annotations.DataProvider;

/**
 * Created by Анатолий on 13.07.2014.
 */
public class Products {
    @DataProvider(name = "products")
    public static Object[][] createData() {
        return new Object[][]{
                { new String[] {"Lenovo IdeaPad Y510p (59-407121)", "Gigabyte P35K (9WP35K000-UA-A-001)"} },
        };
    }
}
