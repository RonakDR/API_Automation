package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class MasterAPITest {

    @Test
    public void masterAPITest(){

        given()
                .baseUri(ConfigManager.getProperty("BASE_URI"))
                .contentType("")
                .header("Authorization", AuthTokenProvider.getToken())
                .when()
                .post("master")
                .then()
                .statusCode(200)
                .time(Matchers.lessThan(1000L))
                .body("message",Matchers.equalTo("Success"));

    }

    @Test
    public void masterAPITest_Negative(){

        given()
                .baseUri(ConfigManager.getProperty("BASE_URI"))
                .contentType("")
//                .header("Authorization", AuthTokenProvider.getToken())
                .when()
                .post("master")
                .then()
                .statusCode(401);

    }
}
