package mobiquity.stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import mobiquity.testBase.Base;
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

        Assert.assertEquals("Status code is verified",expectedStatusCode,response.statusCode());

    }

    @Then("Content type should be {string}")
    public void content_type_should_be(String expectedContentType) {
        String actualContentType=response.contentType();


        Assert.assertEquals("ContentType is verified",expectedContentType,actualContentType);


    }

    @Then("User's information should contain {string}")
    public void user_s_information_should_contain(String name) {

        String respondBody=response.asString();


 // todo assert contain
        Assert.assertTrue("Response body is as expected",respondBody.contains(name));



    }


}
