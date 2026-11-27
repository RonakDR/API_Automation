package com.api.tests;

import static io.restassured.RestAssured.*;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class MasterAPITest {

    @Test(description = "Checking positive response for master API with Authorisation",groups = {"api","regression","smoke"})
    public void masterAPITest(){

        given()
                .spec(SpecUtil.requestSpecwithAuth())
                .when()
                .post("master")
                .then()
                .spec(SpecUtil.responseSpec())
                .body("message",Matchers.equalTo("Success"));

    }

    @Test(description = "Checking negative response for master API without Authorisation",groups = {"api","regression","smoke"})
    public void masterAPITest_Negative(){

        given()
                .spec(SpecUtil.requestSpec())
//                .header("Authorization", AuthTokenProvider.getToken())
                .when()
                .post("master")
                .then()
                .spec(SpecUtil.responseSpec_TEXT(401));

    }
}
