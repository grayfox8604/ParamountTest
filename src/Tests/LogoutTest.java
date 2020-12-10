package Tests;

import Pages.ProjectPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static Tests.LoginTest.paramountLoginTest;

/*This Logout Test class allows the user to test the Logout functionality of the Paramount app.
* Given that the main logout method is public, it allows the user the versatility of using the logout
* feature in any test that they need. */

public class LogoutTest {
    private static WebDriver driver = null;

    public static void main(String [] args) throws InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/bserrato/ChromeDriver/chromedriver");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://paramount-demo.frogslayerdev.com");
        paramountLoginTest(driver);
        paramountProjectPageLogout(driver);
    }

    public static void paramountProjectPageLogout(WebDriver driver) throws InterruptedException {
        ProjectPage logout = new ProjectPage(driver);
        Thread.sleep(3000);
        logout.logOut(driver).click();
        System.out.println("I have logged out!");
        driver.close();
    }
}
