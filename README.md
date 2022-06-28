#Cucumber/BDD Testing for REST APIs

-Git Clone :https://github.com/CTNH41/mobiquity.git
-To launch the API with root address http://localhost:3000/
-Running with Docker

## API Testing Vocabulary
Flow To Be Tested

-Search for the user with username"Delphine"
-Use the details fetched to make a search for the posts written by the user
-For each post, fetch the comments and validate if the emails in the comment section are in the proper format
-think of various scenario for the test workflow, all the things that can go wrong.
Add them to test coverage


##Installation

Added Rest-Assured Dependency for API Test
```bash
<dependency>
<groupId>io.rest-assured</groupId>
<artifactId>rest-assured</artifactId>
<version>4.3.2</version>
<scope>test</scope>
</dependency>
```
Added Gson Dependency Gson is a Java library that can be used to convert Java Objects into their JSON representation.
```bash
<dependency>
<groupId>com.google.code.gson</groupId>
<artifactId>gson</artifactId>
<version>2.8.6</version>
</dependency>
```

Added selenium Dependency for automation test
```bash
<dependency>
<groupId>org.seleniumhq.selenium</groupId>
<artifactId>selenium-java</artifactId>
<version>3.141.59</version>
</dependency>
```

Added Bonigarcia Dependency Automated driver management and Docker builder for Selenium WebDriver
```bash
<dependency>
<groupId>io.github.bonigarcia</groupId>
<artifactId>webdrivermanager</artifactId>
<version>4.1.0</version>
</dependency>
```
Add Cucumber java and junit for cucumber BDD
```bash
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
  ```

Add commons-validator Dependency for validate email format
  ```bash
   <dependency>
            <groupId>commons-validator</groupId>
            <artifactId>commons-validator</artifactId>
            <version>1.4.1</version>
</dependency>
```

##Extending the vocabulary

-Feature file contains the scenario which is written in Gherkin language.

-Step definitions class is the translated version of scenario in Java language.

-Runner classes which is related the feature files and corresponding step definitions classes to run the test code.
CukesRunner
```bash

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/cucumber.json",
                "html:target/default-html-reports"},
        features = "src/test/resources/features",
        glue = "mobiquity/stepdefinitions",
        dryRun = false
//      tags = "@TC_API_001"



)
public class CukesRunner {

}
```
FailedCukesRunner
```bash
@RunWith(Cucumber.class)
@CucumberOptions(


        plugin={"html:target/failed-html-report"},
        features = "src/test/resources/features",
        glue = "mobiquity/stepdefinitions"


)

public class FailedTestRunner {
}
```
-

-Testbase is created to store common atribute, methods

-Utilities/Configuration.Reader class to translate the key and values provided in the
-Configuration.properties file into Java. These are the browser to interact, the web page to navigate and the login credentials to login.

-My framework supports Data-Driven testing because of Scenario Outline annotation.






##Examples

Example for Mobiquity API Test at https://jsonplaceholder.typicode.com/.

```bash
Feature:Search Delphine

@US-1 Scenario Outline:Searching with username

    Given User send get request "<endPoint>"
    Then Verify status code should be 200
    Then Content type should be "application/json; charset=utf-8"
    Then User's information should contain "<name>"


    Examples:
      | endPoint | name     |
      | users    | Delphine |

```
```bash
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

Scenario Outline: Verify Specific idNumber 
Given User sets a new url "posts" "<idNumber>"

    Then Verify specific "<bodyTitle>"
    Examples:
      | idNumber | bodyTitle                   |
      | 7        | magnam facilis autem        |
      | 10       | optio molestias id quia eum |
      | 15       | eveniet quod temporibus     |
```
```bash
Feature: Send comment request

Scenario:Verify Email Format 
Given User sends get request "comments"
Then User validates the email format

```

```bash

Feature: Invalid Test Coverage @US-4 

Scenario Outline: Negative Test Coverages 

When the user sends invalid request "<invalidEndPoint>"
Then Status code should be 404

    Examples: | invalidEndPoint|
    |post            |
    |comment         |
    |album           |
    |photo           |
    |todo            |
    |user            |
    ```
```




































