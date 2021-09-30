import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Modal;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.AuthPage;
import pages.BooksPage;
import pages.ProfilePage;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class BookstoreUITests {

    static Modal modal;

    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 3000;
        modal = new Modal(webdriver().driver());
    }

    /*
    @AfterAll
    public static void afterAll() {
        UITestsHelper.getWebDriver().quit();
    }
    */

    @Test
    public void loginTest() {
        AuthPage authPage = open("https://demoqa.com/login", AuthPage.class);
        AuthPage.inputUserName("angelinaram");
        AuthPage.inputPassword("Angelinaram!1");
        AuthPage.clickButton();
        webdriver().shouldHave(url("https://demoqa.com/profile"));
    }

    @Test
    public void findBookTest() {
        String bookName = "Git Pocket Guide";

        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox(bookName);
        BooksPage.viewSearchResults(bookName);
    }

    @Test
    public void seeBookInfoTest() {
        String bookName = "Git Pocket Guide";

        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox(bookName);
        BooksPage.seeBookInfo(bookName);
    }

    @Test
    public void backToBookStoreTest() {
        String bookName = "Git Pocket Guide";

        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("Git Pocket Guide");
        BooksPage.seeBookInfo(bookName);
        BooksPage.backToBookStore();
        webdriver().shouldHave(url("https://demoqa.com/books"));
    }

    @Test
    public void addToYourCollectionTest() {
        String bookName = "Speaking JavaScript"; //Книга, с которой работаем в данном тесте

        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox(bookName);
        BooksPage.seeBookInfo(bookName);
        BooksPage.addToYourCollection();
        modal.prompt(); //Попытка закрыть дурацкое окно с дурацким ОК
        ProfilePage profilePage = open("https://demoqa.com/profile", ProfilePage.class);
        BooksPage.seeBookInfo(bookName); //Клик на название книги, с которой работаем в данном тесте
    }

    @Test
    public void deleteBookTest() {
        String bookName = "Git Pocket Guide";

        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox(bookName);
        BooksPage.seeBookInfo(bookName);
        BooksPage.addToYourCollection();
        ProfilePage profilePage = open("https://demoqa.com/profile", ProfilePage.class);
        ProfilePage.deleteBook();
        ProfilePage.closeModalByOk();
        modal.prompt(); //Попытка закрыть дурацкое окно с дурацким ОК
        ProfilePage.bookNotPresent(bookName);
    }

    @Test
    public void deleteAllBooksTest() {
        String bookName = "Git Pocket Guide";
        String bookName2 = "Learning JavaScript Design Patterns";

        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox(bookName2);
        BooksPage.seeBookInfo(bookName2);
        BooksPage.addToYourCollection();
        BooksPage booksPage1 = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox(bookName);
        BooksPage.seeBookInfo(bookName);
        BooksPage.addToYourCollection();
        ProfilePage profilePage = open("https://demoqa.com/profile", ProfilePage.class);
        ProfilePage.deleteAllBooks();
        ProfilePage.closeModalByOk();
        ProfilePage.booksNotDetected();
    }

    @Test
    public void gotoStoreFromProfileTest() {
        ProfilePage profilePage = open("https://demoqa.com/profile", ProfilePage.class);
        ProfilePage.gotoStore();
        webdriver().shouldHave(url("https://demoqa.com/books"));
    }

}
