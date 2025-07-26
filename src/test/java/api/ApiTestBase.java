package api;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.BaseConfig;
import config.WebConfig;
import config.WebProvider;
import helpers.HelperAPI;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class ApiTestBase {
    public static final WebConfig webConfig = WebProvider.getWebConfig();

    @BeforeAll
    public static void setupBaseTestConfiguration() {
        BaseConfig baseConfig = new BaseConfig(webConfig);
        baseConfig.setConfig();
        HelperAPI helperAPI = new HelperAPI();
        helperAPI.getToken();
        helperAPI.getCustomerId();
        helperAPI.getCustomerCartId();
    }

    @BeforeEach
    public void setupAllureListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }
}
