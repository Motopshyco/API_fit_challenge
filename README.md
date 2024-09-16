# **Api Challenge with RestAssured**

This is a framework to test the rest counties API and here are the considerations in the test scenarios:

## Dependencies:

- org.junit.jupiter version 5.8.1
- io.rest-assured version 4.4
- webdrivermanager version 5.5.0
- org.hamcrest version 1.3

## Considerations:
The **BaseTest.java** is the class with all the basics to run test cases for the countries REST API, after that we can create different test classes extending this class, in this example we have the **ApiTest.java** with 4 different scenarios and each one of them has its endpoint but the baseURI is the same and is defined in **BaseTest.java**. Also in this class we defined the filters to log our request, the response and any error in case that we have one, Finally I set the contentType as a json just in case that we need to send a body for another type of request.

Each scenario is defined using gherkin syntax, and I don't have a "**Given**" step because all the tests are get requests and there are no preconditions to define here. The "**When**" step is where I run the HTTP GET request, and for "**Then**" step I defined the assertion to check if the status code of the response is the expected, also I defined an "**And**" step to add another assertion, in the first scenario we check if the name contains "United States" as is expected,for the second scenario we check if the response contains the name, capital and region of the country based in the JSONSchema added in the apiKeySchema file, for the third one I defined 3 different values to use the API in a CSV source and validate the capital of each one, and for last one we check if the message error says "Not Found".

Mateo Stiven Florez Echavarria.