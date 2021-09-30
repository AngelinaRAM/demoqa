package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

}
