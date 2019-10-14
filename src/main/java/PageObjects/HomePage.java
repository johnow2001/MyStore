package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = "login")
    private WebElement login_button;

    public void goToHomepage(String Url) {
        driver.get(Url);
    }

    public void clickLogin() {
        login_button.click();
    }

}
