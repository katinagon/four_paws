package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

import static helpers.TestData.offerId;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static org.hamcrest.Matchers.equalTo;

public class CartSpecs {

    public static ResponseSpecification сheckFilledCartResponseSpec(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(expectedStatusCode)
                .expectBody(
                        String.format("items.find { it.offerId == '%s' }.offerId", offerId),
                        equalTo(offerId)
                )
                .build();
    }

    public static ResponseSpecification сheckEmptyCartResponseSpec(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(expectedStatusCode)
                .expectBody(
                        "items.findAll { it.offerId == '%s' }.size()", equalTo(0)
                )
                .build();
    }
}
