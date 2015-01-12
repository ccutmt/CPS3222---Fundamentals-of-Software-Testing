	package Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@SuppressWarnings("deprecation")
@RunWith(Cucumber.class)
@Cucumber.Options(format = { "pretty", "html:target/cucumber" }, glue = { "Cucumber.stepdefs" }, features = { "test/resources/features/resources.feature" }, monochrome = true)
public class RunTests {

}
