package mobiquity.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mobiquity.TestBase.Base;
import mobiquity.utilities.ConfigurationReader;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class SearchWithPostsStepDefs extends Base {


    @Given("User send a get request {string}")
    public void userSendsGetRequest(String endPoint) {
        response = given().accept(ContentType.JSON)
                .when().get(baseUrl + endPoint);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        Assert.assertEquals(response.statusCode(),200);


    }


    @Then("Verify response body contain {string}")
    public void verify_response_body_contain(String param) {
        Assert.assertTrue(response.asString().contains(param));


    }


    @Given("User sets a new url {string} {string}")
    public void user_sets_a_new_url(String param, String query) {

        response = given().accept(ContentType.JSON)
                .when().get(baseUrl + param + "?id=" + query);

        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");
        Assert.assertEquals(response.statusCode(),200);
        response.prettyPrint();
    }


    @Then("Verify specific {string}")
    public void verify_specific(String bodyTitle) {

        System.out.println("============================================");
        Assert.assertTrue(response.asString().contains(bodyTitle));


    }


}
