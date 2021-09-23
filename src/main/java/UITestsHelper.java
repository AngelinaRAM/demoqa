import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class UITestsHelper {

    private static WebDriver webDriver;
    private static final String URL = "https://demoqa.com/books";

    public static WebDriver getWebDriver() {
        return webDriver;
    }

    public static void setWebDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        webDriver = new ChromeDriver();
        webDriver.get(URL);
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.addExtensions(new File("src/main/resources/Crx4Chrome.com.crx"));
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().setScriptTimeout(5, TimeUnit.SECONDS);
    }

}
