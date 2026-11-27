package com.api.tests.datadriven;

import com.api.dataproviders.bean.UserBean;
import com.api.request.model.UserCredentials;
import com.api.utils.SpecUtil;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoginAPITestDataDrivenTest {

    @Test(description = "Verifying if login API is working for the provided users",
            groups = {"api","regression","smoke"},
            dataProviderClass=com.dataproviders.DataProviderUtils.class,
            dataProvider="LoginAPIDataProvider")
    public void loginRequest(UserBean userBean) {

        given()
                .spec(SpecUtil.requestSpec(userBean))
                .when()
                .post("login")
                .then()
                .spec(SpecUtil.responseSpec())
                .log().status()
                .body("message", Matchers.equalTo("Success"));
    }
}
