package mobiquity.TestBase;

import io.restassured.response.Response;
import mobiquity.utilities.ConfigurationReader;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.List;

public class Base {
    public static final  String baseUrl = ConfigurationReader.get("url");
    public Response response;


    public void verifyEmail (List <String> email){

        for (String emails : email) {
            System.out.println("email = " + email);
            boolean valid= EmailValidator.getInstance().isValid(emails);
            System.out.println("valid = " + valid);

        }
    }
}
