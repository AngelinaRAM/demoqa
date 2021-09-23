import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookstoreUITests {

    @BeforeAll
    public static void webDriverSet() {
        UITestsHelper.setWebDriver();
    }

    @AfterAll
    public static void afterAll() {
        UITestsHelper.getWebDriver().quit();
    }

    @Test
    public void demoTest() {

    }

}
