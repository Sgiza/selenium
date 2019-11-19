import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SignUpPage extends BaseTest{

        @BeforeMethod
        public void openLoginPage () {
            driver.get ( "https://deens.com/register" );


        }
        @Test
        public void signUpSucessTest() {

            enterUsername ( getTimeStamp () );
            enterEmail ( getGeneratedEmail () );
            enterPassword ( "Test123Test123" );
            submit ();
            Assert.assertTrue (avatarAppeared ());

        }

        @Test
        public void signUpWrongCredentials() {

            enterUsername ( "username");
            enterEmail ("username@gmailcom"  );
            enterPassword ( "Test123Test123" );
            submit ();
            Assert.assertEquals(getErrorMessage (), "Please enter a valid email address");



        }
        @Test
        public void signUpEmptyCredentials() {

            submit ();
            Assert.assertEquals(getErrorMessage (), "Password must be at least 8 characters long");

        }


        public void enterUsername ( String username ) {

            driver.findElement( By.cssSelector("#username")).sendKeys ( username );

        }
        public void enterPassword ( String password ) {
            driver.findElement ( By.cssSelector ( "#password" ) ).sendKeys ( password );
        }

        public void enterEmail ( String email ) {
            driver.findElement ( By.cssSelector ( "#email" ) ).sendKeys ( email );
        }


        public void submit () {
            driver.findElement(By.cssSelector(".ui.large.fluid.button.green-btn.pl-btn")).click();
        }

        private String getErrorMessage () {

            WebElement uiErrorMessage = driver.findElement(By.cssSelector("[class='ui message']"));
            String errorMessage = uiErrorMessage.getText();

            return errorMessage;
        }

        public boolean avatarAppeared () {

            return driver.findElement ( By.cssSelector ("[class=\" ls-is-cached lazyloaded\"]") ).isDisplayed ();
        }

        public String getGeneratedEmail () {

            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyyMMddHHmmss"));
            LocalDateTime myDate = LocalDateTime.now();
            String localTimeString = formatter.format(myDate);
            String date1= localTimeString.toString();
            String email = new String(date1 + "@gmail.com");

            return email;

        }

        public String getTimeStamp ()
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(("yyyyMMddHHmmss"));
            LocalDateTime myDate = LocalDateTime.now();
            String localTimeString = formatter.format(myDate);
            String timeStamp= localTimeString.toString();
            return timeStamp;
        }
    }




