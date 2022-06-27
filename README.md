Cucumber BDD Framework

Git Clone :https://github.com/CTNH41/mobiquity.git
To launch the API with root address http://localhost:3000/


installation

add Rest-Assured Dependency for API Test
<dependency>
<groupId>io.rest-assured</groupId>
<artifactId>rest-assured</artifactId>
<version>4.3.2</version>
<scope>test</scope>
</dependency>

Add Gson Dependency Gson is a Java library that can be used to convert Java Objects into their JSON representation.
<dependency>
<groupId>com.google.code.gson</groupId>
<artifactId>gson</artifactId>
<version>2.8.6</version>
</dependency>

Add selenium Dependency for automation test
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>3.141.59</version>
</dependency>

Add Bonigarcia Dependency Automated driver management and Docker builder for Selenium WebDriver
<dependency>
<groupId>io.github.bonigarcia</groupId>
<artifactId>webdrivermanager</artifactId>
<version>4.1.0</version>
</dependency>

Add Cucumber java and junit for cucumber BDD

<dependency>
<groupId>io.cucumber</groupId>
<artifactId>cucumber-java</artifactId>
<version>5.7.0</version>
</dependency>

  <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
             <version>5.7.0</version>
            <scope>test</scope>
        </dependency>


Add commons-validator Dependency for validate email format

 <dependency>
            <groupId>commons-validator</groupId>
            <artifactId>commons-validator</artifactId>
            <version>1.4.1</version>
        </dependency>






Example for Mobiquity API Test at https://jsonplaceholder.typicode.com/.


Examples

Feature:Search Delphine

@US-1 Scenario Outline:Searching with username

    Given User send get request "<endPoint>"
    Then Verify status code should be 200
    Then Content type should be "application/json; charset=utf-8"
    Then User's information should contain "<name>"


    Examples:
      | endPoint | name     |
      | users    | Delphine |

Feature: Search with Posts

@Us-2 Scenario Outline:
Given User send a get request "posts"
Then Verify response body contain "<param>"

    Examples:
      | param  |
      | userId |
      | id     |
      | title  |
      | body   |

Scenario Outline: Verify Specific idNumber Given User sets a new url "posts" "<idNumber>"

    Then Verify specific "<bodyTitle>"
    Examples:
      | idNumber | bodyTitle                   |
      | 7        | magnam facilis autem        |
      | 10       | optio molestias id quia eum |
      | 15       | eveniet quod temporibus     |

Feature: Send comment request

Scenario:Verify Email Format Given User sends get request "comments"
Then User validates the email format

Feature: Invalid Test Coverage @US-4 Scenario Outline: Negative Test Coverages When the user sends invalid
request "<invalidEndPoint>"
Then Status code should be 404

    Examples: | invalidEndPoint|
    |post            |
    |comment         |
    |album           |
    |photo           |
    |todo            |
    |user            |

Add a Cucumber Runner Class

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"json:target/cucumber.json",
"html:target/default-html-reports"}, features = "src/test/resources/features", glue = "mobiquity/stepdefinitions",
dryRun = false, tags = "@US-1"
)
public class CukesRunner {

}

Add .feature files under features folder In my .feature file I have access to all steps defined in the stepdefinitions

Add step definition package I hold my codes in related class

Add Test Base package Base class contains baseUrl object , respond object and method

Add Utilities package ConfigurationReader class is created to read data which is in configuration.properties file







