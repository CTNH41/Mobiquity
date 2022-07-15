package mobiquity.testBase;

import mobiquity.utilities.ConfigurationReader;
import org.apache.commons.validator.routines.EmailValidator;
import org.junit.Assert;
import java.util.List;


public class Base {
    public static final String baseUrl = ConfigurationReader.get("url");


    public void verifyEmail(List<String> emailList) {

        List<Boolean> collect = emailList.stream().map(eachEmail ->
                EmailValidator.getInstance().isValid(eachEmail)).toList();

        Assert.assertFalse("Email verification is", collect.contains(false));


    }
}
