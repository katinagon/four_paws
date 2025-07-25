package api.tests;

import api.BaseApiTest;
import api.models.LoginDataModel;
import api.models.LoginEmailRequestModel;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.restassured.RestAssured;
import org.junit.jupiter.api.*;

import static api.requests.AuthApiRequests.*;
import static com.codeborne.selenide.logevents.SelenideLogger.step;
import static config.BaseConfig.baseURI;
import static helpers.TestData.*;

@Owner("goncharova-ek")
@Tag("authorization-api")
@DisplayName("Авторизация пользователя")
public class AuthorizationTests extends BaseApiTest {

    @BeforeAll
    public static void setBaseURI() {
        RestAssured.baseURI = baseURI;
    }

    @Feature("Авторизация пользователя")
    @Story("Успешная авторизация")
    @DisplayName("Успешная авторизация через почту")
    @Test
    public void successAuthorizationByEmailAPITest() {
        LoginDataModel loginData = new LoginDataModel(correctEmail, correctPassword);
        LoginEmailRequestModel loginEmailRequestModel = new LoginEmailRequestModel(loginData, token);

        step("Авторизация через почту", () ->
                successAuthByEmailRequest(loginEmailRequestModel));
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с пустой почтой")
    @Test
    public void unsuccessAuthorizationWithEmptyEmailAPITest() {
        LoginDataModel loginData = new LoginDataModel(emptyValue, correctPassword);
        LoginEmailRequestModel loginEmailRequestModel = new LoginEmailRequestModel(loginData, token);

        step("Авторизация c пустой почтой", () ->
                unsuccessAuthWithEmptyEmailRequest(loginEmailRequestModel));
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с неверной/незарегистрированной почтой")
    @Test
    public void unsuccessAuthorizationWithIncorrectEmailAPITest() {
        LoginDataModel loginData = new LoginDataModel(incorrectEmail, correctPassword);
        LoginEmailRequestModel loginEmailRequestModel = new LoginEmailRequestModel(loginData, token);

        step("Авторизация c незарегистрированной почтой", () ->
                unsuccessAuthWithIncorrectEmailOrPasswordRequest(loginEmailRequestModel));
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с пустым паролем")
    @Test
    public void unsuccessAuthorizationWithEmptyPasswordAPITest() {
        LoginDataModel loginData = new LoginDataModel(correctEmail, emptyValue);
        LoginEmailRequestModel loginEmailRequestModel = new LoginEmailRequestModel(loginData, token);

        step("Авторизация c пустым паролем", () ->
                unsuccessAuthWithEmptyPasswordRequest(loginEmailRequestModel));
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с неверным паролем")
    @Test
    public void unsuccessAuthorizationWithIncorrectPasswordAPITest() {
        LoginDataModel loginData = new LoginDataModel(correctEmail, incorrectPassword);
        LoginEmailRequestModel loginEmailRequestModel = new LoginEmailRequestModel(loginData, token);

        step("Авторизация c с неверным паролем", () ->
                unsuccessAuthWithIncorrectEmailOrPasswordRequest(loginEmailRequestModel));
    }
}
