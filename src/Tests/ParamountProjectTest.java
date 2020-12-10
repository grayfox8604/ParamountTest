package Tests;

import Pages.ProjectPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import static Tests.LoginTest.paramountLoginTest;
import static Tests.LogoutTest.paramountProjectPageLogout;

/*This Paramount Project test is designed to test the ability of adding a project to the Paramount list. Once added, the
* test will then run a search for the newly created project and check if the titles match up. */

public class ParamountProjectTest {
    private static WebDriver driver = null;
    public static String projectName = "BS Test " + Math.floor(Math.random() * Math.floor(99));

    public static void main(String [] args) throws InterruptedException {
        driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/bserrato/ChromeDriver/chromedriver");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://paramount-demo.frogslayerdev.com");
        paramountProjectPageAdditionTest();
        paramountProjectPageSearchTest();
    }

    private static void paramountProjectPageSearchTest() throws InterruptedException{
        ProjectPage search = new ProjectPage(driver);

        //Click on the search bar and look for the project
        Thread.sleep(1000);
        search.logoButton(driver).click();
        Thread.sleep(1000);
        search.searchBar(driver).sendKeys(projectName);
        Thread.sleep(2000);
        search.searchButton(driver).click();
        search.searchButton(driver).click();
        System.out.println("I have found the project that I just created");

        //Assert that the text in the banner and the text of the created project are the same
        String projectNameCompare = search.projectNameText(driver).getText();
        Assert.assertEquals(projectNameCompare,projectName);
        System.out.println("The names are a match " + projectNameCompare + " = " + projectName);

        //Log out
        System.out.println("Time to log out!");
        paramountProjectPageLogout(driver);
    }
    private static void paramountProjectPageAdditionTest() throws InterruptedException{
        ProjectPage addition = new ProjectPage(driver);

        //Login to the app
        paramountLoginTest(driver);
        Thread.sleep(3000);

        //Add a project
        addition.addProject(driver).click();
        addition.addProjectName(driver).sendKeys(projectName);
        addition.addProjectSC(driver).sendKeys("1000");
        addition.addProjectTC(driver).sendKeys("2000");
        addition.submitProjectButton(driver).click();
        System.out.println("I have added a new project called " + projectName);
    }

}
