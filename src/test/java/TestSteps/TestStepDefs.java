package TestSteps;

import static org.junit.Assert.*;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import HelpUtility.Helper;
import PageObManager.PageObjManager;
import PageObjects.*;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import dataReader.ConfigReader;
import cucumber.api.java.en.Then;

public class TestStepDefs {

    private WebDriver driver;
    private String url;
    private PageObjManager mgr;
    private HomePage homePage;
    private LoginPage loginPage;
    private CreateAccountPage detailsPage;
    private MyAccountPage myAccount;
    private DressPage dressPage;

    @Before
    public void before() {
        ConfigReader reader = new ConfigReader();
        System.setProperty("webdriver.chrome.driver", reader.GetWebDriverPath());
        url = reader.getHomePage();

        // would be better in its own manager so can cross browser test
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("^I am on the mystore home page$")
    public void goToHomepage() {
        mgr = new PageObjManager(driver);
        homePage = mgr.getHomePage();
        homePage.goToHomepage(url);
    }

    @When("^I click on sign in$")
    public void signIn() {
        homePage.clickLogin();
    }

    @When("^I create and account with my email address$")
    public void selectCreateAccount() {
        Helper help = new Helper();
        String email = help.generateRandomEmail();
        loginPage = mgr.getLoginPage();
        loginPage.createAccount(email);
    }

    @When("^I enter \"([^\"]*)\" with \"([^\"]*)\"$")
    public void signInAsregistered(String email, String pwd) {
        loginPage = mgr.getLoginPage();
        loginPage.signIn(email, pwd);
    }

    @When("^register personal information$")
    public void createAccountInformation(DataTable details) {
        detailsPage = mgr.getCreateAccountpage();
        detailsPage.registerPersonalDetails(details);
    }

    @When("^I click on Dresses$")
    public void selectDresses() {
        myAccount = mgr.getMyAccountPage();
        myAccount.selectDresses();
    }

    @When("^I find the most expensive dress expected to be \"([^\"]*)\" add to cart$")
    public void findMostExpensive(String expValue) {
        dressPage = mgr.getDressPage();
        String foundExpensive = dressPage.findMostExpensive();

        if (expValue.equals(foundExpensive)) {
            dressPage.addToCart();
        } else {
            fail("unexpectd highest price found");
        }
    }

    @Then("^The cart displays added item$")
    public void verifyCart() {
        myAccount = mgr.getMyAccountPage();
        int cartContent = myAccount.checkCartContents();
        assertTrue(cartContent > 0);
    }

    @Then("^I log out$")
    public void logOut() {
        driver.findElement(By.className("logout")).click();
    }

    @Then("^I should be on the \"([^\"]*)\" page$")
    public void checkOnCorrectPage(String pageTitle) {
        assertEquals(pageTitle, driver.getTitle());
    }

    @After
        public void after() {
            driver.quit();
    }

}
