package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*This independent LoginTest class allows a user to log into the Paramount application with the given credentials.
* Given that it has a public method, we can run the test independently or as part of another group of tests.  */

public class LoginTest {
    private static WebDriver driver = null;

    public static void main(String [] args){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/bserrato/ChromeDriver/chromedriver");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://paramount-demo.frogslayerdev.com");
        paramountLoginTest(driver);
        driver.close();
    }

    public static void paramountLoginTest(WebDriver driver) {
        LoginPage login = new LoginPage(driver);
        login.userNameBox(driver).sendKeys("larry.test@frogslayer.com");
        login.passwordBox(driver).sendKeys("P@ssword1");
        login.loginButton(driver).click();
        System.out.println("I have logged in!");
    }
}
