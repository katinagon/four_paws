package api.requests;

import api.models.AuthResponseModel;
import api.models.CustomerCartIdResponseModel;
import api.models.CurrentUserResponseModel;

import static api.specs.BaseSpecs.baseRequestSpec;
import static api.specs.BaseSpecs.baseResponseSpec;
import static config.BaseConfig.*;
import static helpers.TestData.customerId;
import static helpers.TestData.token;
import static io.restassured.RestAssured.given;

public class HelpersRequests {

    public static AuthResponseModel getTokenRequest() {
        return given(baseRequestSpec)
                .headers("channel", "web",
                        "locale", "ru-RU",
                        "poligon", "r600-baza-10-18-do-08-00-18-22-do-16-00",
                        "region", "77")
                .when()
                .post(authEP)
                .then()
                .spec(baseResponseSpec(200))
                .extract().as(AuthResponseModel.class);
    }

    public static CurrentUserResponseModel getCustomerIdRequest() {
        return given(baseRequestSpec)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(currentUserEP)
                .then()
                .spec(baseResponseSpec(200))
                .extract().as(CurrentUserResponseModel.class);
    }

    public static CustomerCartIdResponseModel getCustomerCartIdRequest() {
        return given(baseRequestSpec)
                .header("Authorization", "Bearer " + token)
                .when()
                .get(customerCartIdEP + customerId)
                .then()
                .spec(baseResponseSpec(200))
                .extract().as(CustomerCartIdResponseModel.class);
    }
}
