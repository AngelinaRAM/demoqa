import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BookstoreAPITests {

    public BookController bookController;
    public Book book;
    public User user;
    public ListOfBooks listOfBooks;

    @BeforeEach
    public void setup() {
        this.bookController = new BookController();
    }

    @Test
    @DisplayName("getBook")
    public void getBook() {
        Response response = bookController.getBooks();
        Assertions.assertEquals(200, response.getStatusCode());
    }

    @Test
    @DisplayName("PostBook")
    Response response = bookController.postBooks(listOfBooks);


}
