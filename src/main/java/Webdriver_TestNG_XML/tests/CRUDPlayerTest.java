package Webdriver_TestNG_XML.tests;

import Webdriver_TestNG_XML.pages.CreateEditDeletePlayerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

/**
 * Created by artem on 11.12.2016.
 */
public class CRUDPlayerTest {

    private static WebDriver driver;
    private  static CreateEditDeletePlayerPage createEditDeletePlayerPage;
    private SoftAssert softAssert;
    String username = RandomStringUtils.random(8, true, true);
    String email = RandomStringUtils.random(10,true,true);
    String password = RandomStringUtils.random(10, true, true);
    String confirmpassword = password;
    String firstname =RandomStringUtils.random(7,true,false);
    String lastname = RandomStringUtils.random(8,true,false);
    String city = RandomStringUtils.random(7,true,false);
    String address = RandomStringUtils.random(9,true,true);
    String phone = RandomStringUtils.random(11,false,true);


    @BeforeTest
    public void beforTest(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        createEditDeletePlayerPage = new CreateEditDeletePlayerPage(driver);
        createEditDeletePlayerPage.open();
        createEditDeletePlayerPage.setUsername("admin");
        createEditDeletePlayerPage.setPassoword("123");
        createEditDeletePlayerPage.loginButtonClick();
        softAssert = new SoftAssert();
        }

    @DataProvider
    public Object[][] createUserData() {
        return new Object[][]{
                {"insert",username, email, password, confirmpassword,firstname,lastname,city,address,phone, "Save"}
        };
    }
    @Test (dataProvider = "creataUserData")
    public void createPlayerTest(String username, String email, String password, String confirmpassword,  String firstname, String lastname, String city, String address, String phone){
        createEditDeletePlayerPage.insertButtonClick();
        createEditDeletePlayerPage.setUsernameValue(username);
        createEditDeletePlayerPage.setEmailValue(email);
        createEditDeletePlayerPage.setPasswordValue(password);
        createEditDeletePlayerPage.setConfirmPasswordValue(confirmpassword);
        createEditDeletePlayerPage.setFirstNameValue(firstname);
        createEditDeletePlayerPage.setLastNameValue(lastname);
        createEditDeletePlayerPage.setCityValue(city);
        createEditDeletePlayerPage.setAddressValue(address);
        createEditDeletePlayerPage.setPhoneValue(phone);
        createEditDeletePlayerPage.saveButtonClick();
        String actualUsername = createEditDeletePlayerPage.getUsernameFieldValue();
        softAssert.assertEquals(actualUsername,username,"Wrong username field value");
        String actualEmail = createEditDeletePlayerPage.getEmailFieldValue();
        softAssert.assertEquals(actualEmail,email,"Wrong email field value");
        String actualFirstName = createEditDeletePlayerPage.getFirstNameFielValue();
        softAssert.assertEquals(actualFirstName,firstname,"Wrong first name field value ");
        String actualLastName = createEditDeletePlayerPage.getLastNameFieldValue();
        softAssert.assertEquals(actualLastName,lastname,"Wrong last name fiedl value");
        String actualCity = createEditDeletePlayerPage.getCityFieldValue();
        softAssert.assertEquals(actualCity,city,"Wrong city field value");

    }
    @DataProvider
    public Object [][] editUserData() {
        return new Object[][]{
                {"edit", username, email, password, confirmpassword, firstname, lastname, city, address, phone, "Save"}
        };
    }
    @Test
    public void editPlayerTest(String username, String email, String firstname, String lastname, String city, String address, String phone){
        createEditDeletePlayerPage.setSearchEditPlayer(username);
        createEditDeletePlayerPage.setEmailValue(email);
        createEditDeletePlayerPage.setFirstNameValue(firstname);
        createEditDeletePlayerPage.setLastNameValue(lastname);
        createEditDeletePlayerPage.setCityValue(city);
        createEditDeletePlayerPage.setAddressValue(address);
        createEditDeletePlayerPage.setPhoneValue(phone);
        createEditDeletePlayerPage.saveButtonClick();
    }


    }



