package com.api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;

public class SpecUtil {

    public static RequestSpecification requestSpec(){

        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getProperty("BASE_URI"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();
    }

    public static RequestSpecification requestSpec(Object payload){

        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getProperty("BASE_URI"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .setBody(payload)
                .build();
    }

    public static RequestSpecification requestSpecwithAuth(){

        return new RequestSpecBuilder()
                .setBaseUri(ConfigManager.getProperty("BASE_URI"))
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addHeader("Authorization",AuthTokenProvider.getToken())
                .build();
    }

    public static ResponseSpecification responseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(1000L))
                .expectStatusCode(200)
                .build();
    }

    public static ResponseSpecification responseSpec_JSON(int statusCode){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(Matchers.lessThan(1000L))
                .expectStatusCode(statusCode)
                .build();
    }

    public static ResponseSpecification responseSpec_TEXT(int statusCode){
        return new ResponseSpecBuilder()
                .registerParser("text/html", Parser.JSON)
                .expectResponseTime(Matchers.lessThan(1000L))
                .expectStatusCode(statusCode)
                .build();
    }
}
