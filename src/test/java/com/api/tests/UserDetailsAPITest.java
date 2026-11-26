package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserDetailsAPITest {

    @Test
    public void userDetailRequest() throws IOException {
//        Header header=new Header("Authorization","");

        given()
                .baseUri(ConfigManager.getProperty("BASE_URI"))
                .header("Authorization",AuthTokenProvider.getToken())
                .contentType(ContentType.JSON)
                .when()
                .get("userdetails")
                .then()
                .statusCode(200)
                .log().status();
    }
}
