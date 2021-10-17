package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumPractice2 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Desire capabilites 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.1");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone XR");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
		capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
		
		
		IOSDriver<WebElement> mobiledriver = new IOSDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		mobiledriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		mobiledriver.get("https://www.actitime.com/");
		Thread.sleep(10000);
		mobiledriver.findElement(By.xpath("//div[@class='header__burger']")).click();
		
		
		
		
		
	}

}
