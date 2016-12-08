package WebDriverWithTestNG.Tests;

import WebDriverWithTestNG.Pages.CreatePlayerPage;
import WebDriverWithTestNG.Pages.DeletePlayerPage;
import WebDriverWithTestNG.Pages.EditPlayerPage;
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
    private CreatePlayerPage createPlayerPage;
    private EditPlayerPage editPlayerPage;
    private DeletePlayerPage deletePlayerPage;



    @BeforeTest
    public void beforeTest() {
        driver = new FirefoxDriver();
    }
    private String  generatedUsernameValue = RandomStringUtils.random(8, true, true);

/*    @BeforeMethod
    public void beforeMethod() {
        createPlayerPage = new CreatePlayerPage(driver);
    }*/

    @Test
    public void createUserTest(){
        createPlayerPage.insertButtonClick();
        createPlayerPage.setUsername(generatedUsernameValue);

        String generatedMailValue = RandomStringUtils.random(10,true,true);
        createPlayerPage.setEmail(generatedMailValue + "yandex.com");

        String generatedPasswordValue = RandomStringUtils.random(10, true, true);
        createPlayerPage.setPassword(generatedPasswordValue);
        createPlayerPage.setConfirmPassword(generatedPasswordValue);

        String generatedFirstNameValue = RandomStringUtils.random(7,true,false);
        createPlayerPage.setFirstName(generatedFirstNameValue);

        String generatedLastNameValue = RandomStringUtils.random(8,true,false);
        createPlayerPage.setLastName(generatedLastNameValue);

        String generatedCityValue = RandomStringUtils.random(7,true,false);
        createPlayerPage.setCity(generatedCityValue);

        String generatedAddressValue = RandomStringUtils.random(9,true,true);
        createPlayerPage.setAddress(generatedAddressValue);

        String generatedPhoneValue = RandomStringUtils.random(11,false,true);
        createPlayerPage.setPhone(generatedPhoneValue);

        createPlayerPage.saveButtonClick();

        Assert.assertEquals(createPlayerPage.getTitle(),"Players","Wrong title");

        createPlayerPage.setPlayerSearch(generatedUsernameValue);

        Assert.assertEquals(createPlayerPage.getUsernameFieldValue(),generatedUsernameValue,"Wrong Username field value"); // Check username field value

        Assert.assertEquals(createPlayerPage.getEmailFieldValue(),generatedMailValue,"Wrong email field value");
        Assert.assertEquals(createPlayerPage.getFirstNameFieldValue(),generatedFirstNameValue, "Wrong firstname field value");
        Assert.assertEquals(createPlayerPage.getLastNameFieldValue(),generatedLastNameValue,"Wrong lastname field value");
        Assert.assertEquals(createPlayerPage.getCityFieldValue(),generatedCityValue,"Wrong city field value");
        Assert.assertEquals(createPlayerPage.getAddressFieldValue(),generatedAddressValue,"Wrong city field value");
        Assert.assertEquals(createPlayerPage.getPhoneFieldValue(),generatedPhoneValue, "Wrong city field value");

        createPlayerPage.cancelButtonClick();
    }

    @Test
    public void editUserTest(){
       editPlayerPage.setPlayerSearch(generatedUsernameValue);

       String generatedMailValue = RandomStringUtils.random(10,true,true);
       editPlayerPage.setEmail(generatedMailValue + "yahhoo.com");

        String generatedPasswordValue = RandomStringUtils.random(10, true, true);
        createPlayerPage.setPassword(generatedPasswordValue);
        createPlayerPage.setConfirmPassword(generatedPasswordValue);

        String generatedFirstNameValue = RandomStringUtils.random(7,true,false);
        createPlayerPage.setFirstName(generatedFirstNameValue);

        String generatedLastNameValue = RandomStringUtils.random(8,true,false);
        createPlayerPage.setLastName(generatedLastNameValue);

        String generatedCityValue = RandomStringUtils.random(7,true,false);
        createPlayerPage.setCity(generatedCityValue);

        String generatedAddressValue = RandomStringUtils.random(9,true,true);
        createPlayerPage.setAddress(generatedAddressValue);

        String generatedPhoneNumber = RandomStringUtils.random(11,false,true);
        createPlayerPage.setPhone(generatedPhoneNumber);

        createPlayerPage.saveButtonClick();
        Assert.assertEquals(createPlayerPage.getTitle(),"Players","Wrong title");




    }
    @AfterTest
    public void afterTest(){
        driver.quit();
    }

}
