package mobiquity.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapper;
import io.restassured.response.Response;
import mobiquity.TestBase.Base;
import mobiquity.utilities.ConfigurationReader;
import org.junit.Assert;

import static io.restassured.RestAssured.*;

public class SearchDelphineStepDefs extends Base {



    @Given("User send get request {string}")
    public void userSendGetRequest(String endPoint) {

        response =given().accept(ContentType.JSON)
                .when().get(baseUrl + endPoint);
    }



    @Then("Verify status code should be {int}")
    public void verify_status_code_should_be(int expectedStatusCode) {

        Assert.assertEquals(response.statusCode(),expectedStatusCode);

    }

    @Then("Content type should be {string}")
    public void content_type_should_be(String json) {
        String expectedJson=json;
        System.out.println("expectedJson = " + expectedJson);
        String actualJson=response.contentType();
        System.out.println("actualJson = " + actualJson);

        Assert.assertEquals(json,response.contentType());

    }

    @Then("User's information should contain {string}")
    public void user_s_information_should_contain(String name) {

        String respondBody=response.asString();


 // todo assert contain
        Assert.assertTrue(respondBody.contains(name));



    }


}
