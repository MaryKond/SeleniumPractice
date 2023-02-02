import dev.failsafe.internal.util.Assert;
import org.junit.jupiter.api.*;
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
    }


//    @ParameterizedTest
//    @ValueSource(ints={-10,0,27,36677})
//    public void mobileNumberOrEmail(){


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

//        public void firstName(String name){
//            WebElement firstName=driver.findElement(By.xpath("//input[@name='firstname']"));
//            assertNotNull(firstName);
//            firstName.click();
//            firstName.sendKeys(name);
//            String firstNameValue= firstName.getAttribute("value");
//            assertEquals(name,firstNameValue);

//       }
//    @Test
//    public void allValidDataTest (){
//        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Kater");
//
//        driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys("Mokarova");
//
//        driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("kater.mokarova@gmail.com");
//
//        driver.findElement(By.xpath("//input[@name ='reg_email_confirmation__']")).sendKeys("kater.mokarova@gmail.com");
//
//        driver.findElement(By.id("password_step_input")).sendKeys("Teast1234!");
//
//        driver.findElement(By.xpath("//select[@name ='birthday_month']")).sendKeys("Jan");
//
//        driver.findElement(By.xpath("//select[@name ='birthday_day']")).sendKeys("25");
//
//        driver.findElement(By.xpath("//select[@name ='birthday_year']")).sendKeys("2002");
//
//        driver.findElement(By.xpath("//label[text()='Female']")).click();
//
//        driver.findElement(By.name("websubmit")).click();
//
////        String expectedURL = "https://www.facebook.com/confirmemail";
////        String actualURL = driver.getCurrentUrl();
////        assertTrue(actualURL.contains(expectedURL));
//        String expectedTitle = "Enter the code from your email";//
//        String actualTitle = driver.getTitle();//
//        assertEquals(actualTitle, expectedTitle);//
//
//        driver.get(HOME_PAGE_FACEBOOK);
//
//    }


    @ParameterizedTest
    @ValueSource(strings = {"", "1234567","!@#Okjh"})
    public void nameInvalidFieldTest (){
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("");

        driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys("Kosarevichf");

        driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("olga.kosarevichf@gmail.com");

        driver.findElement(By.xpath("//input[@name ='reg_email_confirmation__']")).sendKeys("olga.kosarevichf@gmail.com");

        driver.findElement(By.id("password_step_input")).sendKeys("Teast1234!");

        driver.findElement(By.xpath("//select[@name ='birthday_month']")).sendKeys("Jan");

        driver.findElement(By.xpath("//select[@name ='birthday_day']")).sendKeys("25");

        driver.findElement(By.xpath("//select[@name ='birthday_year']")).sendKeys("2002");

        driver.findElement(By.xpath("//label[text()='Female']")).click();

        driver.findElement(By.name("websubmit")).click();

        String expectedURL = "https://www.facebook.com/";
        String actualURL = driver.getCurrentUrl();
        assertEquals(expectedURL,actualURL);
        driver.get(HOME_PAGE_FACEBOOK);

    }
//    @Test
//    public void lastNameEmptyFieldTest (){
//        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("John");
//
//        driver.findElement(By.xpath("//input[@name ='lastname']")).sendKeys("");
//
//        driver.findElement(By.xpath("//input[@name ='reg_email__']")).sendKeys("johnsmith@gmail.com");
//
//        driver.findElement(By.xpath("//input[@name ='reg_email_confirmation__']")).sendKeys("johnsmith@gmail.com");
//
//        driver.findElement(By.id("password_step_input")).sendKeys("Teast1234!");
//
//        driver.findElement(By.xpath("//select[@name ='birthday_month']")).sendKeys("Jan");
//
//        driver.findElement(By.xpath("//select[@name ='birthday_day']")).sendKeys("25");
//
//        driver.findElement(By.xpath("//select[@name ='birthday_year']")).sendKeys("2002");
//
//        driver.findElement(By.xpath("//label[text()='Female']")).click();
//
//        driver.findElement(By.name("websubmit")).click();
//
//        String expectedURL = "https://www.facebook.com/";
//        String actualURL = driver.getCurrentUrl();
//        assertEquals(expectedURL,actualURL);
//        driver.get(HOME_PAGE_FACEBOOK);
//
//    }









//  driver.findElement(By.xpath("//*[text()='Create new account']")).click();
//  Thread.sleep(1000);


        }

