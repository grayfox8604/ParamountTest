package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProjectPage {
    WebDriver driver;
    private static WebElement element = null;
    private static By logoutButton = By.xpath ("//li[2]/a");
    private static By searchTextField = By.id ("search");
    private static By searchBttn = By.xpath ("//button[contains(.,'Search')]");
    private static By addProjectButton = By.xpath ("//a[contains(text(),'Add Project')]");
    private static By projectNameField = By.xpath("//div[@id='project-new-page']/div/form/div/div/input");
    private static By projectSCField = By.xpath("(//input[@type='text'])[3]");
    private static By projectTCField = By.xpath("//div[2]/input");
    private static By projectSubmitButton = By.xpath("//button[@type='submit']");
    private static By logoBannerButton = By.id("logo");
    private static By projectNameBanner = By.xpath("//*[@id=\"searches-page\"]/div/ul/li/h4");

    public ProjectPage (WebDriver driver){
        this.driver = driver;
    }

    public static WebElement logOut (WebDriver driver){
        element = driver.findElement(logoutButton);
        return element;
    }

    public static WebElement searchBar (WebDriver driver){
        element = driver.findElement(searchTextField);
        return element;
    }
    public static WebElement searchButton (WebDriver driver){
        element = driver.findElement(searchBttn);
        return element;
    }

    public static WebElement addProject (WebDriver driver){
        element = driver.findElement(addProjectButton);
        return element;
    }

    public static WebElement addProjectName (WebDriver driver){
        element = driver.findElement(projectNameField);
        return element;
    }

    public static WebElement addProjectSC (WebDriver driver){
        element = driver.findElement(projectSCField);
        return element;
    }

    public static WebElement addProjectTC (WebDriver driver){
        element = driver.findElement(projectTCField);
        return element;
    }

    public static WebElement submitProjectButton (WebDriver driver){
        element = driver.findElement(projectSubmitButton);
        return element;
    }

    public static WebElement logoButton (WebDriver driver){
        element = driver.findElement(logoBannerButton);
        return element;
    }

    public static WebElement projectNameText (WebDriver driver){
        element = driver.findElement((projectNameBanner));
        return element;
    }
}
