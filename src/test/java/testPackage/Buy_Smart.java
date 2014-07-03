package testPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
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
      public static WebDriver driver= new FirefoxDriver();

   @BeforeSuite
   public void Before(){


       driver.get("http://rozetka.com.ua/");
       driver.manage().window().maximize();
   }


    @Test
        public void buy_cheap_smart(){

        WebElement trash = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("m-cart-empty")));


        String text=  driver.findElement(By.className("m-cart-empty")).getText() ;
        Assert.assertEquals("Корзина пуста",text);
    //    Assert.assertEquals(driver.findElement( driver.findElement(By.className("m-cart-empty")).isDisplayed(),true);

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.id("phones-mp3-gps")));
    //    builder.click(driver.findElement(By.partialLinkText("smartphones")));
          builder.perform();
       //WebElement down_menu =(new WebDriverWait(driver, 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")));
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")));
      //until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")));

        WebElement smarts = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")));

        driver.findElement(By.xpath("//*[@id=\"phones-mp3-gps\"]/div/div/ol/li[1]/ul[1]/li[1]/a")).click();

        WebElement sort_all = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("m-cat-subl-i-link")));

        driver.findElement(By.className("m-cat-subl-i-link")).click();

        WebElement sort = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/a")));

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/a")).click();

        WebElement cheap_sort = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/div/div/ul/li[1]/a")));

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[3]/div[1]/div/div/ul/li[1]/a")).click();

        // Купить кнопка /html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[1]/div[1]/div/div/div[3]/div[2]/div/form/button
        WebElement buy_the_cheapest = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[1]/div[1]/div/div/div[3]/div[2]/div/form/button")));

        driver.findElement(By.xpath("/html/body/div[1]/div[3]/div/div[1]/div[2]/div/div[4]/div[1]/div[1]/div[1]/div[1]/div/div/div[3]/div[2]/div/form/button")).click();


// Корзина. ищем к-во тавара. /html/body/div[1]/div/div/div/div[1]/div[2]/div/div[4]/input
        WebElement find_qt_pole = (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div/div[4]/input")));

        String text2=  driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div/div[4]/input")).getAttribute("value") ;
        Assert.assertEquals("1",text2);

        // driver.quit();
    }


}
