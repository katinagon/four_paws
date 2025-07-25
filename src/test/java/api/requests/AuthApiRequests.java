package api.requests;

import api.models.AuthResponseModel;
import api.models.LoginEmailRequestModel;

import static api.specs.AuthSpec.*;
import static helpers.TestData.*;
import static io.restassured.RestAssured.given;

public class AuthApiRequests {

    public static AuthResponseModel authRequest() {
        return given(authRequestSpec)
                .headers("accept", "application/json, text/plain, */*",
                        "accept-language", "ru-RU,ru;q=0.9,en-US;q=0.8,en;q=0.7",
                        "channel", "web",
                        "locale", "ru-RU",
                        "origin", "https://4lapy.ru",
                        "poligon", "r600-baza-10-18-do-08-00-18-22-do-16-00",
                        "priority", "u=1, i",
                        "referer", "https://4lapy.ru/",
                        "region", "77",
                        "sec-ch-ua", "\"Not)A;Brand\";v=\"8\", \"Chromium\";v=\"138\", \"Google Chrome\";v=\"138\"",
                        "sec-ch-ua-mobile", "?0",
                        "sec-ch-ua-platform", "\"Windows\"",
                        "sec-fetch-dest", "empty",
                        "sec-fetch-mode", "cors",
                        "sec-fetch-site", "same-site",
                        "user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/138.0.0.0 Safari/537.36")
                .when()
                .post("https://api.4lapy.ru/api/v1/users/customer/auth")
                .then()
                .spec(authResponseSpec(200))
                .extract().as(AuthResponseModel.class);
    }

    public static void successAuthByEmailRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post("https://4lapy.ru/api/auth/authByEmail/")
                .then()
                .spec(successAuthByEmailResponseSpec(200, "email"));
    }

    public static void unsuccessAuthWithEmptyEmailRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post("https://4lapy.ru/api/auth/authByEmail/")
                .then()
                .spec(errorAuthByEmailResponseSpec(400, validationError,
                        validationErrorEmptyEmailMessage));
    }

    public static void unsuccessAuthWithIncorrectEmailRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post("https://4lapy.ru/api/auth/authByEmail/")
                .then()
                .spec(errorAuthByEmailResponseSpec(400, userUnauthorizedErrorError,
                        userUnauthorizedErrorErrorMessage));
    }

    public static void unsuccessAuthWithEmptyPasswordRequest(LoginEmailRequestModel authByEmailData) {
        given(authByEmailRequestSpec)
                .body(authByEmailData)
                .when()
                .post("https://4lapy.ru/api/auth/authByEmail/")
                .then()
                .spec(errorAuthByEmailResponseSpec(400, validationError,
                        validationErrorEmptyPasswordMessage));
    }
}
