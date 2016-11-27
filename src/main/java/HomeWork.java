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


        WebElement LoginButton = driver.findElement(By.id("logIn")); // Loginbutton Fiend
        LoginButton.click(); //Login button click

        driver.findElement(By.id("")).click();

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
        useremail.sendKeys(RandomStringUtils.random(10, true, true)"@gmail.com");

        WebElement FirstName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        FirstName.sendKeys((RandomStringUtils.random(10, true, false));

        WebElement LastName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        LastName.sendKeys((RandomStringUtils.random(10, true, false);

        WebElement City = driver.findElement(By.id("ff14642ac1c__us_city"));
        City.sendKeys((RandomStringUtils.random(10, true, false);

        WebElement Address = driver.findElement(By.id(""));
        Address.sendKeys((RandomStringUtils.random(10, true, true));

        WebElement PhoneNumber = driver.findElement(By.id(""));
        PhoneNumber.sendKeys((RandomStringUtils.random(10, false, true));

        driver.findElement(By.name("button_save")); //save button click

        String ExpectedResult = "Players";
        String ActualResult = driver.getTitle();
        assertString(ActualResult, ExpectedResult);

        WebElement usersearch = driver.findElement(By.id(""));
        usersearch.sendKeys(u);



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






