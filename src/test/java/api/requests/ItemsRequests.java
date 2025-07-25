package api.requests;

import api.models.ItemsRequestModel;

import static api.specs.BaseSpecs.baseRequestSpec;
import static api.specs.BaseSpecs.baseResponseSpec;
import static api.specs.CartSpecs.сheckEmptyCartResponseSpec;
import static api.specs.CartSpecs.сheckFilledCartResponseSpec;
import static config.BaseConfig.cartEP;
import static helpers.TestData.*;
import static io.restassured.RestAssured.given;

public class ItemsRequests {

    public static void addItemRequest(ItemsRequestModel itemsData) {
        given(baseRequestSpec)
                .headers("Authorization", "Bearer " + token,
                        "channel", "web",
                        "locale", "ru-RU",
                        "poligon", "r600-baza-10-18-do-08-00-18-22-do-16-00",
                        "region", "77")
                .body(itemsData)
                .when()
                .post(cartEP + customerCartId + "/items?customerId=" +
                        customerId)
                .then()
                .spec(baseResponseSpec(204));
    }

    public static void deleteItemRequest() {
        given(baseRequestSpec)
                .headers("Authorization", "Bearer " + token,
                        "channel", "web",
                        "locale", "ru-RU",
                        "poligon", "r600-baza-10-18-do-08-00-18-22-do-16-00",
                        "region", "77")
                .when()
                .delete(cartEP + customerCartId + "/items/" + offerId +
                        "?customerId=" + customerId)
                .then()
                .spec(baseResponseSpec(204));
    }

    public static void checkFilledCartRequest() {
        given(baseRequestSpec)
                .headers("Authorization", "Bearer " + token,
                        "channel", "web",
                        "locale", "ru-RU",
                        "poligon", "r600-baza-10-18-do-08-00-18-22-do-16-00",
                        "region", "77")
                .when()
                .get(cartEP + customerCartId + "/mini?customerId=" +
                        customerId)
                .then()
                .spec(сheckFilledCartResponseSpec(200));
    }

    public static void checkEmptyCartRequest() {
        given(baseRequestSpec)
                .headers("Authorization", "Bearer " + token,
                        "channel", "web",
                        "locale", "ru-RU",
                        "poligon", "r600-baza-10-18-do-08-00-18-22-do-16-00",
                        "region", "77")
                .when()
                .get(cartEP + customerCartId + "/mini?customerId=" +
                        customerId)
                .then()
                .spec(сheckEmptyCartResponseSpec(200));
    }
}
