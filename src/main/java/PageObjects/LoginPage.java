package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "email_create")
    private WebElement emailAddressText;

    @FindBy(how = How.ID, using = "SubmitCreate")
    private WebElement createAccount;

    @FindBy(how = How.ID, using = "email")
    private WebElement registeredEmail;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement passwordText;

    @FindBy(how = How.ID, using = "SubmitLogin")
    private WebElement signIn;

    public void createAccount(String email) {
        emailAddressText.sendKeys(email);
        createAccount.click();
    }

    public void signIn(String email, String pwd) {
        registeredEmail.sendKeys(email);
        passwordText.sendKeys(pwd);
        signIn.click();
    }
}
