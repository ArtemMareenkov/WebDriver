package Webdriver_TestNG_XML.tests;

import Webdriver_TestNG_XML.pages.CreateEditDeletePlayerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Alert;
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

    //variables for create players
    String username = RandomStringUtils.random(8, true, true);
    String password = RandomStringUtils.random(10, true, true);
    String confirmpassword = password;
    String createdemail = RandomStringUtils.random(10,true,true);
    String createdfirstname =RandomStringUtils.random(7,true,false);
    String createdlastname = RandomStringUtils.random(8,true,false);
    String createdcity = RandomStringUtils.random(7,true,false);
    String createdaddress = RandomStringUtils.random(9,true,true);
    String createdphone = RandomStringUtils.random(11,false,true);

    //variables for edit players
    String editemail = RandomStringUtils.random(10,true,true);
    String editfirstname =RandomStringUtils.random(7,true,false);
    String editlastname = RandomStringUtils.random(8,true,false);
    String editcity = RandomStringUtils.random(7,true,false);
    String editaddress = RandomStringUtils.random(9,true,true);
    String editphone = RandomStringUtils.random(11,false,true);


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
    public Object[][] createPlayerData() {
        return new Object[][]{
                {"insert",username, createdemail, password, confirmpassword,createdfirstname,createdlastname,createdcity,createdaddress,createdphone, "Save"}
        };
    }
    @Test (dataProvider = "createPlayerData")
    public void createPlayerTest(String insert,String username, String email, String password, String confirmpassword,  String firstname, String lastname, String city, String address, String phone, String save){
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
        softAssert.assertEquals(actualLastName,lastname,"Wrong last name field value");
        String actualCity = createEditDeletePlayerPage.getCityFieldValue();
        softAssert.assertEquals(actualCity,city,"Wrong city field value");
        String actualAddress = createEditDeletePlayerPage.getAddressFieldValue();
        softAssert.assertEquals(actualAddress,address,"Wrong address field value");

    }

    @DataProvider
    public Object [][] editPlayerData() {
        return new Object[][]{
                { "edit","user194", editemail, editfirstname, editlastname, editcity, editaddress, editphone, "Save"}
        };
    }
    @Test (dataProvider = "editPlayerData")
    public void editPlayerTest(String edit, String username, String email, String firstname, String lastname, String city, String address, String phone, String  save){
        createEditDeletePlayerPage.setSearchEditPlayer(username);
        createEditDeletePlayerPage.setEmailValue(email);
        createEditDeletePlayerPage.setFirstNameValue(firstname);
        createEditDeletePlayerPage.setLastNameValue(lastname);
        createEditDeletePlayerPage.setCityValue(city);
        createEditDeletePlayerPage.setAddressValue(address);
        createEditDeletePlayerPage.setPhoneValue(phone);
        createEditDeletePlayerPage.saveButtonClick();

        String actualEmail = createEditDeletePlayerPage.getEmailFieldValue();
        softAssert.assertEquals(actualEmail,email,"Wrong email field value");
        String actualFirstName = createEditDeletePlayerPage.getFirstNameFielValue();
        softAssert.assertEquals(actualFirstName,firstname,"Wrong first name field value ");
        String actualLastName = createEditDeletePlayerPage.getLastNameFieldValue();
        softAssert.assertEquals(actualLastName,lastname,"Wrong last name field value");
        String actualCity = createEditDeletePlayerPage.getCityFieldValue();
        softAssert.assertEquals(actualCity,city,"Wrong city field value");
        String actualAddress = createEditDeletePlayerPage.getAddressFieldValue();
        softAssert.assertEquals(actualAddress,address,"Wrong address field value");
    }

   @DataProvider
   public Object[][]deletePlayersData(){
        return new Object[][]{
                {"delete","user193"}

        };
   }
    @Test
    public void deletePlayesTest(String delete, String username){
        createEditDeletePlayerPage.setSearchDeletePlayer(username);
        createEditDeletePlayerPage.alertPopup();
    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    }



