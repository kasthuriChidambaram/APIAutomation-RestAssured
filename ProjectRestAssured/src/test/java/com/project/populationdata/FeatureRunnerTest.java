package com.project.populationdata;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.project.populationdata.steps",
        tags = "@wip", dryRun = false, monochrome = true,
        plugin = {"pretty", "json:target/cucumber.json"})
public class FeatureRunnerTest {


}
