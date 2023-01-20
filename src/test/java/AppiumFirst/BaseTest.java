package AppiumFirst;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    public AndroidDriver driver;
    public AppiumDriverLocalService serviceBuilder;
@BeforeClass
    public void ConfigureAppium() throws MalformedURLException {



        serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Selim\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();

        UiAutomator2Options options=  new UiAutomator2Options();
        options.setDeviceName("Phone1");
        options.setApp("C:\\Users\\Selim\\IdeaProjects\\AppiumBilal\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        // Actual automation
        // id, xpath, accessibiltyId, className, androidUIAutomator
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

}

public void longPressAction(WebElement elementPeopleNames){

    ((JavascriptExecutor)driver).executeScript("mobile: longClickGesture",
            ImmutableMap.of("elementId", ((RemoteWebElement)elementPeopleNames).getId(), "duration", 2000));
}
@AfterClass
public void tearDown(){


    driver.quit();
    serviceBuilder.stop();

}
}