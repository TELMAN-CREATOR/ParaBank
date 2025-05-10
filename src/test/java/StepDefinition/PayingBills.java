package StepDefinition;



import Pages.ParentPage;
import Pages.PayingBillPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static Utility.GWD_.getDriver;

public class PayingBills extends ParentPage {

   PayingBillPage page=new PayingBillPage();
    @Given("Navigate to ParaBank site")
    public void navigate_to_campus() {
        getDriver().get("https://parabank.parasoft.com/");
    }

    @When("Enter username and password and click login button.")
    public void enter_username_and_password_and_click_login_button() {
        page.username.sendKeys("telman1123");
        page.password.sendKeys("Tb112357.");
        page.loginButton.click();
    }

    @Then("User should login successfully.")
    public void userShouldLoginSuccessfully() {
       // Assert.assertTrue(page.loginControl.getText().contains("Welcome Admin Test"));
    }

    @Then("Navigate to paying bill")
    public void navigate_to_paying_bill() {
        page.billPay.click();

    }
    @When("Enter pay information")
    public void enter_pay_information() {
        page.payeName.sendKeys("Enerjisa Elektrik Faturası");
        page.payeAdress.sendKeys("AZE");
        page.payeAdressCity.sendKeys("ŞEM");
        page.payeAdressState.sendKeys("ŞEM");
        page.payezipCode.sendKeys("0057");
        page.payeNumber.sendKeys("05031749583");
        page.accountNumber.sendKeys("74035");
        page.verifyAccount.sendKeys("74035");
        page.amount.sendKeys("100");
    }
    @And("Send the payment")
    public void send_the_payment() {
        page.sendPayment.click();
    }

    @Then("Verify sending")
    public void verifySending() {
        wait.until(ExpectedConditions.textToBePresentInElement(page.confirmationMessage,"Bill Payment Complete"));
        System.out.println(page.confirmationMessage.getText().contains("Bill Payment Complete"));
        Assert.assertTrue(page.confirmationMessage.isDisplayed());
    }

    @When("Enter pay information su")
    public void enterPayInformation() {
        page.payeName.sendKeys("Enerjisa SU Faturası");
        page.payeAdress.sendKeys("AZE");
        page.payeAdressCity.sendKeys("ŞEM");
        page.payeAdressState.sendKeys("ŞEM");
        page.payezipCode.sendKeys("0057");
        page.payeNumber.sendKeys("05031749583");
        page.accountNumber.sendKeys("74035");
        page.verifyAccount.sendKeys("74035");
        page.amount.sendKeys("100");
    }

    @When("Enter pay information doğal gaz")
    public void enterPayInformationDoğalGaz() {
        page.payeName.sendKeys("Enerjisa Doğal Gaz Faturası");
        page.payeAdress.sendKeys("AZE");
        page.payeAdressCity.sendKeys("ŞEM");
        page.payeAdressState.sendKeys("ŞEM");
        page.payezipCode.sendKeys("0057");
        page.payeNumber.sendKeys("05031749583");
        page.accountNumber.sendKeys("74035");
        page.verifyAccount.sendKeys("74035");
        page.amount.sendKeys("100");
    }
}
