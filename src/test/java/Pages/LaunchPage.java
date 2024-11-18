package Pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.Base_Page;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class LaunchPage extends Base_Page{
	AndroidDriver driver;
	public LaunchPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}
	@AndroidFindBy(xpath="//android.widget.EditText[@resource-id=\"com.androidsample.generalstore:id/nameField\"]")
	private static WebElement nameField;
	
	@AndroidFindBy(xpath="//android.widget.Spinner[@resource-id=\"com.androidsample.generalstore:id/spinnerCountry\"]")
	private static WebElement countries;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioMale\"]")
	private static WebElement male;
	
	@AndroidFindBy(xpath="//android.widget.RadioButton[@resource-id=\"com.androidsample.generalstore:id/radioFemale\"]")
	private static WebElement female;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnLetsShop\"]")
	private static WebElement LetsShop;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")
	private static WebElement title;
	
	public void countrySelect(String country) throws InterruptedException {
		tap(countries, "countries");
		WebElement location = scrollTo(country);
		tap(location,country);
		Thread.sleep(2000);
	}
	
	public void enterName(String name) {
		enterText(nameField, "nameField", name);
	}
	
	public void selectMale() {
		tap(male, "male");
	}
	
	public void selectFemale() {
		tap(female, "female");
	}
	
	public void letsShop() {
		tap(LetsShop, "Let's Shop");
	}
}
