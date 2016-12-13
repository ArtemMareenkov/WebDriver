package DragAndDrop;

import DragAndDrop.DragAndDropPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
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
       // softAssert = new SoftAssert();
    }

    @Test
    public void undeleteNumberTest(){
        dragAndDropPage.open();
        dragAndDropPage.numberInTrash();
        dragAndDropPage.popupAlertDismiss();

    }

    @Test
    public void deleteNemberTest(){
        dragAndDropPage.open();
        dragAndDropPage.numberInTrash();
        dragAndDropPage.popupAlertAccept();
    }

    @Test
    public void numberSortAscending(){
        dragAndDropPage.open();
        dragAndDropPage.ascendingSort();

    }

    @Test
    public void numberSortDescending(){
        dragAndDropPage.open();
        dragAndDropPage.descendingSort();

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }
}
