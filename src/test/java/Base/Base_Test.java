package Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import Constants.CapabilitiesConst;

public class Base_Test {
	protected static AppiumDriver driver = null;
	AppiumDriverLocalService service;
	
	@BeforeSuite
	public void startServer() throws InterruptedException {
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C:\\Users\\jiten\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723)
				.build();
		service.start();
	}
	
	@AfterSuite
	public void closeServer() {
		service.stop();
	}
	
	
	public static AppiumDriver getDriver() throws MalformedURLException {
		URL url = new URL("http://127.0.0.1:4723");
		UiAutomator2Options uia = new UiAutomator2Options();	
		uia.setPlatformName("Android");
		uia.setDeviceName("R3CN602ZQJJ");
		uia.setPlatformVersion("13");
		uia.setAutomationName("UiAutomator2");
		uia.setAppPackage(CapabilitiesConst.PACKAGE_NAME);
		uia.setAppActivity(CapabilitiesConst.ACTIVITY_NAME);
		driver = new AndroidDriver(url, uia);

		return driver;
	}
}
