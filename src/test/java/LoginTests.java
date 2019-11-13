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
        driver.findElement(By.cssSelector("#email")).click();
        driver.findElement(By.cssSelector("#email")).sendKeys("macarena1@gmail.com");
        driver.findElement(By.cssSelector("#password")).click();
        driver.findElement(By.cssSelector("#password")).sendKeys("Test123Test123");
        driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn")).click();
        Assert.assertTrue (driver.findElement ( By.cssSelector ("[class*='DesktopDropDownMenu__AvatarWrapper']") ).isDisplayed ());
        // driver.quit();
    }


    @Test
    public static void emptyCredentials() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://deens.com/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement login_button = driver.findElement(By.cssSelector("[data-testid=\"loginSubmit\"]"));
        login_button.click();
        WebElement uiErrorMessage = driver.findElement(By.cssSelector(".ui.error.message"));
        String errorMessage = uiErrorMessage.getText();
        Assert.assertEquals(errorMessage, "Cannot login\n" + "Empty email or password");
        // driver.quit();

    }

    @Test
    public static void wrongCredentials() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get ( "https://deens.com/login" );
        WebElement email_button = driver.findElement ( By.cssSelector ("#email"));
        email_button.sendKeys ( "ajgirre@gmail.com" );
        WebElement incorrectpassword_button = driver.findElement ( By.cssSelector ("#password"));
        incorrectpassword_button.sendKeys ( "jhhfjdkfhd" );
        WebElement login_button = driver.findElement (By.cssSelector ("[data-testid=\"loginSubmit\"]"));
        login_button.click ( );
        WebElement uiErrorMessage = driver.findElement ( By.cssSelector (".ui.error.message"));
        String errorMessage = uiErrorMessage.getText ();
        Assert.assertEquals ( errorMessage, "Cannot login\n" + "no user found with email: ajgirre@gmail.com" );
        // driver.quit();


    }
    }




