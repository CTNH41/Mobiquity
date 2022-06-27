package mobiquity.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mobiquity.TestBase.Base;
import mobiquity.utilities.ConfigurationReader;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class InvalidRequestStepDefs extends Base {



    @When("the user sends invalid request {string}")
    public void the_user_sends_invalid_request(String invalidRequest) {
        response =given().accept(ContentType.JSON)
                .when().get(baseUrl + invalidRequest);
        Assert.assertEquals(response.contentType(),"application/json; charset=utf-8");



    }

    @Then("Status code should be {int}")
    public void status_code_should_be(int statusCode) {

        Assert.assertEquals(response.statusCode(),statusCode);


    }

}
