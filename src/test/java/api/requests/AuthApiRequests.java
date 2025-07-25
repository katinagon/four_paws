package api.requests;

import api.models.LoginEmailRequestModel;

import static api.specs.AuthSpecs.*;
import static config.BaseConfig.authByEmailEP;
import static helpers.TestData.*;
import static io.restassured.RestAssured.given;

public class AuthApiRequests {

    public static void successAuthByEmailRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post(authByEmailEP)
                .then()
                .spec(successAuthByEmailResponseSpec(200, "email"));
    }

    public static void unsuccessAuthWithEmptyEmailRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post(authByEmailEP)
                .then()
                .spec(errorAuthByEmailResponseSpec(400, validationError,
                        validationErrorEmptyEmailMessage));
    }

    public static void unsuccessAuthWithIncorrectEmailOrPasswordRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post(authByEmailEP)
                .then()
                .spec(errorAuthByEmailResponseSpec(400, userUnauthorizedErrorError,
                        userUnauthorizedErrorErrorMessage));
    }

    public static void unsuccessAuthWithEmptyPasswordRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post(authByEmailEP)
                .then()
                .spec(errorAuthByEmailResponseSpec(400, validationError,
                        validationErrorEmptyPasswordMessage));
    }
}
