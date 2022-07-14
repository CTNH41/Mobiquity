package mobiquity.testBase;

import io.restassured.response.Response;
import mobiquity.utilities.ConfigurationReader;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Assert;

import java.util.List;

public class Base {
    public static final  String baseUrl = ConfigurationReader.get("url");
    public Response response;


    public void verifyEmail (List <String> email){


        for (String emails : email) {

            boolean validateEmail= EmailValidator.getInstance().isValid(emails);
            if(validateEmail) {

                Assert.assertTrue("valid email",validateEmail);
                System.out.println("valid email format = " + emails);

            }else {
                Assert.assertFalse("invalid email",validateEmail);
                System.out.println("invalid email format = " + validateEmail);

            }
        }


    }
}
