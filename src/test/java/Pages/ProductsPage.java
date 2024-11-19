package Pages;

import java.util.List;

import org.openqa.selenium.WebElement;

import Base.Base_Page;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends Base_Page {
	AndroidDriver driver;
	public ProductsPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_cart\"]")
	private static WebElement cart;
	
	@AndroidFindBy(xpath="//android.widget.ImageButton[@resource-id=\"com.androidsample.generalstore:id/appbar_btn_back\"]")
	private static WebElement back;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/toolbar_title\"]")
	private static WebElement title;
	
	public String getTitle() {
		return title.getText();
	}
	
	public String getShoeName(String name) {
		return driver.findElement(AppiumBy.xpath(""
				+ "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\" and @text=\""
				+name+"\"]")).getText();
	}
	
	public String getShoePrice(String price) {
		return driver.findElement(AppiumBy.xpath(""
				+ "//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productPrice\" and @text=\""
				+price+"\"]")).getText();
	}
	public void addToCart(String shoename) {
		WebElement shoe = scrollElementToCenter(shoename);
		List<WebElement> addToCart = driver.findElements(AppiumBy.xpath(
	    "//android.widget.TextView[@resource-id='com.androidsample.generalstore:id/productAddCart']"));
		List<WebElement> shoes = driver.findElements(AppiumBy.xpath(
				"//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productName\"]"));
		for(int i = 0; i < shoes.size(); i++) {
			if(shoes.get(i).getText().equals(shoename)) {
				tap(addToCart.get(i), "ADD TO CART");
			}
		}
	}
	
	public void viewCart() {
		tap(cart, "Cart");
	}
	
	public AndroidDriver back() {
		tap(back, "Back");
		return driver;
	}
}
