package Pages;

import Utility.GWD_;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewAccountPage {

    public NewAccountPage() {
        PageFactory.initElements(GWD_.getDriver(), this);
    }

    @FindBy(css = "[name='username']")
    public WebElement username;

    @FindBy(css = "[name='password']")
    public WebElement password;

    @FindBy(css = "[value='Log In']")
    public WebElement loginButton;

    @FindBy(css = "[class='smallText']")
    public WebElement leftPanel;        //isim değiştir

    @FindBy(linkText = "Open New Account")
    public WebElement openNewAccountLink;

    @FindBy(xpath = "(//*[@id='openAccountForm']/form/p)[2]")
    public WebElement minBalanceMessage;

    @FindBy(css = "[value='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(css = "//*[contains(text(),'Account Opened!')]")
    public WebElement confirmationMessage;

    @FindBy(css = "[id='newAccountId']")
    public WebElement accountNumber;
}
