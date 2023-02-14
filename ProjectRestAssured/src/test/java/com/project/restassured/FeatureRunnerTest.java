package com.project.restassured;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", glue = "com.project.restassured.steps",
        tags = "@wip", dryRun = false, monochrome = true,
        plugin = {"pretty", "json:target/cucumber.json",
                "html:target/cucumber-html-report.html",
                "html:target/cukes.xml"})
public class FeatureRunnerTest {


}
