package com.demoqa.spec;

import com.demoqa.tests.BaseTest;
import com.demoqa.helpers.ApiListener;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.config;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;

public class StoreSpec extends BaseTest {
    public static RequestSpecification loginRequestSpec = with()
            .filter(ApiListener.withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON)
            .baseUri(config.baseUrl())
            .basePath("/Account/v1/Login");

    public static ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .build();

    public static RequestSpecification bookAddSpec = with()
            .filter(ApiListener.withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON)
            .baseUri(config.baseUrl())
            .basePath("/BookStore/v1/Books");

    public static ResponseSpecification bookAddResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(201)
            .build();

    public static RequestSpecification bookDeleteRequestSpec = with()
            .filter(ApiListener.withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .contentType(JSON)
            .baseUri(config.baseUrl())
            .basePath("/BookStore/v1/Books");

    public static ResponseSpecification bookDeleteResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .expectStatusCode(204)
            .build();
}
