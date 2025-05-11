package StepDefinition;
import Pages.UpdateContactInfoPage;
import Pages.ParentPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static Utility.GWD_.getDriver;

public class UpdateContentInfo extends ParentPage {

    UpdateContactInfoPage page = new UpdateContactInfoPage();

    @Given("The user is logged in and on the Update Profile page")
    public void theUserIsLoggedInAndOnTheUpdateProfilePage() {
        getDriver().get("https://parabank.parasoft.com/");
        page.username.sendKeys("telman1123");
        page.password.sendKeys("Tb112357.");
        page.loginButton.click();


        wait.until(ExpectedConditions.visibilityOf(page.updateContactInfoLink));
        page.updateContactInfoLink.click();
    }

    @When("The user fills in valid contact details")
    public void theUserFillsInValidContactDetails(io.cucumber.datatable.DataTable dataTable) {
        var data = dataTable.asMap(String.class, String.class);
        page.firstName.clear();         page.firstName.sendKeys(data.get("First Name"));
        page.lastName.clear();          page.lastName.sendKeys(data.get("Last Name"));
        page.address.clear();           page.address.sendKeys(data.get("Address"));
        page.city.clear();              page.city.sendKeys(data.get("City"));
        page.state.clear();             page.state.sendKeys(data.get("State"));
        page.zipCode.clear();           page.zipCode.sendKeys(data.get("Zip Code"));
        page.phone.clear();             page.phone.sendKeys(data.get("Phone Number"));
    }

    @And("Clicks the {string} button")
    public void clicksTheButton(String buttonText) {

        page.updateProfileButton.click();
    }

    @Then("A success message should be displayed")
    public void aSuccessMessageShouldBeDisplayed() {
        wait.until(ExpectedConditions.visibilityOf(page.successMessage));
        Assert.assertTrue(page.successMessage.getText().toLowerCase().contains("success"));
    }

    @And("The user logs out and logs back in")
    public void theUserLogsOutAndLogsBackIn() {
        page.logout.click();
        page.username.sendKeys("telman1123");
        page.password.sendKeys("Tb112357.");
        page.loginButton.click();
        page.updateContactInfoLink.click();
    }

    @Then("The updated contact information should be visible and correct")
    public void theUpdatedContactInformationShouldBeVisibleAndCorrect() {

        Assert.assertFalse(page.firstName.getAttribute("value").isBlank());
        Assert.assertFalse(page.address.getAttribute("value").isBlank());
    }

    @When("The user clears the following fields")
    public void theUserClearsTheFollowingFields(io.cucumber.datatable.DataTable dataTable) {
        for (String field : dataTable.asList()) {
            switch (field) {
                case "First Name": page.firstName.clear(); break;
                case "Last Name": page.lastName.clear(); break;
                case "Address": page.address.clear(); break;
                case "City": page.city.clear(); break;
                case "State": page.state.clear(); break;
                case "Zip Code": page.zipCode.clear(); break;
                case "Phone Number": page.phone.clear(); break;
            }
        }
    }

    @Then("Validation error messages should be displayed for the empty fields")
    public void validationErrorMessagesShouldBeDisplayedForTheEmptyFields() {
        wait.until(ExpectedConditions.visibilityOf(page.errorMessage));
        Assert.assertTrue(page.errorMessage.isDisplayed());
    }

    @Then("No changes should be saved on the profile")
    public void noChangesShouldBeSavedOnTheProfile() {

        Assert.assertFalse(page.successMessage.isDisplayed());
    }
}

