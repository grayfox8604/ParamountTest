package Tests;

import Pages.LoginPage;
import Pages.ProjectPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/*This version of the tests are fully contained within this file, but are similar to the independent classes.
*One of the enhancements of this style is that we get better reporting when the tests are run and should one test fail,
* it does not mean that all of the project will stop.*/

public class FullParamountTests {
    WebDriver driver = null;
    public static String projectName = "BS Test " + Math.floor(Math.random() * Math.floor(99));

    @Before
    public void setup(){
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/bserrato/ChromeDriver/chromedriver");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://paramount-demo.frogslayerdev.com");
    }

    @After
    public void close(){
        driver.close();
    }

    @Test
    public void login(){
        LoginPage login = new LoginPage(driver);
        login.userNameBox(driver).sendKeys("larry.test@frogslayer.com");
        login.passwordBox(driver).sendKeys("P@ssword1");
        login.loginButton(driver).click();
        System.out.println("I have logged in!");
    }

    @Test
    public void loginAndLogout() throws InterruptedException {
        ProjectPage logout = new ProjectPage(driver);
        login();
        Thread.sleep(3000);
        logout.logOut(driver).click();
        System.out.println("I have logged out!");
    }

    @Test
    public void addAndSearchForAProject() throws InterruptedException {
        ProjectPage addition = new ProjectPage(driver);
        login();
        Thread.sleep(3000);
        addition.addProject(driver).click();
        addition.addProjectName(driver).sendKeys(projectName);
        addition.addProjectSC(driver).sendKeys("1000");
        addition.addProjectTC(driver).sendKeys("2000");
        addition.submitProjectButton(driver).click();
        System.out.println("I have added a new project called " + projectName);
        Thread.sleep(1000);
        addition.logoButton(driver).click();
        Thread.sleep(1000);
        addition.searchBar(driver).sendKeys(projectName);
        Thread.sleep(2000);
        addition.searchButton(driver).click();
        addition.searchButton(driver).click();
        System.out.println("I have found the project that I just created");
        String projectNameCompare = addition.projectNameText(driver).getText();
        Assert.assertEquals(projectNameCompare,projectName);
        System.out.println("The names are a match " + projectNameCompare + " = " + projectName);
    }
}
