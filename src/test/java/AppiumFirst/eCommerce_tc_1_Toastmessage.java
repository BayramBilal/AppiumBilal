package AppiumFirst;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class eCommerce_tc_1_Toastmessage extends BaseTest {


    @Test
    public void ToastMessage() throws InterruptedException {

    driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
      // toast message
    String toastMessage = driver.findElement(By.xpath("(//android.widget.Toast)[1]")).getAttribute("name");
        Assert.assertEquals(toastMessage, "Please enter your name");

    }
}
