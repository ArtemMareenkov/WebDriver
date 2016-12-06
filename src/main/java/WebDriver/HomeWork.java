package WebDriver;

import com.sun.deploy.net.proxy.WFirefoxProxyConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by Artem Mareenkov on 26.11.2016.
 */
public class HomeWork {

    public static void main(String[] args) {

        //open Browser
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //open website
        driver.get("http://80.92.229.236:81/auth/login");
        //Login field find
        WebElement inputLogin= driver.findElement(By.id("username"));
        inputLogin.sendKeys("admin"); // login enter

        WebElement inputPassword = driver.findElement(By.id ("password")); //Password field find
        inputPassword.sendKeys("123");// password enter

        WebElement clickLoginButton = driver.findElement(By.id("logIn")); // Login button Fiend
        clickLoginButton.click(); //Login button click

        WebElement clickInsertButton = driver.findElement(By.xpath(".//a[@href='http://80.92.229.236:81/players/insert']/img")); // insert player button fiend
        clickInsertButton.click();// insert player button click

        String u = RandomStringUtils.random(8, true, true); // random user name generate
        WebElement inputUsername = driver.findElement(By.id("ff14642ac1c__us_login"));
        inputUsername.sendKeys(u);

        String p = RandomStringUtils.random(10, true, true);
        WebElement inputUserpassword = driver.findElement(By.id("ff14642ac1c__us_password"));
        inputUserpassword.sendKeys(p);

        WebElement inputUserPasswordConfirm = driver.findElement(By.id("ff14642ac1c__confirm_password"));
        inputUserPasswordConfirm.sendKeys(p);

        String m = RandomStringUtils.random(10,true,true);
        WebElement inputUserEmail = driver.findElement(By.id("ff14642ac1c__us_email"));
        inputUserEmail.sendKeys(m +"@gmail.com");

        String f = RandomStringUtils.random(7,true,false);
        WebElement FirstName = driver.findElement(By.id("ff14642ac1c__us_fname"));
        FirstName.sendKeys(f);

        String l = RandomStringUtils.random(8,true,false);
        WebElement LastName = driver.findElement(By.id("ff14642ac1c__us_lname"));
        LastName.sendKeys(l);

        String c = RandomStringUtils.random(7,true,false);
        WebElement City = driver.findElement(By.id("ff14642ac1c__us_city"));
        City.sendKeys(c);

        String a = RandomStringUtils.random(9,true,true);
        WebElement Address = driver.findElement(By.id("ff14642ac1c__us_address"));
        Address.sendKeys(a);

        String ph = RandomStringUtils.random(11,false,true);
        WebElement PhoneNumber = driver.findElement(By.id("ff14642ac1c__us_phone"));
        PhoneNumber.sendKeys(ph);

        WebElement SaveButton = driver.findElement(By.xpath(".//input[@name='button_save']"));
        SaveButton.click(); //save button click

        String ExpectedResult = "Players";
        String ActualResult = driver.getTitle();
        assertString(ActualResult, ExpectedResult);

        WebElement usersearchfield = driver.findElement(By.id("723a925886__login"));
        usersearchfield.sendKeys(u);

        driver.findElement(By.name("search")).click(); //search button click

        driver.findElement(By.xpath(".//tr[.//a[text()='" + u + "']]/img[@alt='Edit']")).click(); //Edit button click

        //Check User Mail Field
        String actualEmailValue = inputUserEmail.getAttribute("value");
        assertString(actualEmailValue, m + "gmail.com");

        //Check First Name Field
        String actualFirstNameValue = FirstName.getAttribute("value");
        assertString(actualFirstNameValue,f);

        //Check Last Name Field
        String actualLastNameValue = LastName.getAttribute("value");
        assertString(actualLastNameValue,l);

        //Check City Field
        String actualCityValue = City.getAttribute("value");
        assertString(actualCityValue,c);

        //Check Address Field
        String actualAddressValue = Address.getAttribute("value");
        assertString(actualAddressValue,a);

        //check Phone Field
        String actualPhoneValue = PhoneNumber.getAttribute("value");
        assertString(actualPhoneValue,ph);

        driver.findElement(By.name("button_cancel"));

        usersearchfield.sendKeys(u);

        driver.findElement(By.name("search")).click(); //search button click

        driver.findElement(By.xpath(".//tr[.//a[text()='" + u + "']]/img[@alt='Edit']")).click(); //Edit button click
        usersearchfield.sendKeys(u);

        String UsM = RandomStringUtils.random(8,true,true);
        inputUserEmail.sendKeys(UsM+"mail.ru");

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
        driver.findElement(By.name("search")).click(); //search button click

        driver.findElement(By.xpath(".//tr[.//a[text()='" + u + "']]/img[@alt='Edit']")).click(); // open Edit Players

        //Check User Mail Field
        String actualMailValue = inputUserEmail.getAttribute("value");
        assertString(actualMailValue, UsM+"mail.ru");

        //Check First Name Field
        String actualfirstNameValue = FirstName.getAttribute("value");
        assertString(actualfirstNameValue,FN);

        //Check Last Name Field
        String actuallastNameValue = LastName.getAttribute("value");
        assertString(actuallastNameValue,LN);

        //Check City Field
        String actualcityValue = City.getAttribute("value");
        assertString(actualcityValue,CT);

        //Check Address Field
        String actualaddresValue = Address.getAttribute("value");
        assertString(actualaddresValue,AD);

        //check Phone Field
        String actualphoneValue = PhoneNumber.getAttribute("value");
        assertString(actualphoneValue,PH);


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






