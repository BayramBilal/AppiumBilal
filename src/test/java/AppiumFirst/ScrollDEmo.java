package AppiumFirst;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class ScrollDEmo extends BaseTest{

    @Test
    public void ScrollDemoTest() throws MalformedURLException, InterruptedException {

       driver.findElement(AppiumBy.accessibilityId("Views")).click();
      //anrdoid UIAutomator
        //where the scroll is known prior
//       driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"));"));

       // no prior idea
       scrollToEndAction();
    }

}
