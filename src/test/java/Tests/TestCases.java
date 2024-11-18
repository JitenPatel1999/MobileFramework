package Tests;

import java.net.MalformedURLException;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base_Test;
import Pages.CartPage;
import Pages.LaunchPage;
import Pages.ProductsPage;
import io.appium.java_client.android.AndroidDriver;
public class TestCases extends Base_Test{
	@Test
	public void Launch_App_1() throws MalformedURLException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		String packageName = driver.getCurrentPackage();
		System.out.println("Current Package: " + packageName);
	    Assert.assertEquals(packageName, "com.androidsample.generalstore", "Package validation failed!");
	}
	
	@Test
	public void Verify_launch_page_Negative_3() throws MalformedURLException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		lp.letsShop();
	}
	
	@Test
	public void Verify_launch_page_Positive_4() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
	}
	
	@Test
	public void Verify_Products_page_Add_to_cart_one_product_5() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Jordan 6 Rings");
	}
	@Test
	public void Verify_Cart_page_Product_Price_6() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		//lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Jordan 6 Rings");
		pp.viewCart();
	}
	
	@Test
	public void Verify_Products_page_Add_to_cart_two_products_7() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		//lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Jordan 6 Rings");
		pp.addToCart("PG 3");
		pp.viewCart();
	}
	
	@Test
	public void Verify_Cart_page_Terms_and_notifications_checkBox_8() throws MalformedURLException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		//lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Jordan 6 Rings");
		pp.addToCart("PG 3");
		pp.viewCart();
		CartPage cp = new CartPage(driver);
		cp.checkTerms();
		cp.checkBox();
	}
	@Test
	public void Verify_HybridApp_9() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		//lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Jordan 6 Rings");
		pp.addToCart("PG 3");
		pp.viewCart();
		CartPage cp = new CartPage(driver);
		cp.visitWebsite();
		Thread.sleep(5000);
		driver.navigate().back();
	}
}
