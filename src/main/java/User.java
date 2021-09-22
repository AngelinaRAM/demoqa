import org.apache.commons.lang3.RandomStringUtils;

public class User {

    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static User createRandomUser() {
        return new User(RandomStringUtils.randomAlphabetic(8), RandomStringUtils.randomAlphanumeric(8));
    }

}
