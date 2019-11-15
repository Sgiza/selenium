import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.time.*;


import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;




public class SignUp {


    @Test
    public static void signUpSucessTest() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyyMMddHHmmss"));
        LocalDateTime myDate = LocalDateTime.now();
        String localTimeString = formatter.format(myDate);
        String date1= localTimeString.toString();
        String com = new String("@gmail.com");
        String email = new String(date1.concat(com));

        driver.get("https://deens.com/register");
        WebElement userButton = driver.findElement(By.cssSelector("#username"));
        userButton.sendKeys(date1);
        WebElement emailField = driver.findElement(By.cssSelector("#email"));
        emailField.sendKeys(email);
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("Test123Test123");
        driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn")).click();
        Assert.assertTrue (driver.findElement ( By.cssSelector ("[class=\" ls-is-cached lazyloaded\"]") ).isDisplayed ());
        driver.quit();

    }

    @Test
    public static void signUpWrongCredentials() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://deens.com/register");
        WebElement userButton = driver.findElement(By.cssSelector("#username"));
        userButton.sendKeys("username");
        WebElement emailField = driver.findElement(By.cssSelector("#email"));
        emailField.sendKeys("username@gmailcom");
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("Test123Test123");
        driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn")).click();
        WebElement uiErrorMessage = driver.findElement(By.cssSelector("[class='ui message']"));
        String errorMessage = uiErrorMessage.getText();
        Assert.assertEquals(errorMessage, "Please enter a valid email address");
        driver.quit();


    }
    @Test
    public static void signUpEmptyCredentials() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://deens.com/register");
        driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn")).click();
        WebElement uiErrorMessage = driver.findElement(By.cssSelector("[class='ui message']"));
        String errorMessage = uiErrorMessage.getText();
        Assert.assertEquals(errorMessage, "Password must be at least 8 characters long");
        driver.quit();

    }
}
