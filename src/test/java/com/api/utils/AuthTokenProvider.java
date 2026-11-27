package com.api.utils;

import com.api.request.model.UserCredentials;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class AuthTokenProvider {

    private AuthTokenProvider(){}

    public static String getToken(){

        UserCredentials userCredentials=new UserCredentials("iamfd","password");

        String token =given()
                .baseUri(ConfigManager.getProperty("BASE_URI"))
                .contentType(ContentType.JSON)
                .body(userCredentials)
                .when()
                .post("login")
                .then()
                .extract()
                .body()
                .jsonPath()
                .getString("data.token");

        return token;
    }

}
