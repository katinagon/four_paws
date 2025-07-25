package config;

import com.codeborne.selenide.Configuration;
import io.restassured.RestAssured;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.UUID;

public class BaseConfig {
    static String SELENOID_URL = System.getProperty("selenoid.url");
    static String SELENOID_LOGIN = System.getProperty("selenoid.login");
    static String SELENOID_PASSWORD = System.getProperty("selenoid.password");
    public static String baseURI = "https://4lapy.ru";
    public static String apiBaseURI = "https://api.4lapy.ru";
    public static String authEP = "/api/v1/users/customer/auth";
    public static String currentUserEP = "/api/v1/users/current";
    public static String customerCartIdEP = "/api/v1/cart/customerCartId?customerId=";
    public static String cartEP = "/api/v1/cart/cart/";
    public static String authByEmailEP = "/api/auth/authByEmail/";

    private final WebConfig webConfig;

    public BaseConfig(WebConfig webConfig) {
        this.webConfig = webConfig;
    }

    public void setConfig() {
        RestAssured.baseURI = apiBaseURI;
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowser().toString();
        Configuration.browserVersion = webConfig.getBrowserVersion();
        Configuration.browserSize = webConfig.getBrowserSize();

        if (webConfig.isRemote()) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true,
                    "name", "Test: " + UUID.randomUUID()
            ));
            Configuration.remote = webConfig.getRemoteUrl();
            Configuration.browserCapabilities = capabilities;
        }
    }
}
