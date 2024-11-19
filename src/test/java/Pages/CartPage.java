package Pages;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")
	private static WebElement title;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_back\"]")
	private static WebElement back;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/totalAmountLbl\"]")
	private static WebElement totalPrice;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/termsButton\"]")
	private static WebElement terms;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/alertTitle\"]")
	private static WebElement alertTitle;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"android:id/button1\"]")
	private WebElement close;
	
	@AndroidFindBy(xpath="//android.widget.Button[@resource-id=\"com.androidsample.generalstore:id/btnProceed\"]")
	private static WebElement visitToWebsite;
	
	@AndroidFindBy(xpath="//android.widget.CheckBox[@text=\"Send me e-mails on discounts related to selected products in future\"]")
	private static WebElement checkbox;
	
	public String getTitle() {
		return title.getText();
	}
	
	public String getTotalPrice() {
		String price = totalPrice.getText();
		price = price.trim().replaceAll(" ", "");
		return price;
	}
	
	public void checkTerms() {
		longPress(terms, "Terms of conditions");
		String title = getAlertTitle();
		Assert.assertEquals(title, "Terms Of Conditions", "Alert title validation failed!");
		System.out.println("Alert title validation passed!");
		if (close.isDisplayed()) {
	        tap(close, "Close"); 
	    } else {
	        System.out.println("Alert not displayed.");
	    }
	}
	
	public String getAlertTitle() {
		return alertTitle.getText();
	}
	
	public void checkBox() {
		tap(checkbox, "Checkbox");
	}
	
	public void visitWebsite() {
		tap(visitToWebsite, "Visit to website");
	}
}
