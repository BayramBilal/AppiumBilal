package AppiumFirst;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class eCommerce_tc_3 extends BaseTest {


    @Test
    public void FillForm() throws InterruptedException {

    driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Eva Peron");
    driver.hideKeyboard();
    driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
    driver.findElement(By.id("android:id/text1")).click();
    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Argentina\"));"));
    driver.findElement(By.xpath("//android.widget.TextView[@text='Argentina']")).click();

    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();

    driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"));"));

//    driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CHART']")).get(0).click();
//    driver.findElements(By.xpath("//android.widget.TextView[@text='ADD TO CHART']")).get(0).click();

        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < productCount; i++) {
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equalsIgnoreCase("Jordan 6 Rings")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
            if(productName.equalsIgnoreCase("Jordan Lift Off")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }

    driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
    List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
    int count = productPrices.size();
    double totalSum = 0;

        for (int i = 0; i < count; i++) {
           String amountString = productPrices.get(i).getText();
           //$160.97
           Double price = getFormattedAmount(amountString);
           totalSum = totalSum + price;   //160.97 + 120 = 280.97

        }
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displatFormattedSum = getFormattedAmount(displaySum);
        System.out.println( totalSum+" = " + displatFormattedSum);
        Assert.assertEquals(totalSum, displatFormattedSum);

        longPressAction(driver.findElement(By.id("com.androidsample.generalstore:id/termsButton")));
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(3000);

        //Hybrid app -->Google page -->
    }
}
