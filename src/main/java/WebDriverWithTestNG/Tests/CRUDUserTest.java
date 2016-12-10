package WebDriverWithTestNG.Tests;

import WebDriverWithTestNG.Pages.CreateEditPlayerPage;
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
    private CreateEditPlayerPage createEditPlayerPage;
    private DeletePlayerPage deletePlayerPage;

    private String  generatedUsernameValue = RandomStringUtils.random(8, true, true);

    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
        createEditPlayerPage.setLoginUsername("admin");
        createEditPlayerPage.setLoginPassword();
        createEditPlayerPage.logIn();
    }

    @Test
    public void createUserTest(){
        createEditPlayerPage.insertButtonClick();
        createEditPlayerPage.setUsername(generatedUsernameValue);

        String generatedMailValue = RandomStringUtils.random(10,true,true);
        createEditPlayerPage.setEmail(generatedMailValue + "yandex.com");

        String generatedPasswordValue = RandomStringUtils.random(10, true, true);
        createEditPlayerPage.setPassword(generatedPasswordValue);
        createEditPlayerPage.setConfirmPassword(generatedPasswordValue);

        String generatedFirstNameValue = RandomStringUtils.random(7,true,false);
        createEditPlayerPage.setFirstName(generatedFirstNameValue);

        String generatedLastNameValue = RandomStringUtils.random(8,true,false);
        createEditPlayerPage.setLastName(generatedLastNameValue);

        String generatedCityValue = RandomStringUtils.random(7,true,false);
        createEditPlayerPage.setCity(generatedCityValue);

        String generatedAddressValue = RandomStringUtils.random(9,true,true);
        createEditPlayerPage.setAddress(generatedAddressValue);

        String generatedPhoneValue = RandomStringUtils.random(11,false,true);
        createEditPlayerPage.setPhone(generatedPhoneValue);

        createEditPlayerPage.saveButtonClick();

        createEditPlayerPage.setPlayerSearch(generatedUsernameValue);

        Assert.assertEquals(createEditPlayerPage.getUsernameFieldValue(),generatedUsernameValue,"Wrong Username field value"); // Check username field value

        Assert.assertEquals(createEditPlayerPage.getEmailFieldValue(),generatedMailValue,"Wrong email field value");
        Assert.assertEquals(createEditPlayerPage.getFirstNameFieldValue(),generatedFirstNameValue, "Wrong firstname field value");
        Assert.assertEquals(createEditPlayerPage.getLastNameFieldValue(),generatedLastNameValue,"Wrong lastname field value");
        Assert.assertEquals(createEditPlayerPage.getCityFieldValue(),generatedCityValue,"Wrong city field value");
        Assert.assertEquals(createEditPlayerPage.getAddressFieldValue(),generatedAddressValue,"Wrong city field value");
        Assert.assertEquals(createEditPlayerPage.getPhoneFieldValue(),generatedPhoneValue, "Wrong city field value");

        createEditPlayerPage.cancelButtonClick();
    }

    @Test
    public void editUserTest(){
       createEditPlayerPage.setPlayerSearch(generatedUsernameValue);

       String generatedMailValue = RandomStringUtils.random(10,true,true);
       createEditPlayerPage.setEmail(generatedMailValue + "yahhoo.com");

        String generatedPasswordValue = RandomStringUtils.random(10, true, true);
        createEditPlayerPage.setPassword(generatedPasswordValue);
        createEditPlayerPage.setConfirmPassword(generatedPasswordValue);

        String generatedFirstNameValue = RandomStringUtils.random(7,true,false);
        createEditPlayerPage.setFirstName(generatedFirstNameValue);

        String generatedLastNameValue = RandomStringUtils.random(8,true,false);
        createEditPlayerPage.setLastName(generatedLastNameValue);

        String generatedCityValue = RandomStringUtils.random(7,true,false);
        createEditPlayerPage.setCity(generatedCityValue);

        String generatedAddressValue = RandomStringUtils.random(9,true,true);
        createEditPlayerPage.setAddress(generatedAddressValue);

        String generatedPhoneValue = RandomStringUtils.random(11,false,true);
        createEditPlayerPage.setPhone(generatedPhoneValue);

        createEditPlayerPage.saveButtonClick();

        createEditPlayerPage.setPlayerSearch(generatedUsernameValue);

        Assert.assertEquals(createEditPlayerPage.getUsernameFieldValue(),generatedUsernameValue,"Wrong Username field value"); // Check username field value

        Assert.assertEquals(createEditPlayerPage.getEmailFieldValue(),generatedMailValue,"Wrong email field value");
        Assert.assertEquals(createEditPlayerPage.getFirstNameFieldValue(),generatedFirstNameValue, "Wrong firstname field value");
        Assert.assertEquals(createEditPlayerPage.getLastNameFieldValue(),generatedLastNameValue,"Wrong lastname field value");
        Assert.assertEquals(createEditPlayerPage.getCityFieldValue(),generatedCityValue,"Wrong city field value");
        Assert.assertEquals(createEditPlayerPage.getAddressFieldValue(),generatedAddressValue,"Wrong city field value");
        Assert.assertEquals(createEditPlayerPage.getPhoneFieldValue(),generatedPhoneValue, "Wrong city field value");

        createEditPlayerPage.cancelButtonClick();
    }
    @Test
    public void deleteUserEtst(){

    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
