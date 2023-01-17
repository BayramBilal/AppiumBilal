package AppiumFirst;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class AppiumBasics extends BaseTest{

	@Test
	public void WifiSettingsName() throws MalformedURLException {

		//code to start server

		//Android Driver, IOSDriver
		//Appium code --> Appium Server --> Mobile
			// Actual automation
		// id, xpath, accessibiltyId, className, androidUIAutomator
	// tagName[@attribute='value']
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
//		driver.findElement(By.xpath("")




//set wifi name

	}

}
