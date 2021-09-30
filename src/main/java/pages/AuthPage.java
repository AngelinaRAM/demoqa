package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthPage {

    @FindBy(xpath = ".//button[@id='login']")
    private static WebElement loginButton;

    @FindBy(xpath = ".//input[@id='userName']")
    private static WebElement userNameInput;

    @FindBy(xpath = ".//input[@id='password']")
    private static WebElement passwordInput;

    public static void inputUserName(String userName) {
        userNameInput.sendKeys(userName);
    }

    public static  void inputPassword(String password) {
        passwordInput.sendKeys(password);
    }

    public static void clickButton() {
        loginButton.click();
    }
}
