package StepDefinition;

import Pages.NewAccountPage;
import Pages.ParentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import static Utility.GWD_.getDriver;

public class NewAccount extends ParentPage {

    NewAccountPage page = new NewAccountPage();

    @Given("Navigate to ParaBank")
    public void navigate_to_campus() {
        getDriver().get("https://parabank.parasoft.com/");
    }

    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {
        page.username.sendKeys("telman1123");
        page.password.sendKeys("Tb112357.");
        page.loginButton.click();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        Assert.assertTrue(page.leftPanel.getText().contains("Welcome Admin Test"));
    }

    @And("Navigate to open new account")
    public void navigateToOpenNewAccount() {
        page.openNewAccountLink.click();
    }

    @When("Select Checking as account type")
    public void selectCheckingAsAccountType() {
        WebElement accountTypeDropdown = getDriver().findElement(By.xpath("//*[@id='type']"));
        Select accountTypeSelect = new Select(accountTypeDropdown);
        accountTypeSelect.selectByIndex(0);
    }

    @And("Required initial deposit message should be displayed")
    public void requiredInitialDepositMessageShouldBeDisplayed() {
        Assert.assertTrue(page.minBalanceMessage.getText().contains("minimum"));
    }

    @And("Select an existing account to fund the new account")
    public void selectAnExistingAccountToFundTheNewAccount() {
        WebElement existingAccountDropdown = getDriver().findElement(By.xpath("//*[@id='fromAccountId']"));
        Select existingAccountSelect = new Select(existingAccountDropdown);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[@id='fromAccountId']/option"), 1));
        existingAccountSelect.selectByIndex(0);
    }

    @And("Click the Open New Account button")
    public void clickTheOpenNewAccountButton() {
        page.openNewAccountButton.click();
    }

    @Then("User should see the account creation confirmation and the new account number")
    public void userShouldSeeTheAccountCreationConfirmationAndTheNewAccountNumber() {
        Assert.assertTrue(page.confirmationMessage.isDisplayed());
        Assert.assertTrue(page.accountNumber.isDisplayed());
    }

    @When("Select Saving as account type")
    public void selectSavingAsAccountType() {
        WebElement accountTypeDropdown = getDriver().findElement(By.xpath("//*[@id='type']"));
        Select accountTypeSelect = new Select(accountTypeDropdown);
        accountTypeSelect.selectByIndex(1);
    }
}
