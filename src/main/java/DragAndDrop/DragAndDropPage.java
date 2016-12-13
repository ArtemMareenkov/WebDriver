import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileReader;

/**
 * Created by artem on 13.12.2016.
 */
public class DragAndDropPage {

    private WebDriver driver;
    private static String URL = "D:\\Users\\artem\\Documents\\Documents\\Education\\Idea Project\\DragAndDrop\\file_for_drag_and_drop\\index.html";

    public DragAndDropPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void open(){driver.get(URL);}
}
