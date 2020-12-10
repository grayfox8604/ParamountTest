package Tests;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginTest {
    private static WebDriver driver = null;

    public static void main(String [] args) throws InterruptedException {
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
