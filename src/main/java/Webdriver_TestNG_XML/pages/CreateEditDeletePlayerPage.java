package Webdriver_TestNG_XML.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by artem on 11.12.2016.
 */
public class CreateEditDeletePlayerPage {

    private WebDriver driver;
    private static final String URL = "http://80.92.229.236:81/auth/login";

    public CreateEditDeletePlayerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get(URL);
    }

    public void setUsername(String value) {
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.clear();
        usernameInput.sendKeys(value);
    }

    public void setPassoword(String value) {
        WebElement passwordInput = driver.findElement(By.id("password"));
        passwordInput.clear();
        passwordInput.sendKeys(value);
    }

    public void loginButtonClick() {
        driver.findElement(By.id("logIn")).click();
    }

    @FindBy (xpath = ".//a[@href='http://80.92.229.236:81/players/insert']/img")
    private WebElement insertButton;
    public void insertButtonClick() {
        insertButton.click();
    }

    @FindBy(id="ff14642ac1c__us_login")
    private WebElement inputUsername;
    public void setUsernameValue(String username) {
        inputUsername.clear();
        inputUsername.sendKeys(username);
    }
   @FindBy(id="ff14642ac1c__us_email")
   WebElement inputEmail;
    public void setEmailValue(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
    }

    @FindBy(id = "ff14642ac1c__us_password")
    private WebElement inputPassword;
    public void setPasswordValue(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
    }
    @FindBy(id = "ff14642ac1c__confirm_password")
    private WebElement inputConfirmPassword;
    public void setConfirmPasswordValue(String confirmpassword) {
        inputConfirmPassword.clear();
        inputConfirmPassword.sendKeys(confirmpassword);
    }

    @FindBy(id="ff14642ac1c__us_fname")
    private WebElement inputFirstName;
    public void setFirstNameValue(String firstname) {
        inputFirstName.clear();
        inputFirstName.sendKeys(firstname);
    }

    @FindBy(id="ff14642ac1c__us_lname")
    private WebElement inputLastName;
    public void setLastNameValue(String lastname) {
        inputLastName.clear();
        inputLastName.sendKeys(lastname);
    }

    @FindBy(id="ff14642ac1c__us_city")
    private WebElement inputCity;
    public void setCityValue(String city) {
        inputCity.clear();
        inputCity.sendKeys(city);
    }

    @FindBy(id="ff14642ac1c__us_address")
    private WebElement inputAddress;
    public void setAddressValue(String address) {
        inputAddress.clear();
        inputAddress.sendKeys(address);
    }

    @FindBy(id="ff14642ac1c__us_phone")
    private WebElement inputPhone;
    public void setPhoneValue(String phone) {
        inputPhone.clear();
        inputPhone.sendKeys(phone);
    }
   @FindBy(xpath = ".//input[@name='button_save']")
    private WebElement saveButtonClick;
    public void saveButtonClick() {
        saveButtonClick.click();
    }
}
