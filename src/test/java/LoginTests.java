import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

    @Test
    public static void SignUpShortPassword () {


        //This test is to verify error message for password less than 8 characters
        WebDriver driver = new ChromeDriver ();
        driver.get ("https://deens-master.now.sh/register" );
        WebElement login_button = driver.findElement ( By.cssSelector ( "[id=\"username\"]" ));
        login_button.click ();
        login_button.sendKeys ( "elena" );
        WebElement email = driver.findElement ( By.cssSelector ( "[id=\"email\"]" ) );
        email.sendKeys ( "gizikovaelena@gmail.com" );
        WebElement password = driver.findElement ( By.cssSelector ( "[id=\"password\"]" ) );
        password.sendKeys ( "Test123" );
        WebElement register = driver.findElement ( By.cssSelector ( "[class=\"ui large fluid button green-btn pl-btn\"]" ) );
        register.click ();
        WebElement uiErrorMessage = driver.findElement ( By.cssSelector ( "[class=\"ui message\"]" ) );
        String errorMessage = uiErrorMessage.getText ();
        Assert.assertEquals (errorMessage, "Password must be at least 8 characters long" );
    }
}
