package com.project.restassured.steps;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class RestAssuredIntegrationStepdefs {

    RequestSpecification requestSpecification;
    Response actualResponse;
    JsonPath jsnPath;

    @Given("the user has provided the Nation detail")
    public void thenUserHasGivenTheRequiredParams() {

        //https://datausa.io/api/data?drilldowns=Nation&measures=Population
        requestSpecification = given()
                .baseUri("https://datausa.io/api/")
                .basePath("data")
                .queryParam("drilldowns", "Nation")
                .queryParam("measures", "Population");
    }

    @When("the user has requested the population information")
    public void theUserHasRequestedTheSeasonDetails() {
        actualResponse = requestSpecification.when().get();
    }

    @Then("the system responds with the status code {int}")
    public void theSystemRespondsWithTheSeasonDetails(int expectedStatuscode) {
        Assert.assertEquals("The response code is incorrect", expectedStatuscode, actualResponse.getStatusCode());

    }

    @Then("the system responds with {word} as nation")
    public void theSystemRespondsWithNationAsUnitedStates(String nation) {
        jsnPath = actualResponse.jsonPath();
        List<String> dataList = jsnPath.getList("data.Nation");
        Assert.assertEquals(true, dataList.stream().allMatch(str -> str.equals("United States")));
    }

    @And("the system responds with nations population for the years")
    public void theSystemRespondsWithNationsPopulationForTheYearsAs() {
        List<String> expectedYearList = new ArrayList<>(Arrays.asList("2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013"));
        List<String> actualYearsList = jsnPath.getList("data.Year");
        Assert.assertEquals(true, expectedYearList.equals(actualYearsList));
    }

    @And("the response json contains the source info")
    public void theResponseContainsSource() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        PopulationPojo populationPojo=objectMapper.readValue(actualResponse.asString(),PopulationPojo.class);
        Assert.assertTrue(populationPojo.source.get(0).annotations.source_name.equals("Census Bureau"));
    }


    @And("the response json matches the schema:")
    public void theResponseJsonMatchesTheSchema(String schema) {
        actualResponse.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(schema));
    }


}
