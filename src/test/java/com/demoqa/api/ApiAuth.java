package com.demoqa.api;

import com.demoqa.models.LoginBodyModel;
import com.demoqa.models.LoginResponseModel;
import io.qameta.allure.Step;

import static com.demoqa.spec.StoreSpec.loginRequestSpec;
import static com.demoqa.spec.StoreSpec.loginResponseSpec;
import static io.restassured.RestAssured.given;

public class ApiAuth {
    @Step("Authorization")
    public static LoginResponseModel successfulAuthorisation(String login, String password) {

        LoginBodyModel userCredentials = new LoginBodyModel();
        userCredentials.setUserName(login);
        userCredentials.setPassword(password);

        return
                given(loginRequestSpec)
                        .body(userCredentials)
                        .when()
                        .post()
                        .then()
                        .spec(loginResponseSpec)
                        .extract().as(LoginResponseModel.class);
    }
}
