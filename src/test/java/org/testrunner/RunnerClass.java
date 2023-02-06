package org.testrunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features ="C:\\Users\\PC\\eclipse-workspace\\Cucumber\\src\\test\\resources\\FeatureFile", glue = "org.stepdefination", dryRun =false, strict = true)
public class RunnerClass {

}
