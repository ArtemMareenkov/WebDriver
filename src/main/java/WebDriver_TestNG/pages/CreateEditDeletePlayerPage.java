package WebDriver_TestNG.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Artem Mareenkov on 06.12.2016.
 */
public class CreateEditDeletePlayerPage {


    private WebDriver driver;
    public static final String URL = "http://80.92.229.236:81/auth/login";

    public CreateEditDeletePlayerPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(URL);
    }

    public void setLoginUsername(String value){
        WebElement inputLogin = driver.findElement(By.id("username"));
        inputLogin.clear();
        inputLogin.sendKeys(value);
    }

    public void setLoginPassword(String value) {
        WebElement inputPassword = driver.findElement(By.id("password"));
        inputPassword.clear();
        inputPassword.sendKeys(value);
    }

    public void logIn() {
        WebElement loginButtonClick = driver.findElement(By.id("logIn"));
        loginButtonClick.click();
    }

    public void insertButtonClick() {
         driver.findElement(By.xpath(".//a[@href='http://80.92.229.236:81/players/insert']/img")).click();
    }

    public void setUsername(String value) {
        WebElement inputUsername = driver.findElement(By.id("ff14642ac1c__us_login"));
        inputUsername.clear();
        inputUsername.sendKeys(value);

    }

    public void setPassword(String value) {
        WebElement inputUserPassword = driver.findElement(By.id("ff14642ac1c__us_password"));
        inputUserPassword.clear();
        inputUserPassword.sendKeys(value);
    }

    public void setConfirmPassword(String value) {
        WebElement inputUserPasswordConfirm = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        inputUserPasswordConfirm.clear();
        inputUserPasswordConfirm.sendKeys(value);
    }

    public void setEmail(String value) {
        WebElement inputUserEmail = driver.findElement(By.id("ff14642ac1c__us_email"));
        inputUserEmail.clear();
        inputUserEmail.sendKeys(value);
    }

    public void setFirstName(String value) {
        WebElement inputFirstName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        inputFirstName.clear();
        inputFirstName.sendKeys(value);
    }

    public void setLastName(String value) {
        WebElement inputLastName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        inputLastName.clear();
        inputLastName.sendKeys(value);
    }

    public void setCity(String value) {
        WebElement inputCity = driver.findElement(By.id("ff14642ac1c__us_city"));
        inputCity.clear();
        inputCity.sendKeys(value);
    }

    public void setAddress(String value) {
        WebElement inputAddress = driver.findElement(By.id("ff14642ac1c__us_address"));
        inputAddress.clear();
        inputAddress.sendKeys(value);
    }

    public void setPhone(String value) {
        WebElement inputPhone = driver.findElement(By.id("ff14642ac1c__us_phone"));
        inputPhone.sendKeys(value);
    }

    public void saveButtonClick() {
        WebElement clickSaveButton = driver.findElement(By.xpath(".//input[@name='button_save']"));
        clickSaveButton.click();
    }

    public void setPlayerSearchEdit(String value) {
        WebElement inputPlayerSearchFieldValue = driver.findElement(By.id("723a925886__login"));
        inputPlayerSearchFieldValue.clear();
        inputPlayerSearchFieldValue.sendKeys(value);
        driver.findElement(By.name("search")).click(); //search button click
        driver.findElement(By.xpath(".//tr[.//a[text()='" + value + "']]/img[@alt='Edit']")).click();
    }

    public String getUsernameFieldValue() {
        WebElement usernameFieldValue = driver.findElement(By.id("ff14642ac1c__us_login"));
        return usernameFieldValue.getText();
    }

    public String getEmailFieldValue() {
       WebElement emailFieldValue = driver.findElement(By.id("ff14642ac1c__us_email"));
       return emailFieldValue.getText();
    }

    public String getFirstNameFieldValue() {
        WebElement firstNameFieldValue = driver.findElement(By.id("ff14642ac1c__us_fname"));
        return firstNameFieldValue.getText();
    }

    public String getLastNameFieldValue() {
        WebElement lastNameFieldValue = driver.findElement(By.id("ff14642ac1c__us_lname"));
        return lastNameFieldValue.getText();
    }

    public String getCityFieldValue() {
        WebElement cityFieldValue = driver.findElement(By.id("ff14642ac1c__us_city"));
        return cityFieldValue.getText();
    }

    public String getAddressFieldValue() {
        WebElement addressFieldValue = driver.findElement(By.id("ff14642ac1c__us_address"));
        return addressFieldValue.getText();
    }

    public String getPhoneFieldValue() {
        WebElement phoneFieldValue = driver.findElement(By.id("ff14642ac1c__us_phone"));
        return phoneFieldValue.getText();
    }

    public void cancelButtonClick() {
        driver.findElement(By.name("button_cancel")).click();
    }

     public void setPlayerSearchDelete(String value) {
         WebElement inputPlayerSearchFieldValue = driver.findElement(By.id("723a925886__login"));
         inputPlayerSearchFieldValue.clear();
         inputPlayerSearchFieldValue.sendKeys(value);
         driver.findElement(By.name("search")).click(); //search button click
         driver.findElement(By.xpath(".//tr[.//a[text()='" + value + "']]/img[@alt='Delete']")).click();

    }
}




