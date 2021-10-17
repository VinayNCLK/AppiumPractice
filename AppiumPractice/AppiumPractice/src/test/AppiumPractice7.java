package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumPractice7 {
	
	


	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Desire capabilites 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability("appPackage", "com.android.androidui");
		capabilities.setCapability("appActivity", "com.android.androidui.MainActivity");
		
		//capabilities.setCapability("app", "/Users/vini/eclipse-workspace/Demo_NexusPhone/apks/calculations.apk");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", true);
		
		AndroidDriver<WebElement> mobiledriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		mobiledriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String currentContext = mobiledriver.getContext();
		System.out.println(currentContext);
		
		
		String currentOrientation = mobiledriver.getOrientation().name();
		System.out.println(currentOrientation);
		
		
		Thread.sleep(5000);
		//Handling alerts in Appium
		
		mobiledriver.findElement(By.id("com.android.androidui:id/buttonAlert")).click();
		Thread.sleep(5000);
		String alertmsg = mobiledriver.findElement(By.id("android:id/message")).getText();
		System.out.println(alertmsg);
		
		mobiledriver.findElement(By.id("android:id/button2")).click();
		
		
		//Handling drop downs in Appium
		
		mobiledriver.findElement(By.id("android:id/text1")).click();
		mobiledriver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Singapore']")).click();
		
		
		//Handling progress bar
		WebElement seekbar = mobiledriver.findElement(By.id("com.android.androidui:id/seekBar1"));
		
		int StartX = seekbar.getLocation().getX();
		int StartY = seekbar.getLocation().getY();
		
		//int EndX = StartX + seekbar.getSize().width;
		
		int EndX = 471;
		
		TouchAction act = new TouchAction(mobiledriver);
		act.longPress(StartX, StartY).moveTo(EndX, StartY).release().perform();
		
		
		

	}

}
