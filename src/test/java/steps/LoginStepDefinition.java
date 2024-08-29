package steps;

import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.Database;
import pages.LoginPage;
import pages.TestBase;

public class LoginStepDefinition extends TestBase {
    private LoginPage loginPage;
    private Database database;

    @Before
    public void BeforeRun() {
        initDriver();
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        database = new Database();
    }

    @Given("User in on the codefios login page")
    public void user_in_on_the_codefios_login_page() {
        driver.get("https://codefios.com/ebilling/");
    }

    @Given("User in on the google login page")
    public void user_in_on_the_google_login_page() {
        driver.get("https://google.com/");
    }

    @When("User enters username as {string}")
    public void user_enters_username_as(String username) {
        loginPage.enterUserName(username);
    }

    @When("User enters password as {string}")
    public void user_enters_password_as(String password) {
        loginPage.enterPassword(password);
    }
    
    @When("User enters username as {string} from database")
    public void user_enters_username_as_from_database(String username) {
        loginPage.enterUserName(database.getDataFromDb("user_name"));
        System.out.println("Username from DB: " + database.getDataFromDb("user_name"));
    }

    @When("User enters password as {string} from database")
    public void user_enters_password_as_from_database(String password) {
        loginPage.enterPassword(database.getDataFromDb("user_password"));
        System.out.println("Password from DB: " + database.getDataFromDb("user_password"));
    }


    @When("User enters {string} from database")
    public void user_enters_from_database(String loginData) {
        if (loginData.equalsIgnoreCase("username")) {
            loginPage.enterUserName(database.getDataFromDb("user_name"));
            System.out.println("Username from DB: " + database.getDataFromDb("user_name"));
        } else if (loginData.equalsIgnoreCase("password")) {
            loginPage.enterPassword(database.getDataFromDb("user_password"));
            System.out.println("Password from DB: " + database.getDataFromDb("user_password"));
        } else {
            System.out.println("Unable to retrieve login data!");
        }
    }

    @But("User clicks on the Sign in button")
    public void user_clicks_on_the_Sign_in_button() {
        loginPage.clickSigninButton();
    }

    @Then("User lands on dashboard page")
    public void user_lands_on_dashboard_page() {
        takeScreenshot(driver);
        String expectedTitle = "Codefios";
        String actualTitle = loginPage.getPageTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
//    }
//
//    @After
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
    }
}

