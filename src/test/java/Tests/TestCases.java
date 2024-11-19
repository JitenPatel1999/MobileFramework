package Tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.Base_Test;
import Pages.CartPage;
import Pages.LaunchPage;
import Pages.ProductsPage;
import io.appium.java_client.AppiumBy;
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
	public void Verify_launch_page_fields_2() throws MalformedURLException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		Assert.assertEquals(lp.getTitle(), "General Store", "Title validation failed!");
		System.out.println("Title validation passed!");
		Assert.assertEquals(lp.getNameField(), "Enter name here", "NameField validation failed!");
		System.out.println("NameField validation passed!");
		Assert.assertEquals(lp.getSelectorTitle(), "Select the country where you want to shop" ,"SelectorTitle validation failed!");
		System.out.println("SelectorTitle validation passed!");
		Assert.assertEquals(lp.getCountry(), "Afghanistan", "Country validation failed!");
		System.out.println("Country validation passed!");
		Assert.assertEquals(lp.getMale(), "Male", "Male validation failed!");
		System.out.println("Male validation passed!");
		Assert.assertEquals(lp.getFemale(), "Female", "Female validation failed!");
		System.out.println("Female validation passed!");
		Assert.assertEquals(lp.getLetsShop(), "Let's  Shop", "Let's Shop validation failed!");
		System.out.println("Let's Shop validation passed!");
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
		//lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
		ProductsPage pp = new ProductsPage(driver);
		Assert.assertEquals(lp.getTitle(), "Products", "Title validation failed!");
		System.out.println("Title validation passed!");
		pp.addToCart("Jordan 6 Rings");
		String shoename = pp.getShoeName("Jordan 6 Rings");
		Assert.assertEquals(shoename, "Jordan 6 Rings", "Shoe name validation failed!");
		System.out.println("Shoe name validation passed!");
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
		String shoePrice = pp.getShoePrice("$165.0");
		pp.viewCart();
		CartPage cp = new CartPage(driver);
		Assert.assertEquals(cp.getTitle(), "Cart", "Title validation failed!");
		System.out.println("Title validation passed!");
		Assert.assertEquals(shoePrice, cp.getTotalPrice(), "Price validation failed!");
		System.out.println("Price validation passed!");
	}
	
	@Test
	public void Verify_Products_page_Add_to_cart_two_products_7() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		lp.countrySelect("India");
		lp.enterName("Your Name");
		lp.selectFemale();
		lp.letsShop();
		ProductsPage pp = new ProductsPage(driver);
		pp.addToCart("Jordan 6 Rings");
		pp.addToCart("PG 3");
		String totalOf2 = "$275.0";
		pp.viewCart();
		CartPage cp = new CartPage(driver);
		Assert.assertEquals(cp.getTitle(), "Cart", "Title validation failed!");
		System.out.println("Title validation passed!");
		Assert.assertEquals(totalOf2, cp.getTotalPrice(), "Price validation failed!");
		System.out.println("Price validation passed!");
	}
	
	@Test
	public void Verify_Cart_page_Terms_and_notifications_checkBox_8() throws MalformedURLException, InterruptedException {
		AndroidDriver driver = (AndroidDriver) getDriver();
		LaunchPage lp = new LaunchPage(driver);
		lp.countrySelect("India");
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
		lp.countrySelect("India");
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
