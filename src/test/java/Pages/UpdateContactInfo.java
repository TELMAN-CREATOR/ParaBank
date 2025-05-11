package Pages;
import Utility.GWD_;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateContactInfo {
    public UpdateContactInfo() {
        PageFactory.initElements(GWD_.getDriver(), this);
    }
    @FindBy(css = "[name='customer.firstName']")
    public WebElement firstName;

    @FindBy(css = "[name='customer.lastName']")
    public WebElement lastName;

    @FindBy(css = "[name='customer.address.street']")
    public WebElement address;

    @FindBy(css = "[name='customer.address.city']")
    public WebElement city;

    @FindBy(css = "[name='customer.address.state']")
    public WebElement state;

    @FindBy(css = "[name='customer.address.zipCode']")
    public WebElement zipCode;

    @FindBy(css = "[name='customer.phoneNumber']")
    public WebElement phone;

    @FindBy(css = "[value='Update Profile']")
    public WebElement updateProfileButton;

    @FindBy(xpath = "//*[contains(text(),'Profile Updated Successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//*[contains(text(),'This field is required')]")
    public WebElement errorMessage;

    // Logout & Login Controls (optional)
    @FindBy(linkText = "Log Out")
    public WebElement logout;

    @FindBy(linkText = "Update Contact Info")
    public WebElement updateContactInfoLink;

    @FindBy(xpath = "//*[contains(text(),'Customer Information Updated')]")
    public WebElement updateConfirmation;
}

