package Pages;

import Utility.GWD_;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PayingBillPage {
    public PayingBillPage() {
        PageFactory.initElements(GWD_.getDriver(), this);
    }

    @FindBy(css = "[name='username']")
    public WebElement username;

    @FindBy(css = "[name='password']")
    public WebElement password;

    @FindBy(css = "[value='Log In']")
    public WebElement loginButton;

    @FindBy(css = "[class='smallText']")
    public WebElement loginControl;

    @FindBy(linkText = "Bill Pay")
    public WebElement billPay;

    @FindBy(css = "[name='payee.name']")
    public WebElement payeName;

    @FindBy(css = "[name='payee.address.street']")
    public WebElement payeAdress;

    @FindBy(css = "[name='payee.address.city']")
    public WebElement payeAdressCity;

    @FindBy(css = "[name='payee.address.state']")
    public WebElement payeAdressState;

    @FindBy(css = "[name='payee.phoneNumber']")
    public WebElement payeNumber;

    @FindBy(css = "[name='payee.accountNumber']")
    public WebElement accountNumber;

    @FindBy(css = "[name='amount']")
    public  WebElement amount;

    @FindBy(css = "[name='verifyAccount']")
    public WebElement verifyAccount;

    @FindBy(css = "[name='payee.address.zipCode']")
    public WebElement payezipCode;

    @FindBy(css = "[value='Send Payment']")
    public WebElement sendPayment;

    @FindBy(xpath = "//*[contains(text(),'Bill Payment Complete')]")
    public WebElement confirmationMessage;


}
