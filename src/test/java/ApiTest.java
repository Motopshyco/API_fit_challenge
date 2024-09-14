import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.restassured.RestAssured.when;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.*;


public class ApiTest extends BaseTest {

    @Test
    public void validateSuccessfulResponse(){
        when()
                .get("US")
                .then()
                .statusCode(200)
                .and()
                .body("name.common", contains("United States"));
    }

    @Test
    public void validateResponseStructure(){
        when()
                .get("CA")
                .then()
                .statusCode(200)
                .and()
                .assertThat()
                .body(matchesJsonSchemaInClasspath("apiKeySchema.json"));
    }

    @ParameterizedTest
    @CsvSource({
            "GB, London",
            "FR, Paris",
            "JP, Tokyo"
    })
    public void dataDrivenTest(String country, String capital){
        when()
                .get(country)
                .then()
                .statusCode(200)
                .and()
                .body("[0].capital[0]", equalTo(capital));
    }

    @Test
    public void negativeTest(){
        when()
                .get("XYZ")
                .then()
                .statusCode(404)
                .and()
                .body("message", containsString("Not Found"));
    }
}
