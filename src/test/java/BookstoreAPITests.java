import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookstoreAPITests {

    public BookController bookController;
    public UserController userController;
    public Book book;
    public User user;
    public ListOfBooks listOfBooks;

    @BeforeEach
    public void setup() {
        this.bookController = new BookController();
        this.userController = new UserController();
    }

    @Test
    @DisplayName("getBook")
    public void getBook() {
        Response response = bookController.getBooks();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("PostBook")
    public void postBook() {
        ListOfBooks list = ListOfBooks.createListOfBooks();
        Response response = bookController.postBooks(list);
        Assertions.assertEquals(200, response.getStatusCode());
    }

    /*
    @Test
    @DisplayName("DeleteBooks")
    public void deleteBooks() {
        User user = User.createRandomUser();
        userController.createUser(user);
        Response response = bookController.deleteBooks() //Тут нужен юзерИД в скобках
    }
    */

    @Test
    @DisplayName("putBook")
    public void putBook() {
        ListOfBooks list = ListOfBooks.createListOfBooks();
        Response response = bookController.postBooks(list);
        Isbn isbn = response.getBody().as(Isbn.class);
        Response response1 = bookController.putBook(isbn.getIsbn());
        Assertions.assertEquals(200, response1.getStatusCode());
    }

}
