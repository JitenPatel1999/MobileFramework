package Base;

import java.awt.Point;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.PointerInput.Kind;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Base_Page extends Base_Test{
	
	public Base_Page(AppiumDriver driver) {
		
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	public static void enterText(WebElement wb, String textbox, String message) {
		wb.sendKeys(message);
		System.out.println("Text has been entered into "+textbox+".");
	}
	
	public static void tap(WebElement wb, String button) {
		Actions action = new Actions(driver);
		action.moveToElement(wb).click().perform();
		System.out.println(button+ " has been tapped.");
	}
	
	public static void doubleTap(WebElement wb, String button) {
		Actions action = new Actions(driver);
		action.moveToElement(wb).doubleClick(wb).perform();
		System.out.println(button+" has been double tapped.");
	}
	
	public static void longPress(WebElement wb, String element) {
		 int x = wb.getLocation().getX() + (wb.getSize().getWidth() / 2);
		 int y = wb.getLocation().getY() + (wb.getSize().getHeight() / 2);
		System.out.println("X: "+x+" and Y: "+y);
		PointerInput finger = new PointerInput(Kind.TOUCH, "finger");
		Point tapPoint = new Point(x, y);
		Sequence tap = new Sequence(finger, 1);
		tap.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(),tapPoint.x, tapPoint.y));
		tap.addAction(finger.createPointerDown(0));
		tap.addAction(new Pause(finger, Duration.ofSeconds(5)));
		tap.addAction(finger.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
	}
	public static WebElement scrollTo(String option) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement wb = driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(text(\"" + option + "\"));"));
		wait.until(ExpectedConditions.visibilityOf(wb));
		System.out.println(option+" has been scrolled to.");
		return wb;
	}
}
