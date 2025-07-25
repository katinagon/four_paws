package api;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.BaseConfig;
import config.WebConfig;
import config.WebProvider;
import helpers.LoginExtension;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class BaseApiTest {
    public static final WebConfig webConfig = WebProvider.getWebConfig();

    @BeforeAll
    public static void setupBaseTestConfiguration() {
        BaseConfig baseConfig = new BaseConfig(webConfig);
        baseConfig.setConfig();
        LoginExtension loginExtension = new LoginExtension();
        loginExtension.getToken();
        loginExtension.getCustomerId();
        loginExtension.getCustomerCartId();
    }

    @BeforeEach
    public void setupAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
