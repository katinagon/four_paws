package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import web.WebTestBase;
import web.pages.MainPage;

import static helpers.TestData.*;

@Owner("goncharova-ek")
@Tags({
        @Tag("authorization"),
        @Tag("authorization-web")
})
@DisplayName("Авторизация пользователя WEB")
public class AuthorizationTests extends WebTestBase {
    MainPage mainPage = new MainPage();

    @Feature("Авторизация пользователя")
    @Story("Успешная авторизация")
    @DisplayName("Успешная авторизация через почту")
    @Test
    public void successAuthorizationByEmailTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setEmailIntoLoginInput(correctEmail)
                .setPasswordIntoPasswordInput(correctPassword)
                .checkSidebarForAuthorizedUser();
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с пустой почтой")
    @Test
    public void unsuccessAuthorizationWithEmptyEmailTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setEmailIntoLoginInput(emptyValue)
                .checkErrorTextWhenEmptyField();
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с неверной/незарегистрированной почтой")
    @Test
    public void unsuccessAuthorizationWithIncorrectEmailTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setEmailIntoLoginInput(incorrectEmail)
                .checkEmailErrorText();
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с пустым паролем")
    @Test
    public void unsuccessAuthorizationWithEmptyPasswordTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setEmailIntoLoginInput(correctEmail)
                .setPasswordIntoPasswordInput(emptyValue)
                .checkErrorTextWhenEmptyField();
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с неверным паролем")
    @Test
    public void unsuccessAuthorizationWithIncorrectPasswordTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setEmailIntoLoginInput(correctEmail)
                .setPasswordIntoPasswordInput(incorrectPassword)
                .checkPopupIncorrectPassword();
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с пустым номером телефона")
    @Test
    public void unsuccessAuthorizationWithIncorrectPhoneNumberTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setPhoneNumber(emptyValue)
                .checkErrorTextWhenEmptyField();
    }

    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с номером телефона из 1-ой добавленной цифры")
    @ParameterizedTest(name="Неуспешная авторизация с номером телефона \"{0}\"")
    @CsvSource(value = {oneDigit, nineDigit})
    public void unsuccessAuthorizationWithEmptyPhoneNumberTest(String phoneNumber) {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setPhoneNumber(phoneNumber)
                .checkErrorTextWhenIncorrectPhoneNumber();
    }
}
