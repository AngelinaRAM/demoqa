package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage {

    @FindBy(xpath = ".//input[@id='searchBox']")
    private static WebElement searchBoxInput;

    @FindBy(xpath = ".//span[@id='see-book-Git Pocket Guide']")
    private static WebElement seeGitBookLink;

    @FindBy(xpath = ".//span[@id='see-book-Speaking JavaScript']")
    private static WebElement seeSpeakingJavaScriptBookLink;

    @FindBy(xpath = ".//span[@id='see-book-Learning JavaScript Design Patterns']")
    private static WebElement seeLearningJavaScriptDesignPatternsLink;

    @FindBy(xpath = ".//button[text()='Back To Book Store']")
    private static WebElement backToBookStoreButton;

    @FindBy(xpath = ".//button[text()='Add To Your Collection']")
    private static WebElement addToYourCollectionButton;


    public static void inputInSearchBox(String keyword) {
        searchBoxInput.sendKeys(keyword);
    }

    public static void seeGitBookLink() {
        seeGitBookLink.click();
    }

    public static void seeSpeakingJavaScriptBookLink() {
        seeSpeakingJavaScriptBookLink.click();
    }

    public static void seeLearningJavaScriptDesignPatternsLink() {
        seeLearningJavaScriptDesignPatternsLink.click();
    }

    public static void backToBookStore() {
        backToBookStoreButton.click();
    }

    public static void addToYourCollection() {
        addToYourCollectionButton.click();
    }


}
