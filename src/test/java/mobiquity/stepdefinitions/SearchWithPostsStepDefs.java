package mobiquity.stepdefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import mobiquity.testBase.Base;
import org.junit.Assert;
import static io.restassured.RestAssured.*;


public class SearchWithPostsStepDefs extends Base {

    private Response response;
    @Given("User send a get request {string}")
    public void userSendsGetRequest(String endPoint) {
        response = given().accept(ContentType.JSON)
                .when().get(baseUrl + endPoint);
        Assert.assertEquals("ContentType is Json","application/json; charset=utf-8",response.contentType());
        Assert.assertEquals("Status code is verified",200,response.statusCode());


    }


    @Then("Verify response body contain {string}")
    public void verify_response_body_contain(String param) {
        Assert.assertTrue("Response body is as expected",response.asString().contains(param));


    }


    @Given("User sets a new url {string} {string}")
    public void user_sets_a_new_url(String param, String query) {

        response = given().accept(ContentType.JSON)
                .when().get(baseUrl + param + "?id=" + query);

        response.prettyPrint();
    }


    @Then("Verify specific {string}")
    public void verify_specific(String bodyTitle) {


        Assert.assertTrue("Body title is as expected",response.asString().contains(bodyTitle));


    }


}
