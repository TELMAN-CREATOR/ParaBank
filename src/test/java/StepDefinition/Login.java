package StepDefinition;

import Pages.NewAccountPage;
import Pages.ParentPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;


import static Utility.GWD_.getDriver;


public class Login extends ParentPage {
    NewAccountPage dc = new NewAccountPage();

    @Given("Navigate to ParaBank")
    public void navigate_to_campus() {
        getDriver().get("https://parabank.parasoft.com/");
    }

    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {
        dc.username.sendKeys("Team02");
        dc.password.sendKeys("92kteHpxHcnq@");
        dc.loginButton.click();

    }

        }

