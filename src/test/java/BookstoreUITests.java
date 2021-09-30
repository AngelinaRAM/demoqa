import com.codeborne.selenide.Configuration;
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


    @BeforeAll
    static void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 3000;
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
        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("git");
        //ToDo Дописать проверку, что отображаются результаты
    }

    @Test
    public void seeBookInfoTest() {
        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("Git Pocket Guide");
        BooksPage.seeGitBookLink();
    }

    @Test
    public void backToBookStoreTest() {
        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("Git Pocket Guide");
        BooksPage.seeGitBookLink();
        BooksPage.backToBookStore();
        webdriver().shouldHave(url("https://demoqa.com/books"));
    }

    @Test
    public void addToYourCollectionTest() {
        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("java");
        BooksPage.seeSpeakingJavaScriptBookLink();
        BooksPage.addToYourCollection();
        //ToDo Дописать "клик на ОК" в попап окне "Книга добавлена"
        //ToDo Дописать проверку, что книга добавилась в коллекцию
    }

    @Test
    public void deleteBookTest() {
        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("git");
        BooksPage.seeGitBookLink();
        BooksPage.addToYourCollection();
        ProfilePage profilePage = open("https://demoqa.com/profile", ProfilePage.class);
        ProfilePage.deleteBook();
        ProfilePage.closeModalByOk();
        //ToDo Дописать "клик на ОК" в попап окне "Книга удалена"
        //ToDo Дописать проверку, что книга удалилась из коллекции
    }

    @Test
    public void deleteAllBooksTest() {
        BooksPage booksPage = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("java");
        BooksPage.seeLearningJavaScriptDesignPatternsLink();
        BooksPage.addToYourCollection();
        BooksPage booksPage1 = open("https://demoqa.com/books", BooksPage.class);
        BooksPage.inputInSearchBox("Git Pocket Guide");
        BooksPage.seeGitBookLink();
        BooksPage.addToYourCollection();
        ProfilePage profilePage = open("https://demoqa.com/profile", ProfilePage.class);
        ProfilePage.deleteAllBooks();
        ProfilePage.closeModalByOk();
        //ToDo Дописать проверку что ВСЕ книги удалились
    }

    @Test
    public void gotoStoreFromProfileTest() {
        ProfilePage profilePage = open("https://demoqa.com/profile", ProfilePage.class);
        ProfilePage.gotoStore();
        webdriver().shouldHave(url("https://demoqa.com/books"));
    }

}
