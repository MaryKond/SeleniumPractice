import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorsMessageTest {
    private static final String HOME_PAGE="https://www.facebook.com";
    private static WebDriver driver;

    @BeforeAll
    public static void setUp(){
        driver = SharedDriver.getWebDriver();
        driver.get(HOME_PAGE);
    }
//    @AfterEach
//    public void tearDown(){
//        driver.get(HOME_PAGE);
//    }

    @Test
    public void errorMessageTest() {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='websubmit']"))).click();

        driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        driver.findElement(By.xpath("//input[@name='firstname']")).click();
        WebElement errorName = driver.findElement(By.xpath("//*[contains(text(),'your name?')]"));
        assertNotNull(errorName);
        driver.findElement(By.xpath("//input[@name='lastname']")).click();
        WebElement errorLastName = driver.findElement(By.xpath("//*[contains(text(),'your name?')]"));
        assertNotNull(errorLastName);
        driver.findElement(By.xpath("//input[@name ='reg_email__']")).click();
        WebElement errorEmail = driver.findElement(By.xpath("//*[contains(text(),'you ever need to reset')]"));
        assertNotNull(errorEmail);
}
//     1st attempt
        @Test
        public void errorPasswordTest() {
            driver.findElement(By.xpath("//*[text()='Create new account']")).click();
            assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("kkmorgano@gmail.com");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@name='websubmit']"))).click();
            //driver.findElement(By.xpath("//input[@type ='password']")).click();
            driver.findElement(By.xpath("//input[@name ='reg_email_confirmation__']")).click();
            WebElement errorReEnterEmail = driver.findElement(By.xpath("//*[contains(text(),'Please re-enter')]"));
            assertNotNull(errorReEnterEmail);

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type ='password']"))).click(); //name="pass" type="password"> is not clickable at point (1297,238) because another element <div class="_3ixn"> obscures it
            driver.findElement(By.xpath("//input[@type ='password']")).click();
            WebElement errorPassword = driver.findElement(By.xpath("//*[contains(text(),'Enter a combination of at least')]"));
            assertNotNull(errorPassword);

//                 3d attempt
//            driver.findElement(By.xpath("//*[text()='Create new account']")).click();
//            assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.invisibilityOfElementLocated((By.xpath( "//input[@type ='password']"))));
//            driver.findElement(By.xpath("//input[@type ='password']")).click();
//            WebElement errorPassword = driver.findElement(By.xpath("//*[contains(text(),'Enter a combination of at least')]"));
//            assertNotNull(errorPassword);
//


//      2d attempt

//            WebElement passwordField = driver.findElement(By.xpath("//input[@type ='password']"));
//            Actions action = new Actions(driver);
//            action.moveToElement(passwordField).click().build().perform();
//
//            WebElement errorPassword = driver.findElement(By.xpath("//*[contains(text(),'Enter a combination of at least')]"));
//            assertNotNull(errorPassword);

        }







    public void pause(){
        try{
            Thread.sleep(5);
        }catch(Exception err){
            System.out.println("Wrong");
        }
    }
}
