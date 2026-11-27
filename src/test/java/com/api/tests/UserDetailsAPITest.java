package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import java.io.IOException;

public class UserDetailsAPITest {

    @Test
    public void userDetailRequest() throws IOException {
//        Header header=new Header("Authorization","");

        given()
                .spec(SpecUtil.requestSpecwithAuth())
                .when()
                .get("userdetails")
                .then()
                .spec(SpecUtil.responseSpec())
                .log().status();
    }
}
