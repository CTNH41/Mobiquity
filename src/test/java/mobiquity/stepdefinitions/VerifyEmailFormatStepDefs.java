package mobiquity.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import mobiquity.testBase.Base;
import org.junit.Assert;

import java.util.List;

import static io.restassured.RestAssured.*;

public class VerifyEmailFormatStepDefs extends Base {


    @Given("User sends get request {string}")
    public void user_sends_get_request(String endPoint) {

        response = given().accept(ContentType.JSON)
                .when().get(baseUrl + endPoint);
        Assert.assertEquals("Status code is verified", 200, response.statusCode());
        Assert.assertEquals("ContentType is Json","application/json; charset=utf-8", response.contentType() );


    }


    @Then("User validates the email format")
    public void userValidatesTheEmailFormat() {
        JsonPath jsonPath = response.jsonPath();
        List<String> emails = jsonPath.getList("email");
        // this method comes from Base class under Test base package
        verifyEmail(emails);


    }
}
