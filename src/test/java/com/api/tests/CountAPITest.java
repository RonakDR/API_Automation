package com.api.tests;

import com.api.utils.AuthTokenProvider;
import com.api.utils.ConfigManager;
import com.api.utils.SpecUtil;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class CountAPITest {

    @Test(description = "Checking positive response for count API with Authorisation",groups = {"api","regression","smoke"})
    public void verifyCountAPIResponse(){

        given()
                .spec(SpecUtil.requestSpecwithAuth())
                .when()
                .get("/dashboard/count")
                .then()
                .spec(SpecUtil.responseSpec())
                .body("message", Matchers.equalTo("Success"))
                .body("data.size()", Matchers.equalTo(3))
                .body("data.count", Matchers.everyItem(Matchers.greaterThanOrEqualTo(0)));
    }

    @Test(description = "Checking negative response for master API without Authorisation",groups = {"api","regression","smoke"})
    public void countAPIResponse_MissingAuth(){

        given()
                .spec(SpecUtil.requestSpec())
//                .header("Authorization", AuthTokenProvider.getToken())
                .when()
                .get("/dashboard/count")
                .then()
                .spec(SpecUtil.responseSpec_TEXT(401));
    }
}
