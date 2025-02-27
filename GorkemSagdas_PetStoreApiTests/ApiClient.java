package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ApiClient {
    private static final String BASE_URL = "https://petstore.swagger.io/v2";

    public static Response deletePet(int petId) {
        return RestAssured.given()
                .accept("application/json")
                .when()
                .delete(BASE_URL + "/pet/" + petId);
    }
}