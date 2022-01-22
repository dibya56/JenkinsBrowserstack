package stepDefinition;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;

public class stepDefinition {

	AndroidDriver<WebElement> driver = null;
	
	@Given("User launch the appliation")
	public void user_launch_the_appliation() throws MalformedURLException {
	    // Write code here that turns the phrase above into concrete actions
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "Android Emulator");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "9.0");
		cap.setCapability("appPackage", "com.whatsapp");
		cap.setCapability("appActivity", "com.whatsapp.HomeActivity");
		
		driver =  new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("User tap on aggree and continue CTA")
	public void user_tap_on_aggree_and_continue_cta() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id("eula_accept")).click();
	}

	@Then("User navigates to registration page")
	public void user_navigates_to_registration_page() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(driver.findElement(By.id("register_phone_toolbar_title")).getText(), "Enter your phone number");
	}
}
