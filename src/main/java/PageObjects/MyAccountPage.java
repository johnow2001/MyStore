package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
    WebDriver driver;

    public MyAccountPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.ID, using = "search_query_top")
    private WebElement searchBox;

    @FindBy(how = How.NAME, using = "submit_search")
    private WebElement find;

    public void selectDresses() {
        searchBox.clear();
        searchBox.sendKeys("Dresses");
        find.click();
    }

    public int checkCartContents() {
        WebElement numberOfItems = driver.findElement(By.className("ajax_cart_quantity"));
        String number = numberOfItems.getText();
        if (number.length() > 0) {
            return Integer.parseInt(number);
        } else {
            return 0;
        }
    }

}
