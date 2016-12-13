package DragAndDrop;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.io.FileReader;

/**
 * Created by Artem Mareenkov on 13.12.2016.
 */
public class DragAndDropPage {

    private WebDriver driver;
    private static String URL = "D:\\Users\\artem\\Documents\\Documents\\Education\\Idea Project\\WebDriver\\file_for_drag_and_drop\\index.html";

    public DragAndDropPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void open(){driver.get(URL);
    }

    @FindBy(xpath = ".//li[contains(text(),'7')]")
    private WebElement sourceElement;

    @FindBy(id = "drop")
    private WebElement targetElement;
    public void numberInTrash() {
        Actions action = new Actions(driver);
        action.dragAndDrop(sourceElement,targetElement).perform();
    }

    public void popupAlertDismiss() {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }

    public void popupAlertAccept() {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }

    @FindBy(xpath = ".//li[contains(text(),'1')]")
    private WebElement boxNumberOne;
    @FindBy(xpath= ".//li[contains(text(),'2')]")
    private  WebElement boxNumberTwo;
    @FindBy(xpath = ".//li[contains(text(),'3')]")
    private WebElement boxNumberThree;
    @FindBy(xpath = ".//li[contains(text(),'4')]")
    private WebElement boxNumberFour;
    @FindBy(xpath = ".//li[contains(text(),'5')]")
    private WebElement boxNumberFive;
    @FindBy(xpath = ".//li[contains(text(),'6')]")
    private WebElement boxNumberSix;
    @FindBy(xpath = ".//li[contains(text(),'7')]")
    private WebElement boxNumberSeven;

    @FindBy(xpath = ".//li[1]")
    private WebElement firstPosition;
    @FindBy(xpath = ".//li[2]")
    private WebElement secondPosition;
    @FindBy(xpath = ".//li[3]")
    private WebElement thirdPosition;
    @FindBy(xpath = "//li[4]")
    private WebElement fourthPosition;
    @FindBy(xpath = "//li[5]")
    private WebElement fifthPosition;
    @FindBy(xpath = "//li[6]")
    private WebElement sixthPosition;
    @FindBy(xpath = "//li[7]")
    private WebElement seventhPosition;

    public void ascendingSort() {
        Actions action = new Actions(driver);
        action.dragAndDrop(boxNumberOne,firstPosition).perform();
        action.dragAndDrop(boxNumberTwo,secondPosition).perform();
        action.dragAndDrop(boxNumberThree,thirdPosition).perform();
        action.dragAndDrop(boxNumberFour,fourthPosition).perform();
        action.dragAndDrop(boxNumberFive,fifthPosition).perform();
        action.dragAndDrop(boxNumberSix,sixthPosition).perform();
        action.dragAndDrop(boxNumberSeven,seventhPosition).perform();
    }

    public void descendingSort() {
        Actions action = new Actions(driver);
        action.dragAndDrop(boxNumberSeven,firstPosition).perform();
        action.dragAndDrop(boxNumberSix,secondPosition).perform();
        action.dragAndDrop(boxNumberFive,thirdPosition).perform();
        action.dragAndDrop(boxNumberFour,fourthPosition).perform();
        action.dragAndDrop(boxNumberThree,fifthPosition).perform();
        action.dragAndDrop(boxNumberTwo,sixthPosition).perform();
        action.dragAndDrop(boxNumberOne,seventhPosition).perform();
    }
}


