package api;

import config.*;
import helpers.HelperAPI;
import org.junit.jupiter.api.BeforeAll;

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
}
