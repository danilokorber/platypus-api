package io.easyware.platypus.api;

import io.easyware.platypus.api.fin.objects.CostCenter;
import io.easyware.platypus.util.MySqlTestResource;
import io.restassured.response.ValidatableResponse;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import io.restassured.http.ContentType;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

@QuarkusTest
@TestSecurity(user = "danilo@korber.com.br", roles = {"8937c19c-aff7-413f-87d7-82234a0fe02b"})
class FinIT {

    @ConfigProperty(name = "quarkus.resteasy.path")
    String restPath;

    @Test
    void testGetCostCenters() {
        getValidatableResponse("/cost_centers?domain_id=1")
                .assertThat().body("size()", is(7));
    }

    @Test
    void testGetExpenses() {
        getValidatableResponse("/expenses?domain_id=1")
                .assertThat().body("size()", is(1));
    }

    private ValidatableResponse getValidatableResponse (String route) {
        return given().when()
                .get(restPath + "/fin" + route)
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
