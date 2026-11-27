package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.pojo.UserCredentials;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class LoginAPITest {

    @Test
    public void loginRequest() {

        UserCredentials userCredentials=new UserCredentials("iamfd","password");

        given()
                .spec(SpecUtil.requestSpec(userCredentials))
                .when()
                .post("login")
                .then()
                .spec(SpecUtil.responseSpec())
                .log().status()
                .body("message", Matchers.equalTo("Success"));
    }
}
