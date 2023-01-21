package AppiumFirst;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LongPressTest extends BaseTest{

    @Test
    public void LongPressGesture() throws MalformedURLException {

        driver.findElement(AppiumBy.accessibilityId("Views")).click();
        driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
        driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
        WebElement elementPeopleNames = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
        longPressAction(elementPeopleNames);

         String menuText =   driver.findElement(By.id("android:id/title")).getText();
         Assert.assertEquals(menuText, "Sample menu");
         Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());

         // scroll down

    }

}
