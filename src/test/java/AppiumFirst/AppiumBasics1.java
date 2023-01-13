package AppiumFirst;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumBasics1 {
    @Test
    public void AppiumTest() throws MalformedURLException {
        //code to start server

        //Android Driver, IOSDriver
        //Appium code --> Appium Server --> Mobile
        AppiumDriverLocalService serviceBuilder = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\Selim\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1").usingPort(4723).build();
        serviceBuilder.start();

        UiAutomator2Options options=  new UiAutomator2Options();
        options.setDeviceName("Phone1");
        options.setApp("C:\\Users\\Selim\\IdeaProjects\\AppiumBilal\\src\\test\\java\\resources\\ApiDemos-debug.apk");
        // Actual automation
        // id, xpath, accessibiltyId, className, androidUIAutomator
        AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
        driver.findElement(AppiumBy.accessibilityId("Preference")).click();


        driver.quit();
        serviceBuilder.stop();
        //stop server

    }


}
