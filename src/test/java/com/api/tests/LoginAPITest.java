package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.pojo.UserCredentials;
import com.api.utils.ConfigManager;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test
    public void loginRequest() {

        UserCredentials userCredentials=new UserCredentials("iamfd","password");

//        baseURI= ConfigManager.getProperty("BASE_URI");

        given()
                .baseUri(ConfigManager.getProperty("BASE_URI"))
                .contentType(ContentType.JSON)
                .body(userCredentials)
                .when()
                .post("login")
                .then()
                .statusCode(200)
                .log().status()
                .body("message", Matchers.equalTo("Success"));
    }
}
