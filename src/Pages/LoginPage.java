package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;
    private static WebElement element = null;
    private static By loginBtn = By.cssSelector(".btn-primary");
    private static By userNameBoxPath = By.xpath("//input[@type=\'email\']");
    private static By passwordBoxPath = By.xpath("//input[@type=\'password\']");

    public LoginPage (WebDriver driver){
        this.driver = driver;
    }

    public static WebElement userNameBox(WebDriver driver){
        element = driver.findElement(userNameBoxPath);
        return element;
    }

    public static WebElement passwordBox(WebDriver driver) {
        element = driver.findElement(passwordBoxPath);
        return element;
    }

    public static WebElement loginButton (WebDriver driver){
        element = driver.findElement(loginBtn);
        return element;
    }
}
