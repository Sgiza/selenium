import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {

    @BeforeMethod
    public void openLoginPage () {
        driver.get ( "https://deens.com/login" );

    }

    @Test
    public void loginSuccessTest () {
        enterEmail ( "macarena1@gmail.com" );
        enterPassword ( "Test123Test123" );
        submit ( );
        Assert.assertTrue ( avatarAppeared ( ) );

    }

    @Test
    public void emptyCredentials () {


        submit ( );
        Assert.assertEquals ( getErrorMessage (), "Cannot login\n" + "Empty email or password" );
    }

    @Test

    public void wrongCredentials () {

        enterEmail ( "ajgirre@gmail.com" );
        enterPassword ( "hfdgfdkghkfdl" );
        submit ( );
        Assert.assertEquals ( getErrorMessage (), "Cannot login\n" + "no user found with email: ajgirre@gmail.com" );


    }

    public void enterPassword ( String password ) {
        driver.findElement ( By.cssSelector ( "#password" ) ).sendKeys ( password );
    }


    public void enterEmail ( String email ) {
        driver.findElement ( By.cssSelector ( "#email" ) ).sendKeys ( email );
    }


    public void submit () {
        driver.findElement ( By.cssSelector ( "[data-testid=\"loginSubmit\"]" ) ).click ( );
    }

    public boolean avatarAppeared () {

        return driver.findElement ( By.cssSelector ( "[class*='DesktopDropDownMenu__AvatarWrapper']" ) ).isDisplayed ( );
    }

    private String getErrorMessage () {
        WebElement uiErrorMessage = findElement ( ".ui.error.message" );
        String errorMessage = uiErrorMessage.getText ( );
        return errorMessage;
    }

     public WebElement findElement (String cssLocator) {

         return driver.findElement ( By.cssSelector (cssLocator ) );
     }
}


