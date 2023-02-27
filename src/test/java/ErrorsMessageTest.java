import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;

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
    @AfterEach
    public void tearDown(){
        driver.get(HOME_PAGE);
    }

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
        @ParameterizedTest
        @ValueSource(strings = {"Mar", "Jul","Nov"})
        public void birthdayDropMenuTest(String month) {
            driver.findElement(By.xpath("//*[text()='Create new account']")).click();
            assertNotNull(driver.findElement(By.xpath("//*[text()='Sign Up']")));
            
           driver.findElement(By.xpath("//*[@title='Month']")).click();
           driver.findElement(By.xpath("//*[text()='"+month+"']")).click();
           Select select=new Select(driver.findElement(By.xpath("//*[@title='Month']")));
           select.selectByVisibleText(month);
            WebElement monthValue = select.getFirstSelectedOption();
            String selectedoption = monthValue.getText();
//           String monthValue=driver.findElement(By.xpath("//*[@title='Month']")).getFirstSelectedOption();
           assertEquals(month,selectedoption);


        }







    public void pause(){
        try{
            Thread.sleep(5);
        }catch(Exception err){
            System.out.println("Wrong");
        }
    }
}
