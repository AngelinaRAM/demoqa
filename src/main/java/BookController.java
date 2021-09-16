import com.fasterxml.jackson.databind.json.JsonMapper;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BookController {

    //Дёргает методы АПИшки

    private final RequestSpecification requestSpecification; //Создали переменную для инициализации реквестов
    private final JsonMapper mapper; //Создали переменную для сериализации/десериализации объекта Book


    public BookController(JsonMapper mapper) {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://demoqa.com/swagger/");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        this.mapper = new JsonMapper();
    }

    //методы из сваггера

    public Response getBooks {
        return given(requestSpecification).get("BookStore/v1/Books");
    }

}