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

}
