import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artem Mareenkov on 13.12.2016.
 */
public class DragAndDropTest {

    private WebDriver driver;
    private DragAndDropPage dragAndDropPage;
    private SoftAssert softAssert;

    @BeforeTest
    public void beforeTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        dragAndDropPage = new DragAndDropPage(driver);
    }
    @Test
    public void test(){
        dragAndDropPage.open();

    }
    /*@AfterTest
    public void afterTest(){
        driver.quit();
    }*/
}
