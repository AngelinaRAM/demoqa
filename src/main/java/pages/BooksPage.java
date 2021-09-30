package pages;
import com.codeborne.selenide.CollectionCondition;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class BooksPage {

    @FindBy(xpath = ".//input[@id='searchBox']")
    private static WebElement searchBoxInput;

    @FindBy(xpath = ".//button[text()='Back To Book Store']")
    private static WebElement backToBookStoreButton;

    @FindBy(xpath = ".//button[text()='Add To Your Collection']")
    private static WebElement addToYourCollectionButton;

    public static void inputInSearchBox(String keyword) {
        searchBoxInput.sendKeys(keyword);
    }

    public static void backToBookStore() {
        backToBookStoreButton.click();
    }

    public static void addToYourCollection() {
        addToYourCollectionButton.click();
    }

    public static void viewSearchResults(String bookName) {
        $$(".rt-table").shouldHave(CollectionCondition.textsInAnyOrder(bookName));
    }

    public static void seeBookInfo(String bookName) {
        $(By.xpath(String.format(".//span[@id='see-book-%s']", bookName))).click();
    }

}
