import com.sun.deploy.net.proxy.WFirefoxProxyConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.lang3.RandomStringUtils;
/**
 * Created by Artem Mareenkov on 26.11.2016.
 */
public class HomeWork {

    public static void main(String[] args) {

        //open Browser
        WebDriver driver = new FirefoxDriver();
        //open website
        driver.get("http://80.92.229.236:81/auth/login");
        //Login field find
        WebElement loginInput = driver.findElement(By.id("username"));
        loginInput.sendKeys("admin"); // login enter

        WebElement passwordInput = driver.findElement(By.id ("password")); //Password field find
        passwordInput.sendKeys("123");// password enter

        WebElement LoginButton = driver.findElement(By.id("logIn")); // Login button Fiend
        LoginButton.click(); //Login button click

        WebElement insertbutton = driver.findElement(By.xpath(".//a[@href='http://80.92.229.236:81/players/insert']/img")); // insert player button fiend
        insertbutton.click();// insert player button click

        String u = RandomStringUtils.random(8, true, true); // random user name generate
        WebElement Username = driver.findElement(By.id("ff14642ac1c__us_login"));
        Username.sendKeys(u);

        String p = RandomStringUtils.random(10, true, true);
        WebElement Userpassword = driver.findElement(By.id("ff14642ac1c__us_password"));
        Userpassword.sendKeys(p);

        WebElement userpasswordconfirm = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        userpasswordconfirm.sendKeys(p);

        WebElement Useremail = driver.findElement(By.id("ff14642ac1c__us_email"));
        Useremail.sendKeys(RandomStringUtils.random(6, true, true)+"@gmail.com");

        WebElement FirstName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        FirstName.sendKeys(RandomStringUtils.random(6, true, false));

        WebElement LastName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        LastName.sendKeys(RandomStringUtils.random(8, true, false));

        WebElement City = driver.findElement(By.id("ff14642ac1c__us_city"));
        City.sendKeys(RandomStringUtils.random(9, true, false));

        WebElement Address = driver.findElement(By.id("ff14642ac1c__us_address"));
        Address.sendKeys(RandomStringUtils.random(10, true, true));

        WebElement PhoneNumber = driver.findElement(By.id("ff14642ac1c__us_phone"));
        PhoneNumber.sendKeys(RandomStringUtils.random(10, false, true));

        WebElement SaveButton = driver.findElement(By.xpath(".//input[@name='button_save']"));
        SaveButton.click(); //save button click

        String ExpectedResult = "Players";
        String ActualResult = driver.getTitle();
        assertString(ActualResult, ExpectedResult);

        WebElement usersearchfield = driver.findElement(By.id("723a925886__login"));
        usersearchfield.sendKeys(u);

        driver.findElement(By.name("search")).click(); //search button click

        driver.findElement(By.xpath(".//tr[.//a[text()='" + u + "']]/img[@alt='Edit']")).click(); //Edit button click

        String UsM = RandomStringUtils.random(8,true,true);
        Useremail.sendKeys(UsM+"mail.ru");

        String FN = RandomStringUtils.random(9,true, false);
        FirstName.sendKeys(FN);

        String LN = RandomStringUtils.random(5, true,false );
        LastName.sendKeys(LN);

        String CT = RandomStringUtils.random(9,true,false);
        City.sendKeys(CT);

        String AD = RandomStringUtils.random(10,true,true);
        Address.sendKeys(AD);

        String PH = RandomStringUtils.random(11,false,true);
        PhoneNumber.sendKeys(PH);

        SaveButton.click();

        usersearchfield.sendKeys(u);
        driver.findElement(By.xpath(".//tr[.//a[text()='" + u + "']]/img[@alt='Edit']")).click(); //Edit button click

        //Check User Mail Field
        driver.findElement(By.id("ff14642ac1c__us_email"));
        String actualEmailValue = Useremail.getAttribute("value");
        assertString(actualEmailValue, UsM+"mail.ru");

        //Check First Name Field
        driver.findElement(By.id("ff14642ac1c__us_fname"));
        String actualFirstNameValue = FirstName.getAttribute("value");
        assertString(actualFirstNameValue,FN);

        //Check Last Name Field
        driver.findElement(By.id("ff14642ac1c__us_lname"));
        String actualLastNameValue = LastName.getAttribute("value");
        assertString(actualLastNameValue,LN);

        //Check City Field
        driver.findElement(By.id("ff14642ac1c__us_city"));
        String actualCityValue = City.getAttribute("value");
        assertString(actualCityValue,CT);

        //Check Address Field
        driver.findElement(By.id("ff14642ac1c__us_address"));
        String actualAddresValue = Address.getAttribute("value");
        assertString(actualCityValue,AD);

        //check Phone Field
        driver.findElement(By.id("ff14642ac1c__us_phone"));
        String actualPhoneValue = PhoneNumber.getAttribute("value");
        assertString(actualPhoneValue,PH);

        driver.quit();

    }
    public static void assertString(String ActualResult, String ExpectedResult) {
        if(ExpectedResult.equals(ActualResult)) {
            System.out.println("Passed");
        } else {
            System.err.println("Failed. Expected: " + ExpectedResult
                    + ". Actual: " + ActualResult);
        }
    }
  }






