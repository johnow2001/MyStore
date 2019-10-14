package PageObjects;

//import java.util.Map;
import java.util.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.DataTable;

public class CreateAccountPage {
    WebDriver driver;

    public CreateAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "page-heading")
    private WebElement pageHeading;

    @FindBy(how = How.ID, using = "id_gender1")
    private WebElement TitleMr;

    @FindBy(how = How.ID, using = "id_gender2")
    private WebElement TitleMrs;

    @FindBy(how = How.ID, using = "customer_firstname")
    private WebElement firstName;

    @FindBy(how = How.ID, using = "customer_lastname")
    private WebElement lastname;

    @FindBy(how = How.ID, using = "email")
    private WebElement email;

    @FindBy(how = How.ID, using = "passwd")
    private WebElement password;

    @FindBy(how = How.ID, using = "days")
    private WebElement dobDays;

    @FindBy(how = How.ID, using = "months")
    private WebElement dobMonths;

    @FindBy(how = How.ID, using = "years")
    private WebElement dobYears;

    @FindBy(how = How.ID, using = "newsletter")
    private WebElement newsletter;

    @FindBy(how = How.ID, using = "optin")
    private WebElement optin;

    @FindBy(how = How.ID, using = "firstname")
    private WebElement addressFirstname;

    @FindBy(how = How.ID, using = "lastname")
    private WebElement addressLastname;

    @FindBy(how = How.ID, using = "company")
    private WebElement company;

    @FindBy(how = How.ID, using = "address1")
    private WebElement addressLine1;

    @FindBy(how = How.ID, using = "address2")
    private WebElement addressLine2;

    @FindBy(how = How.ID, using = "city")
    private WebElement addressCity;

    @FindBy(how = How.ID, using = "id_state")
    private WebElement addressState;

    @FindBy(how = How.ID, using = "postcode")
    private WebElement addressZip;

    @FindBy(how = How.ID, using = "other")
    private WebElement additionalInfo;

    @FindBy(how = How.ID, using = "phone")
    private WebElement homePhone;

    @FindBy(how = How.ID, using = "phone_mobile")
    private WebElement mobilePhone;

    @FindBy(how = How.ID, using = "alias")
    private WebElement addressAlias;

    @FindBy(how = How.ID, using = "submitAccount")
    private WebElement submitAccount;

    public void registerPersonalDetails(DataTable personalDetails) {
        // Just a basic test to see if page has loaded
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBePresentInElement(pageHeading, "CREATE AN ACCOUNT"));




        for (Map<String, String> data : personalDetails.asMaps(String.class, String.class)) {
            String title = data.get("Title");
            if (title.equals("Mr")) {
                TitleMr.click();
            } else if (title.equals("Mrs")) {
                TitleMrs.click();
            }

            firstName.sendKeys(data.get("FN"));
            lastname.sendKeys(data.get("LN"));

            password.sendKeys(data.get("Password"));

            String dob = data.get("DOB");
            if (dob.length() >= 8) {

                String[] dobSplit = dob.split("-");
                Select days = new Select(dobDays);
                days.selectByValue(dobSplit[0]);

                Select month = new Select(dobMonths);
                month.selectByValue(dobSplit[1]);

                Select years = new Select(dobYears);
                years.selectByValue(dobSplit[2]);
            }

            if (data.get("SignUp").equals("yes"))
                newsletter.click();

            if (data.get("Offers").equals("yes"))
                optin.click();

            addressFirstname.clear();
            addressFirstname.sendKeys(data.get("Firstname"));
            addressLastname.clear();
            addressLastname.sendKeys(data.get("Lastname"));

            company.sendKeys(data.get("Company"));
            addressLine1.sendKeys(data.get("Addr1"));
            addressLine2.sendKeys(data.get("Addr2"));
            addressCity.sendKeys(data.get("City"));

            Select state = new Select(addressState);
            state.selectByVisibleText(data.get("State"));

            addressZip.sendKeys(data.get("Zip"));

            additionalInfo.sendKeys(data.get("Additional"));
            homePhone.sendKeys(data.get("Phone"));
            mobilePhone.sendKeys(data.get("Mobile"));

            addressAlias.clear();
            addressAlias.sendKeys(data.get("Alias"));

            submitAccount.click();
        }
    }

}
