package mobiquity.stepdefinitions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mobiquity.testBase.Base;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class InvalidRequestStepDefs extends Base {

    private Response response;

    @When("the user sends invalid request {string}")
    public void the_user_sends_invalid_request(String invalidRequest) {
        response =given().accept(ContentType.JSON)
                .when().get(baseUrl + invalidRequest);

        String expectedContentType="application/json; charset=utf-8";
        String actualContentType=response.contentType();
        Assert.assertEquals("Content Type is verified",expectedContentType,actualContentType);



    }

    @Then("Status code should be {int}")
    public void status_code_should_be(int statusCode) {

        Assert.assertEquals("Status code is as expected",statusCode,response.statusCode());


    }

}
