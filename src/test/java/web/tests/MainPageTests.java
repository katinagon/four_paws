package web.tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.BaseWebTest;
import web.pages.MainPage;

import static helpers.TestData.*;

@Owner("goncharova-ek")
@Tag("main_page")
@DisplayName("Тесты главной страницы сайта")
public class MainPageTests extends BaseWebTest {
    MainPage mainPage = new MainPage();

    @Tag("authorization")
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

    @Tag("authorization")
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

    @Tag("authorization")
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

    @Tag("authorization")
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

    @Tag("authorization")
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

    @Tag("authorization")
    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с пустым номером телефона")
    @Test
    public void unsuccessAuthorizationWithEmptyPhoneNumberTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setPhoneNumber(emptyValue)
                .checkErrorTextWhenEmptyField();
    }

    @Tag("authorization")
    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с номером телефона из 1-ой добавленной цифры")
    @Test
    public void unsuccessAuthorizationByPhoneNumberWithOneDigitTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setPhoneNumber(oneDigit)
                .checkErrorTextWhenIncorrectPhoneNumber();
    }

    @Tag("authorization")
    @Feature("Авторизация пользователя")
    @Story("Неуспешная авторизация")
    @DisplayName("Неуспешная авторизация с номером телефона из 9-ти добавленных цифр")
    @Test
    public void unsuccessAuthorizationByPhoneNumberWithNineDigitsTest() {
        mainPage.openPage()
                .openAuthorizationPopUp()
                .setPhoneNumber(nineDigit)
                .checkErrorTextWhenIncorrectPhoneNumber();
    }
}
