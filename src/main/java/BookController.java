import com.fasterxml.jackson.databind.json.JsonMapper;
import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BookController {

    //Дёргает методы АПИшки

    private final RequestSpecification requestSpecification; //Создали переменную для инициализации реквестов
    private final Gson mapper; //Создали переменную для сериализации/десериализации объекта Book


    public BookController() {
        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri("https://demoqa.com/swagger/");
        requestSpecBuilder.setContentType(ContentType.JSON);
        requestSpecBuilder.log(LogDetail.ALL);
        requestSpecification = requestSpecBuilder.build();
        this.mapper = new Gson();
    }

    //методы из сваггера

    //Получаем список книг
    public Response getBooks() {
        return given(requestSpecification).get("BookStore/v1/Books");
    }

    //Добавляем новую книжку
    public Response postBooks(ListOfBooks listOfBooks) {
        String row = mapper.toJson(listOfBooks);
        return given(requestSpecification).body(row).post("BookStore/v1/Books");
    }

    //Удаляем все книжки у определенного пользователя
    public Response deleteBooks(String userId) {
        return given(requestSpecification).delete("BookStore/v1/Books" + userId);
    }

    //Изменяем isbn в имеющейся книжке?
    public Response putBook(String isbn) {
        return given(requestSpecification).put("BookStore/v1/Books/" + isbn);
    }

    //Получаем информацию по книге по isbn
    public Response getBook(String isbn) {
        return given(requestSpecification).get("BookStore/v1/Book?ISBN=" + isbn);
    }

    //Удалить книжку по isbn
    public Response deleteBookByIsbn(String isbn, String userId) {
        return given(requestSpecification).delete("BookStore/v1/Book");
    }

}