package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	// Element Library

	@FindBy(how = How.XPATH, using = "//input[@id='user_name']")
	WebElement UserName;

	@FindBy(how = How.XPATH, using = "//input[@id='password']")
	WebElement Password;

	@FindBy(how = How.XPATH, using = "//button[@id='login_submit']")
	WebElement SignInButton;

	// Methods to interact with the elements.
	public void enterUserName(String userName) {
		UserName.sendKeys(userName);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void enterPassword(String password) {
		Password.sendKeys(password);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickSigninButton() {
		SignInButton.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

}
