package pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Conditional;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ProfilePage {

    @FindBy(xpath = ".//span[@id='delete-record-undefined']")
    private static WebElement deleteBookButton;

    @FindBy(xpath = ".//button[@id='closeSmallModal-ok']")
    private static WebElement closeModalByOk;

    @FindBy(xpath = ".//button[text()='Delete All Books']")
    private static WebElement deleteAllBooksButton;

    @FindBy(xpath = ".//button[@id='gotoStore']")
    private static WebElement gotoStoreButton;

    public static void deleteBook() {
        deleteBookButton.click();
    }

    public static void closeModalByOk() {
        closeModalByOk.click();
    }

    public static void deleteAllBooks() {
        deleteBookButton.click();
    }

    public static void gotoStore() {
        gotoStoreButton.click();
    }

    public static void booksNotDetected() {
        $$(".rt-table").shouldHave(CollectionCondition.size(0)); //Должен иметь 0 элементов
    }

    public static void bookNotPresent(String bookName) {
        $(By.xpath(String.format(".//span[@id='see-book-%s']", bookName))).shouldNotHave(Condition.visible);
    }

}
