import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;

public class ListOfBooks {

    private String userId;
    private String[] isbn;

    public String getUserId() {
        return userId;
    }

    public String[] getIsbn() {
        return isbn;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setIsbn(String[] isbn) {
        this.isbn = isbn;
    }

    public ListOfBooks(String userId, String[] isbn) {
        this.userId = RandomStringUtils.randomAlphanumeric(8);
        this.isbn = new Isbn[] {new }
    }




}
