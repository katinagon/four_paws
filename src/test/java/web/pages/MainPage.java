package web.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private final SelenideElement profileIcon = $("#nav_menu_profile"),
            btnLoginByEmail = $("#id_login_by_email"),
            inputLoginEmail = $("#id_login_email_input"),
            btnContinueLogin = $("#id_login_continue_button"),
            inputLoginPassword = $("#id_login_password_input"),
            userSidebar = $(".UserSidebar_profileDropdownWrapper__OR5ez"),
            spanErrorField = $(".ErrorIcon_text__feNrN"),
            divEmailErrorText = $(".Auth_emailErrorText__wAtd3"),
            popupIncorrectPassword = $(".uppercase-first"),
            inputPhoneLogin = $("#id_login_phone_input");

    @Step("Открытие главной страницы сайта")
    public MainPage openPage() {
        open("");
        return this;
    }

    @Step("Открываем поп-ап регистрации/авторизации")
    public MainPage openAuthorizationPopUp() {
        profileIcon.shouldBe(visible, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Ввод номера телефона для авторизации")
    public MainPage setPhoneNumber(String userPhoneNumber) {
        inputPhoneLogin.setValue(userPhoneNumber);
        btnContinueLogin.click();
        return this;
    }

    @Step("Ввод почты для авторизации")
    public MainPage setEmailIntoLoginInput(String userEmail) {
        btnLoginByEmail.click();
        inputLoginEmail.setValue(userEmail);
        btnContinueLogin.click();
        return this;
    }

    @Step("Ввод пароля для авторизации")
    public MainPage setPasswordIntoPasswordInput(String userPassword) {
        inputLoginPassword.setValue(userPassword);
        btnContinueLogin.click();
        return this;
    }

    @Step("Проверка сайдбара у авторизованного пользователя")
    public MainPage checkSidebarForAuthorizedUser() {
        profileIcon.click();
        userSidebar.shouldBe(visible);
        return this;
    }

    @Step("Проверка текста ошибки при незаполненном поле")
    public MainPage checkErrorTextWhenEmptyField() {
        spanErrorField.shouldHave(text("Обязательное для заполнения поле"));
        return this;
    }

    @Step("Проверка текста ошибки при неверном формате номера телефона")
    public MainPage checkErrorTextWhenIncorrectPhoneNumber() {
        spanErrorField.shouldHave(text("Неверный формат телефона прим: +7 (999) 999-99-99"));
        return this;
    }

    @Step("Проверка текста ошибки при неверной/незарегистрированной почте")
    public MainPage checkEmailErrorText() {
        divEmailErrorText.shouldHave(text("Адрес эл. почты введен неверно или не зарегистрирован"));
        return this;
    }

    @Step("Проверка всплывающего окошка об ошибке пароля")
    public MainPage checkPopupIncorrectPassword() {
        popupIncorrectPassword.shouldHave(text("Неверный email или пароль. Попробуйте еще раз"));
        return this;
    }
}
