import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class TestCase {

    public static WebDriver driver = null;

    public static final String USERNAME = "oauth-nati.pstrag-9bdfd";
    public static final String ACCESS_KEY ="7953ed5b-703b-4df9-a835-6d2cf5b5ca1d";
    public static final String URL = "https://oauth-nati.pstrag-9bdfd:7953ed5b-703b-4df9-a835-6d2cf5b5ca1d@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    @BeforeClass
    public static void setup() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        ChromeOptions browserOptions = new ChromeOptions();

        caps.setCapability(ChromeOptions.CAPABILITY, browserOptions);
        caps.setCapability("os","Windows");
        caps.setCapability("os_version","10");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "latest");

        driver = new RemoteWebDriver(new URL(URL), caps);
    }

    @Test
    public void verifyLogin(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

    }
    @After
    public void after(){
        driver.close();
        driver.quit();
    }
}
