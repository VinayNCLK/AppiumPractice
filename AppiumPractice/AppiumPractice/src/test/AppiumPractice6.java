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

public class AppiumPractice6 {
	
	
	//Swipping at the middle of the screen
	public static void swipping(AndroidDriver driver, int startx, int endx) {
		
		Dimension dis = driver.manage().window().getSize();
		int yaxis = dis.height / 2;
		TouchAction act = new TouchAction(driver);
		act.press(startx, yaxis).waitAction(Duration.ofMillis(5000)).moveTo(endx, yaxis).release().perform();		
	}
	
	
	//Scrolling at the particular y axis
	public static void swipping_withcoordinates(AndroidDriver driver, int startx, int endx, int yaxis) {
		TouchAction act = new TouchAction(driver);
		act.press(startx, yaxis).waitAction(Duration.ofMillis(5000)).moveTo(endx, yaxis).release().perform();
		
	}
	
	//Scrolling at the particular x axis
	public static void scrolling_withcoordinates(AndroidDriver driver, int starty, int endy, int xaxis) {
		TouchAction act = new TouchAction(driver);
		act.press(xaxis, starty).waitAction(Duration.ofMillis(5000)).moveTo(xaxis, endy).release().perform();
		
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Desire capabilites 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "3649cefb0408");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");
		
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
		
		//WebElement camerashutter = mobiledriver.findElement(By.id("com.android.camera2:id/shutter_button"));
		
		//TouchAction act = new TouchAction(mobiledriver);
		//act.tap(241, 719).perform();
		//act.tap(camerashutter, 241, 719).perform();
		
		//System.out.println("Clicked on image");
		
		//Thread.sleep(4000);
		
		//act.tap(423, 514).perform();
		
		//swipping(mobiledriver,467,5);
		Thread.sleep(4000);
		swipping_withcoordinates(mobiledriver, 1044,26, 440);
		
		Thread.sleep(4000);
		scrolling_withcoordinates(mobiledriver, 1950, 669, 541);

		
	}

}
