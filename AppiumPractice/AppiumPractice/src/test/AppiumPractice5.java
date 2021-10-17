package test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class AppiumPractice5 {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		//Desire capabilites 
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
		capabilities.setCapability("appPackage", "com.example.vini.addingofnumbers");
		capabilities.setCapability("appActivity", "com.example.vini.addingofnumbers.MainActivity");
		
		capabilities.setCapability("app", "/Users/vini/eclipse-workspace/Demo_NexusPhone/apks/calculations.apk");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", true);
		
		AndroidDriver<WebElement> mobiledriver = new AndroidDriver<WebElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		mobiledriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		String currentContext = mobiledriver.getContext();
		System.out.println(currentContext);
		
		
		String currentOrientation = mobiledriver.getOrientation().name();
		System.out.println(currentOrientation);
		
		//mobiledriver.rotate(ScreenOrientation.LANDSCAPE);
		
		
		//String currentOrientation1 = mobiledriver.getOrientation().name();
		//System.out.println(currentOrientation1);
		
		
		mobiledriver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.vini.addingofnumbers:id/editText1']")).sendKeys("1");
		mobiledriver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.vini.addingofnumbers:id/editText2']")).sendKeys("2");
		
		mobiledriver.findElement(By.xpath("//android.widget.Button[@text='ADD']")).click();
	
		mobiledriver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.vini.addingofnumbers:id/editText1']")).clear();
		mobiledriver.findElement(By.xpath("//android.widget.EditText[@resource-id='com.example.vini.addingofnumbers:id/editText1']")).sendKeys("2");
		mobiledriver.findElement(By.xpath("//android.widget.Button[@text='ADD']")).click();
	}

}
