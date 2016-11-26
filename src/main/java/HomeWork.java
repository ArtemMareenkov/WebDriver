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

        WebElement username = driver.findElement(By.id("ff14642ac1c__us_login"));
        username.sendKeys(RandomStringUtils.random(10, true, true));
        System.out.println(username.getText());

        WebElement userpassword = driver.findElement(By.id("ff14642ac1c__us_password"));
        userpassword.sendKeys("dghr54hf");

        WebElement userpasswordconfirm = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        userpasswordconfirm.sendKeys("dghr54hf");

        WebElement useremail = driver.findElement(By.id("ff14642ac1c__us_email"));
        useremail.sendKeys("trtr@mai.ru");

        WebElement FirstName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        FirstName.sendKeys("Grtfhgkj");

        WebElement LastName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        LastName.sendKeys("TR454t");

        WebElement City = driver.findElement(By.id("ff14642ac1c__us_city"));
        City.sendKeys("Town");

        WebElement Address = driver.findElement(By.id(""));
        Address.sendKeys("Tbt7645bhh");

        WebElement PhoneNumber = driver.findElement(By.id(""));
        PhoneNumber.sendKeys("089785678459560");

        driver.findElement(By.name("button_save")); //save button click

        String ExpectedResult = "Players";
        String ActualResult = driver.getTitle();
        assertString(ActualResult, ExpectedResult);

        WebElement usersearch = driver.findElement(By.id(""));

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






