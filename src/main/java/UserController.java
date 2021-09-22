import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class UserController {

    private final RequestSpecification requestSpecification; //Создали переменную для инициализации реквестов
    private final Gson mapper; //Создали переменную для сериализации/десериализации объекта User

    public UserController(RequestSpecification requestSpecification, Gson mapper) {
        this.requestSpecification = requestSpecification;
        this.mapper = mapper;
    }

    public UserController() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://demoqa.com/swagger/");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        this.mapper = new Gson();
    }

    public Response createUser(User user) {
        String userRow = mapper.toJson(user);
        return given(requestSpecification).body(user).post("Account/v1/User");
    }

}
