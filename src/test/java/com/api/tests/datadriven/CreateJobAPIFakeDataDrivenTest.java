package com.api.tests.datadriven;

import com.api.request.model.CreateJobPayload;
import com.api.utils.SpecUtil;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateJobAPIFakeDataDrivenTest {

    @Test(description = "verify if create job API is able to create in warrenty job",
            groups ={"api","regression","smoke","datadriven"},
            dataProviderClass = com.dataproviders.DataProviderUtils.class,
            dataProvider = "CreateJobFakerDataProvider")
    public void createJobAPITest(CreateJobPayload createJobPayload){

        given()
                .spec(SpecUtil.requestSpecwithAuth(createJobPayload))
                .when()
                .post("/job/create")
                .then()
                .spec(SpecUtil.responseSpec());
    }
}
