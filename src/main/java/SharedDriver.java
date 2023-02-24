import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class SharedDriver {

    private static WebDriver webDriver;
    public static WebDriver getWebDriver(){
        if(webDriver==null){
        WebDriverManager.firefoxdriver().setup();
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(1,TimeUnit.SECONDS);


        }
        return webDriver;
    }
    public static void closeDriver(){
        if(webDriver!=null){
        webDriver.close();
    }

    }
}
