package WebDriverWithTestNG.Tests;

import WebDriverWithTestNG.Pages.CreateEditDeletePlayerPage;
import WebDriverWithTestNG.Pages.DeletePlayerPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;


/**
 * Created by Artem Mareenkov on 06.12.2016.
 */
public class CRUDUserTest {

    private WebDriver driver;
    private CreateEditDeletePlayerPage createEditDeletePlayerPage;


    private String  generatedUsernameValue = RandomStringUtils.random(8, true, true);

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        createEditDeletePlayerPage  = new CreateEditDeletePlayerPage(driver);
        createEditDeletePlayerPage.open();
        createEditDeletePlayerPage.setLoginUsername("admin");
        createEditDeletePlayerPage.setLoginPassword("123");
        createEditDeletePlayerPage.logIn();
    }

    @Test
    public void createUserTest(){
        createEditDeletePlayerPage.insertButtonClick();
        createEditDeletePlayerPage.setUsername(generatedUsernameValue);

        String generatedMailValue = RandomStringUtils.random(10,true,true);
        createEditDeletePlayerPage.setEmail(generatedMailValue + "yandex.com");

        String generatedPasswordValue = RandomStringUtils.random(10, true, true);
        createEditDeletePlayerPage.setPassword(generatedPasswordValue);
        createEditDeletePlayerPage.setConfirmPassword(generatedPasswordValue);

        String generatedFirstNameValue = RandomStringUtils.random(7,true,false);
        createEditDeletePlayerPage.setFirstName(generatedFirstNameValue);

        String generatedLastNameValue = RandomStringUtils.random(8,true,false);
        createEditDeletePlayerPage.setLastName(generatedLastNameValue);

        String generatedCityValue = RandomStringUtils.random(7,true,false);
        createEditDeletePlayerPage.setCity(generatedCityValue);

        String generatedAddressValue = RandomStringUtils.random(9,true,true);
        createEditDeletePlayerPage.setAddress(generatedAddressValue);

        String generatedPhoneValue = RandomStringUtils.random(11,false,true);
        createEditDeletePlayerPage.setPhone(generatedPhoneValue);

        createEditDeletePlayerPage.saveButtonClick();

        createEditDeletePlayerPage.setPlayerSearchEdit(generatedUsernameValue);

        Assert.assertEquals(createEditDeletePlayerPage.getUsernameFieldValue(),generatedUsernameValue,"Wrong Username field value"); // Check username field value

        Assert.assertEquals(createEditDeletePlayerPage.getEmailFieldValue(),generatedMailValue,"Wrong email field value");
        Assert.assertEquals(createEditDeletePlayerPage.getFirstNameFieldValue(),generatedFirstNameValue, "Wrong firstname field value");
        Assert.assertEquals(createEditDeletePlayerPage.getLastNameFieldValue(),generatedLastNameValue,"Wrong lastname field value");
        Assert.assertEquals(createEditDeletePlayerPage.getCityFieldValue(),generatedCityValue,"Wrong city field value");
        Assert.assertEquals(createEditDeletePlayerPage.getAddressFieldValue(),generatedAddressValue,"Wrong city field value");
        Assert.assertEquals(createEditDeletePlayerPage.getPhoneFieldValue(),generatedPhoneValue, "Wrong city field value");

        createEditDeletePlayerPage.cancelButtonClick();
    }

    @Test
    public void editUserTest(){

        createEditDeletePlayerPage.setPlayerSearchEdit("user194");

       String generatedMailValue = RandomStringUtils.random(10,true,true);
       createEditDeletePlayerPage.setEmail(generatedMailValue + "yahhoo.com");

       String generatedFirstNameValue = RandomStringUtils.random(7,true,false);
       createEditDeletePlayerPage.setFirstName(generatedFirstNameValue);

       String generatedLastNameValue = RandomStringUtils.random(8,true,false);
       createEditDeletePlayerPage.setLastName(generatedLastNameValue);

       String generatedCityValue = RandomStringUtils.random(7,true,false);
       createEditDeletePlayerPage.setCity(generatedCityValue);

       String generatedAddressValue = RandomStringUtils.random(9,true,true);
       createEditDeletePlayerPage.setAddress(generatedAddressValue);

       String generatedPhoneValue = RandomStringUtils.random(11,false,true);
       createEditDeletePlayerPage.setPhone(generatedPhoneValue);

       createEditDeletePlayerPage.saveButtonClick();

       createEditDeletePlayerPage.setPlayerSearchEdit("user 194");

       Assert.assertEquals(createEditDeletePlayerPage.getUsernameFieldValue(),generatedUsernameValue,"Wrong Username field value"); // Check username field value

        Assert.assertEquals(createEditDeletePlayerPage.getEmailFieldValue(),generatedMailValue,"Wrong email field value");
        Assert.assertEquals(createEditDeletePlayerPage.getFirstNameFieldValue(),generatedFirstNameValue, "Wrong firstname field value");
        Assert.assertEquals(createEditDeletePlayerPage.getLastNameFieldValue(),generatedLastNameValue,"Wrong lastname field value");
        Assert.assertEquals(createEditDeletePlayerPage.getCityFieldValue(),generatedCityValue,"Wrong city field value");
        Assert.assertEquals(createEditDeletePlayerPage.getAddressFieldValue(),generatedAddressValue,"Wrong city field value");
        Assert.assertEquals(createEditDeletePlayerPage.getPhoneFieldValue(),generatedPhoneValue, "Wrong city field value");

        createEditDeletePlayerPage.cancelButtonClick();
    }
    @Test
    public void deleteUserEtst(){

        createEditDeletePlayerPage.setPlayerSearchDelete("user195");
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }


    }
