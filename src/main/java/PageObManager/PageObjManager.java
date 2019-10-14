package PageObManager;

import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import PageObjects.MyAccountPage;
import PageObjects.CreateAccountPage;
import PageObjects.DressPage;
import PageObjects.HomePage;
import org.openqa.selenium.WebDriver;

public class PageObjManager {

    private WebDriver driver;
    private HomePage homePage;
    private LoginPage loginPage;
    private CreateAccountPage accountPage;
    private MyAccountPage myAccount;
    private DressPage dressPage;

    public PageObjManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage(driver);
            return homePage;
        } else {
            return homePage;
        }
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
            return loginPage;
        } else {
            return loginPage;
        }

    }

    public CreateAccountPage getCreateAccountpage() {
        if (accountPage == null) {
            accountPage = new CreateAccountPage(driver);
            return accountPage;
        } else {
            return accountPage;
        }

    }

    public MyAccountPage getMyAccountPage() {
        if (myAccount == null) {
            myAccount = new MyAccountPage(driver);
            return myAccount;
        } else {
            return myAccount;
        }

    }

    public DressPage getDressPage() {
        if (dressPage == null) {
            dressPage = new DressPage(driver);
            return dressPage;
        } else {
            return dressPage;
        }

    }

}
