package AppiumFirst;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class MiscellanousAppiumActions extends BaseTest{

	@Test
	public void Miscellanous() throws MalformedURLException {
		//adb shell dumsys window |grep -E 'mCurrentFocus' - MAC
		//adb shell dumsys window |find -E 'mCurrentFocus' -Windows

			// App package & App activity
//		Activity activity = new Activity(null, null);
//		driver.startActivity(activity);
		driver.findElement(AppiumBy.accessibilityId("Preference")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
		driver.findElement(By.id("android:id/checkbox")).click();
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);

		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(alertTitle, "WiFi settings");
		//copy paste
		//copy to clipboard- paste it clipboard testing
		driver.setClipboardText("TURKSAT-KABLONET-3C41-5G");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();

		// key events back, home, keyword actions
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));






	}

}
