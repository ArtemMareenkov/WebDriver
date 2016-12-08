package WebDriverWithTestNG.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by artem on 08.12.2016.
 */
public class EditPlayerPage extends CreatePlayerPage {
    private WebDriver driver;


    public EditPlayerPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

    public void setPlayerSearch(String value) {
        WebElement inputPlayerSearchFieldValue = driver.findElement(By.id("723a925886__login"));
        inputPlayerSearchFieldValue.clear();
        inputPlayerSearchFieldValue.sendKeys(value);
        driver.findElement(By.name("search")).click(); //search button click
        driver.findElement(By.xpath(".//tr[.//a[text()='" + value + "']]/img[@alt='Edit']")).click(); //edit user button click
    }
}
