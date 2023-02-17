package api;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class TestAPI {
    @Test
    public void postPetInStore() {
        String body = "{ \"id\": 555, \"category\": { \"id\": 555, \"name\": \"qui non et in\" }, \"name\": \"Camel\", \"photoUrls\": [ \"dolor nostrud\", \"est occaecat elit\" ], \"tags\": [ { \"id\": 5, \"name\": \"Camel\" }, { \"id\": 5, \"name\": \"Bob\" } ], \"status\": \"not available\" }";
        Response response = given().when().contentType(ContentType.JSON).body(body).post("https://petstore.swagger.io/v2/pet");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertAll();

    }

    @Test
    public void getPetByID() {
        Response response = given().when().get("https://petstore.swagger.io/v2/pet/555");
        String responses = response.getBody().asString();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
        softAssert.assertTrue(responses.contains("Bob"));
        softAssert.assertAll();
    }

    @Test(dependsOnMethods = {"postPetInStore"})
    public void deletePetFromStore() {
        Response response = given().when().delete("https://petstore.swagger.io/v2/pet/555");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(response.getStatusCode(), 200);
    }
}
