import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;


public class LoginPageTest {
    private static final String HOME_PAGE_FACEBOOK="https://www.facebook.com/";
    private static WebDriver driver;


    @BeforeAll
    public static void classSetup() throws InterruptedException {
        driver= SharedDriver.getWebDriver();
        driver.get(HOME_PAGE_FACEBOOK);
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        Thread.sleep(1000);
    }
//    @AfterAll
//    public static void closeBrowser(){
//        SharedDriver.closeDriver();
//    }
    @AfterEach
    public void testTearDown() throws InterruptedException {
       driver.get(HOME_PAGE_FACEBOOK);
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        Thread.sleep(1000);
   }



    @Test
    public void locateFields() {
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstName);
        WebElement lastName= driver.findElement(By.xpath("//input[@name ='lastname']"));
        assertNotNull(lastName);
        WebElement phoneEmail = driver.findElement(By.xpath("//input[@name ='reg_email__']"));
        assertNotNull(phoneEmail);
        WebElement newPassElement = driver.findElement(By.xpath("//input[@type ='password']"));
        assertNotNull(newPassElement);
        WebElement birthMonth = driver.findElement(By.xpath("//select[@name ='birthday_month']"));
        assertNotNull(birthMonth);
        WebElement birthDay = driver.findElement(By.xpath("//select[@name ='birthday_day']"));
        assertNotNull(birthDay);
        WebElement birthYear = driver.findElement(By.xpath("//select[@name ='birthday_year']"));
        assertNotNull(birthYear);
        WebElement genderFemale = driver.findElement(By.xpath("//label[text()='Female']"));
        assertNotNull(genderFemale);
        WebElement genderMale = driver.findElement(By.xpath("//label[text()='Male']"));
        assertNotNull(genderMale);
        WebElement genderCustom = driver.findElement(By.xpath("//label[text()='Custom']"));
        assertNotNull(genderCustom);
        genderCustom.click();
        WebElement selectPronoun = driver.findElement(By.xpath("//select[@aria-label='Select your pronoun']"));
        assertNotNull(selectPronoun);
        WebElement Gender = driver.findElement(By.xpath("//input[@aria-label ='Gender (optional)']"));
        assertNotNull(Gender);
        WebElement signUpButton = driver.findElement(By.xpath("//button[@type='submit']"));
        assertNotNull(signUpButton);

    }


    @Test
    public void allValidDataTest ()throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Valentina");

        driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys("Kosar");

        driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("valia.kosar@gmail.com");

        driver.findElement(By.xpath("//input[@name ='reg_email_confirmation__']")).sendKeys("valia.kosar@gmail.com");

        driver.findElement(By.id("password_step_input")).sendKeys("Sterteo!1234!");

        driver.findElement(By.xpath("//select[@name ='birthday_month']")).sendKeys("Jan");

        driver.findElement(By.xpath("//select[@name ='birthday_day']")).sendKeys("25");

        driver.findElement(By.xpath("//select[@name ='birthday_year']")).sendKeys("2000");

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(10000);
        String actualResult=driver.getTitle();
        String expectedResult="Enter the code from your email";
        assertEquals(expectedResult, actualResult, "Titles do not match");

    }
    @ParameterizedTest
    @ValueSource(strings = {"", "1234567","!@#Okjh"})
    public void invalidNameTest (String a) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(a);

        driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys("Smith");

        driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("johnsmith@gmail.com");

        driver.findElement(By.xpath("//input[@name ='reg_email_confirmation__']")).sendKeys("johnsmith@gmail.com");

        driver.findElement(By.id("password_step_input")).sendKeys("Teast1234!");


        driver.findElement(By.xpath("//select[@name ='birthday_month']")).sendKeys("Jan");

        driver.findElement(By.xpath("//select[@name ='birthday_day']")).sendKeys("25");

        driver.findElement(By.xpath("//select[@name ='birthday_year']")).sendKeys("2002");

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(10000);

        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_FACEBOOK, actualURL, "url do not match");

    }
    
@ParameterizedTest
    @ValueSource(strings = {"", "12jh67","!@#Okjh"})
    public void invalidLastNameTest (String b) throws InterruptedException {
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(b);

        driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys("Smith");

        driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("johnsmith@gmail.com");

        driver.findElement(By.xpath("//input[@name ='reg_email_confirmation__']")).sendKeys("johnsmith@gmail.com");

        driver.findElement(By.id("password_step_input")).sendKeys("Teast1234!");

        driver.findElement(By.xpath("//select[@name ='birthday_month']")).sendKeys("Jan");

        driver.findElement(By.xpath("//select[@name ='birthday_day']")).sendKeys("25");

        driver.findElement(By.xpath("//select[@name ='birthday_year']")).sendKeys("2002");

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.name("websubmit")).click();
        Thread.sleep(10000);

        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_FACEBOOK, actualURL, "url do not match");

    }


}

