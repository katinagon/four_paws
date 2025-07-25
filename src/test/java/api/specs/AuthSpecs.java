package api.specs;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static helpers.CustomAllureListener.withCustomTemplates;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.*;

public class AuthSpec {
    public static RequestSpecification authRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .log().headers()
            .contentType(JSON);

    public static ResponseSpecification authResponseSpec(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(expectedStatusCode)
                .build();
    }

    public static RequestSpecification authByEmailRequestSpec = with()
            .filter(withCustomTemplates())
            .log().uri()
            .log().method()
            .log().body()
            .log().headers()
            .contentType(JSON);

    public static ResponseSpecification authByEmailResponseSpec(int expectedStatusCode) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(expectedStatusCode)
                .build();
    }

    // Для позитивного теста
    public static ResponseSpecification successAuthByEmailResponseSpec(int expectedStatusCode, String type) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(expectedStatusCode)
                .expectBody("type", equalTo(type))
                .expectBody("token", notNullValue())
                .build();
    }

    // Для негативного теста
    public static ResponseSpecification errorAuthByEmailResponseSpec(int expectedStatusCode,
                                                                     String applicationErrorCode, String message) {
        return new ResponseSpecBuilder()
                .log(STATUS)
                .log(BODY)
                .expectStatusCode(expectedStatusCode)
                .expectBody("error.applicationErrorCode", equalTo(applicationErrorCode))
                .expectBody("error.message", containsString(message))
                .expectBody("error.x_b3_traceid", notNullValue())
                .build();
    }
}
