import org.apache.commons.lang3.RandomStringUtils;

public class ListOfBooks {

    private String userId;
    private Isbn[] isbn;

    public String getUserId() {
        return userId;
    }

    public Isbn[] getIsbn() {
        return isbn;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setIsbn(Isbn[] isbn) {
        this.isbn = isbn;
    }

    public ListOfBooks(String userId, Isbn[] isbn) {
        this.userId = userId;
        this.isbn = isbn;
    }

    public static ListOfBooks createListOfBooks() {
        Isbn[] arr = Isbn.generateIsbn();
        return new ListOfBooks("d64c697d-f03f-4a09-8d95-86b449b33481", arr);
    }

}
