package com.api.tests;

import com.api.request.model.CreateJobPayload;
import com.api.utils.FakerDataGenerator;
import com.api.utils.SpecUtil;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateJobAPITest {

    CreateJobPayload createJobPayload;

    @BeforeMethod
    public void setup(){
        createJobPayload= FakerDataGenerator.generateFakeCreateJobData();
    }
    //create hardcoded customer, address and product object and call API for single data
    @Test(description = "verify if create job API is able to create in warrenty job",
            groups ={"api","regression","smoke"})
    public void createJobAPITest(){

        given()
                .spec(SpecUtil.requestSpecwithAuth(createJobPayload))
                .when()
                .post("/job/create")
                .then()
                .spec(SpecUtil.responseSpec()).log().all();

    }
}
