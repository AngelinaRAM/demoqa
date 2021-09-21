import org.apache.commons.lang3.RandomStringUtils;

public class Isbn {

    private String generateIsbn() {
        return RandomStringUtils.randomNumeric(13);
    }



}
