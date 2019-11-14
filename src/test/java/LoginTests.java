import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests {


    @Test
    public static void loginSuccessTest()


    {
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://deens.com/login");
        driver.findElement(By.cssSelector("#email"));
        driver.findElement(By.cssSelector("#email")).sendKeys("macarena1@gmail.com");
        driver.findElement(By.cssSelector("#password"));
        driver.findElement(By.cssSelector("#password")).sendKeys("Test123Test123");
        driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn")).click();
        Assert.assertTrue (driver.findElement ( By.cssSelector ("[class*='DesktopDropDownMenu__AvatarWrapper']") ).isDisplayed ());
        driver.quit();
    }


    @Test
    public static void emptyCredentials() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement loginButton = driver.findElement(By.cssSelector("[data-testid=\"loginSubmit\"]"));
        loginButton.click();
        WebElement uiErrorMessage = driver.findElement(By.cssSelector(".ui.error.message"));
        String errorMessage = uiErrorMessage.getText();
        Assert.assertEquals(errorMessage, "Cannot login\n" + "Empty email or password");
        driver.quit();

    }

    @Test
    public static void wrongCredentials() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get ( "https://deens.com/login" );
        WebElement emailButton = driver.findElement ( By.cssSelector ("#email"));
        emailButton.sendKeys ( "ajgirre@gmail.com" );
        WebElement incorrectpasswordButton = driver.findElement ( By.cssSelector ("#password"));
        incorrectpasswordButton.sendKeys ( "jhhfjdkfhd" );
        WebElement loginButton = driver.findElement (By.cssSelector ("[data-testid=\"loginSubmit\"]"));
        loginButton.click ( );
        WebElement uiErrorMessage = driver.findElement ( By.cssSelector (".ui.error.message"));
        String errorMessage = uiErrorMessage.getText ();
        Assert.assertEquals ( errorMessage, "Cannot login\n" + "no user found with email: ajgirre@gmail.com" );
        driver.quit();


    }
    }




