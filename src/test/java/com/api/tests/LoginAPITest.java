package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.request.model.UserCredentials;
import com.api.utils.SpecUtil;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAPITest {
    UserCredentials userCredentials;
    @BeforeMethod
    public void  setup(){
        userCredentials=new UserCredentials("iamfd","password");

    }

    @Test(description = "Verifying if login API is working for the provided users",groups = {"api","regression","smoke"})
    public void loginRequest() {

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
