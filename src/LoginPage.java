import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    @Test
    public void site_header_is_on_home_page() {
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "/Users/bserrato/ChromeDriver");
        driver.get("http://saucelabs.com");
        driver.close();
    }
}
