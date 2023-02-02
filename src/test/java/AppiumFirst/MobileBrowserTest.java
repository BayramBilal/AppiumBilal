package AppiumFirst;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends BrowserBaseTest{

    @Test
    public void browserTest(){

    driver.get("http://google.com");
        System.out.println(driver.getTitle());
    driver.findElement(By.name("q")).sendKeys("rahul shetty academy", Keys.ENTER);
    driver.get("https://rahulshettyacademy.com/angularAppdemo/");
    driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();
    driver.findElement(By.cssSelector("a[routerlink*='product']")).click();

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)", "");
    String text = driver.findElement(By.cssSelector("//a[href*='product/3']")).getText();
        Assert.assertEquals(text, "Devops");


    }






}
