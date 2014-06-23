package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 * User: admin
 * Date: 23.06.14
 * Time: 20:22
 * To change this template use File | Settings | File Templates.
 */
public class Buy_Smart {

    @Test
        public void buy_cheap_smart(){

          WebDriver driver = new FirefoxDriver();
        driver.get("http://rozetka.com.ua/");
       String text=  driver.findElement(By.className("m-cart-empty")).getText() ;
        Assert.assertEquals("Корзина пуста",text);


        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("phones-mp3-gps")));
    //    builder.click(driver.findElement(By.partialLinkText("smartphones")));
          builder.perform();
         driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")).click();
        driver.findElement(By.className("m-cat-subl-i-link")).click();
        driver.findElement(By.className("xhr lightblue sprite dropdown")).click();
        driver.findElement(By.xpath("//*[@id=\"sort_view\"]/div/div/ul/li[1]/a")).click();
       // driver.quit();
    }


}
