package Tests;

import Pages.LoginPage;
import Pages.ProjectPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ParamountTest {
    private static WebDriver driver = null;
    public static String projectName = "BS Test " + Math.floor(Math.random() * Math.floor(99));

    public static void main(String [] args) throws InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/bserrato/ChromeDriver/chromedriver");
//        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://paramount-demo.frogslayerdev.com");
//        paramountLoginTest(driver);
        paramountProjectPageAdditionTest();
        paramountProjectPageSearchTest();
//        paramountProjectPageLogout();

    }

    public static WebDriver paramountLoginTest(WebDriver driver) {
        LoginPage login = new LoginPage(driver);
        login.userNameBox(driver).sendKeys("larry.test@frogslayer.com");
        login.passwordBox(driver).sendKeys("P@ssword1");
        login.loginButton(driver).click();
        return driver;
    }

    private static void paramountProjectPageSearchTest() throws InterruptedException{
        ProjectPage search = new ProjectPage(driver);
        Thread.sleep(1000);
        search.logoButton(driver).click();
        Thread.sleep(1000);
        search.searchBar(driver).sendKeys(projectName);
//        Thread.sleep(1000);
        search.searchButton(driver).click();
        search.searchButton(driver).click();

        driver.close();

    }
    private static void paramountProjectPageAdditionTest() throws InterruptedException{
        ProjectPage addition = new ProjectPage(driver);
        paramountLoginTest(driver);
        Thread.sleep(5000);
        addition.addProject(driver).click();
        addition.addProjectName(driver).sendKeys(projectName);
        addition.addProjectSC(driver).sendKeys("1000");
        addition.addProjectTC(driver).sendKeys("2000");
        addition.submitProjectButton(driver).click();


    }
    private static void paramountProjectPageLogout() throws InterruptedException {
        ProjectPage logout = new ProjectPage(driver);
        paramountLoginTest(driver);
        logout.logOut(driver).click();
        driver.close();
    }
}
