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

public class AppiumPractice4 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Desire capabilites 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability("appPackage", "com.android.calculator2");
		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
		
		
		
		AndroidDriver<WebElement> mobiledriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		
		//Find element by ID 
		//mobiledriver.findElement(By.id("com.android.calculator2:id/digit_7")).click();
		
		//Find element by XPATH with Text
		//mobiledriver.findElement(By.xpath("//android.widget.Button[@text='7']")).click();
		
		//Find element by XPATH with Contains Text
		//mobiledriver.findElement(By.xpath("//android.widget.Button[contains(@text,'7')]")).click();
		
		//Find element by XPATH with Resource ID
		//mobiledriver.findElement(By.xpath("//android.widget.Button[@resource-id='com.android.calculator2:id/digit_7']")).click();
		
		//Find element by XPATH with Contains and Resource ID
		//mobiledriver.findElement(By.xpath("//android.widget.Button[contains(@resource-id,'digit_7')]")).click();
		
		//Find element by XPATH with index and it is not preferable
		//mobiledriver.findElement(By.xpath("//android.widget.Button[@index='0']")).click();
		
		//and and or keywards
		
		//mobiledriver.findElement(By.xpath("//android.widget.Button[@text='7' and @resource-id='com.android.calculator2:id/digit_7']")).click();
		
		mobiledriver.findElement(By.xpath("//android.widget.Button[contains(@text,'7') or @resource-id='com.android.calculator2:id/digit7']")).click();
		mobiledriver.findElement(By.xpath("//android.widget.Button[contains(@text,'x') or @resource-id='com.android.calculator2:id/op_mul']")).click();
		mobiledriver.findElement(By.xpath("//android.widget.Button[@text='5' and @resource-id='com.android.calculator2:id/digit_5']")).click();
		mobiledriver.findElement(By.xpath("//android.widget.Button[@text='=' and @resource-id='com.android.calculator2:id/eq']")).click();
		String value = mobiledriver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.android.calculator2:id/result']")).getText();
		System.out.println(value);
	}

}
