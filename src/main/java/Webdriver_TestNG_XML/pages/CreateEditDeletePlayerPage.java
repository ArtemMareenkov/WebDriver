package Webdriver_TestNG_XML.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Artem Mareenkov on 11.12.2016.
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
    public void insertButtonClick(String insert) {
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
        inputEmail.sendKeys(email + "@Yaho.com");
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
    public void saveButtonClick(String save) {
        saveButtonClick.click();
    }
    
    @FindBy(id = "723a925886__login")
    public WebElement inputSearchPlayer;
    public void setSearchEditPlayer(String username) {
      inputSearchPlayer.clear();
      inputSearchPlayer.sendKeys(username);
      driver.findElement(By.name("search")).click();
      driver.findElement(By.xpath(".//tr[.//a[text()='" + username + "']]//img[@alt='Edit']")).click();
    }


    public String getUsernameFieldValue() {
        WebElement usernameFieldElement = driver.findElement(By.id("ff14642ac1c__us_login"));
        String fieldUsername = usernameFieldElement.getText();
        return fieldUsername;
    }

    public String getEmailFieldValue() {
        WebElement emailFieldElement = driver.findElement(By.id("ff14642ac1c__us_email"));
        String emailField = emailFieldElement.getText();
        return emailField;
    }

    public String getFirstNameFielValue() {
        WebElement firstNameFieldElement = driver.findElement(By.id("ff14642ac1c__us_fname"));
        String firstNameField = firstNameFieldElement.getText();
        return firstNameField;
    }

    public String getLastNameFieldValue() {
        WebElement lastNameElement = driver.findElement(By.id("ff14642ac1c__us_lname"));
        String lastNameField = lastNameElement.getText();
        return lastNameField;
    }

    public String getCityFieldValue() {
        WebElement cityFieldElement = driver.findElement(By.id("ff14642ac1c__us_city"));
        String cityField = cityFieldElement.getText();
        return cityField;
    }

    public String getAddressFieldValue() {
        WebElement addressFiedlElenment = driver.findElement(By.id("ff14642ac1c__us_address"));
        String addressField = addressFiedlElenment.getText();
        return addressField;
    }

    public void setSearchDeletePlayer(String username) {
        inputSearchPlayer.clear();
        inputSearchPlayer.sendKeys(username);
        driver.findElement(By.name("search")).click();
        driver.findElement(By.xpath(".//tr[.//a[text()='" + username + "']]//img[@alt='Delete']")).click();
    }

    public void alertPopup() {
        Alert alert = driver.switchTo().alert();
        String alertTest = alert.getText();
        alert.accept();
    }
}
