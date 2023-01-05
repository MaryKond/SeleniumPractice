import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest {
    private static final String HOME_PAGE_FACEBOOK="https://www.facebook.com/";
    private static WebDriver driver;


    @BeforeAll
    public static void classSetup(){
        driver= SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_FACEBOOK);
    }
//    @AfterAll
//    public static void closeBrowser(){
//        SharedDriver.closeDriver();
//    }
//    @AfterEach
//    public void testTearDown(){
//       driver.get(HOME_PAGE_FACEBOOK);
//    }

    @Test
    public void clickCreateNewAcc() throws InterruptedException {

        WebElement createNewAccButton = driver.findElement(By.xpath("//*[text()='Create new account']"));
        assertNotNull(createNewAccButton);
        createNewAccButton.click();
        Thread.sleep(1000);

        WebElement firstName=driver.findElement(By.xpath("//*[text()='firstname']"));
       assertNotNull(firstName);
        //firstName.click();
        firstName.sendKeys("Olga");
        String firstNameValue= firstName.getAttribute("value");
        assertEquals("Olga",firstNameValue);






//  driver.findElement(By.xpath("//*[text()='Create new account']")).click();
//  Thread.sleep(1000);


        }
}
