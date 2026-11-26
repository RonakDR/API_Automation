package com.api.tests;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CountAPITest {

    @Test
    public void verifyCountAPIResponse(){

        given()
                .baseUri(ConfigManager.getProperty("BASE_URI"))
                .contentType(ContentType.JSON)
                .header("Authorization", AuthTokenProvider.getToken())
                .when()
                .get("/dashboard/count")
                .then()
                .statusCode(200)
                .body("message", Matchers.equalTo("Success"))
                .time(Matchers.lessThan(1000L))
                .body("data.size()", Matchers.equalTo(3))
                .body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)));
    }

    @Test
    public void countAPIResponse_MissingAuth(){

        given()
                .baseUri(ConfigManager.getProperty("BASE_URI"))
                .contentType(ContentType.JSON)
//                .header("Authorization", AuthTokenProvider.getToken())
                .when()
                .get("/dashboard/count")
                .then()
                .statusCode(401);
    }
}
