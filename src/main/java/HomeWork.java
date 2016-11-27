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
        driver.get("https://80.92.229:81/auth/login");
        //Login field find
        WebElement loginInput = driver.findElement(By.id("username"));
        // login enter
        loginInput.sendKeys("admin");

        WebElement passwordInput = driver.findElement(By.id ("password")); //Password field find
        passwordInput.sendKeys("123");// password enter


        WebElement LoginButton = driver.findElement(By.id("logIn")); // Login button Fiend
        LoginButton.click(); //Login button click

        WebElement insertbutton = driver.findElement(By.id("Will be added")); // insert player button fiend
        insertbutton.click();// insert player button click

        String u = RandomStringUtils.random(12, true, true); // ramdom user name generate
        WebElement username = driver.findElement(By.id("ff14642ac1c__us_login"));
        username.sendKeys(u);
        //System.out.println(username.getText());

        String p = RandomStringUtils.random(12, true, true);
        WebElement userpassword = driver.findElement(By.id("ff14642ac1c__us_password"));
        userpassword.sendKeys(p);

        WebElement userpasswordconfirm = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        userpasswordconfirm.sendKeys(p);

        WebElement useremail = driver.findElement(By.id("ff14642ac1c__us_email"));
        useremail.sendKeys(RandomStringUtils.random(10, true, true)+"@gmail.com");

        WebElement FirstName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        FirstName.sendKeys(RandomStringUtils.random(10, true, false));

        WebElement LastName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        LastName.sendKeys(RandomStringUtils.random(10, true, false));

        WebElement City = driver.findElement(By.id("ff14642ac1c__us_city"));
        City.sendKeys(RandomStringUtils.random(10, true, false));

        WebElement Address = driver.findElement(By.id("ff14642ac1c__us_address"));
        Address.sendKeys(RandomStringUtils.random(10, true, true));

        WebElement PhoneNumber = driver.findElement(By.id("ff14642ac1c__us_phone"));
        PhoneNumber.sendKeys(RandomStringUtils.random(10, false, true));

        WebElement SaveButton = driver.findElement(By.name("button_save"));
         SaveButton.click(); //save button click

        String ExpectedResult = "Players";
        String ActualResult = driver.getTitle();
        assertString(ActualResult, ExpectedResult);

        WebElement usersearch = driver.findElement(By.id("It will be added later"));
        usersearch.sendKeys(u);

        WebElement SearchButton = driver.findElement(By.id("It will be added later"));
        SearchButton.click();

        WebElement EditButton = driver.findElement(By.id("It will be added later"));
        EditButton.click();

        String FN = RandomStringUtils.random(12,true, false);
        FirstName.sendKeys(FN);

        String LN = RandomStringUtils.random(12, true,false );
        LastName.sendKeys(LN);

        String UsM = RandomStringUtils.random(12,true,true);
        useremail.sendKeys(UsM);

        String CT = RandomStringUtils.random(12,true,false);
        City.sendKeys(CT);

        String AD = RandomStringUtils.random(12,true,true);
        Address.sendKeys(AD);

        String PH = RandomStringUtils.random(11,false,true);
        PhoneNumber.sendKeys(PH);

        SaveButton.click();

        usersearch.sendKeys(u);
        EditButton.click();

        String ExpectedResult = FN;
        String ActualResult = FirstName.getAttribute("value");
        assertString(ActualResult, ExpectedResult);

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






