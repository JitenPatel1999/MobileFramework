package Pages;

import org.openqa.selenium.WebElement;

import Base.Base_Page;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage extends Base_Page{
	AndroidDriver driver;
	public CartPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_back\"]")
	private static WebElement back;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/termsButton\"]")
	private static WebElement terms;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement close;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]")
	private static WebElement visitToWebsite;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
	private static WebElement checkbox;
	
	public void checkTerms() {
		longPress(terms, "Terms of conditions");
		if (close.isDisplayed()) {
	        tap(close, "Close"); 
	    } else {
	        System.out.println("Alert not displayed.");
	    }
	}
	
	public void checkBox() {
		tap(checkbox, "Checkbox");
	}
	
	public void visitWebsite() {
		tap(visitToWebsite, "Visit to website");
	}
}
