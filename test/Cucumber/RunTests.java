package Cucumber;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(format = { "pretty", "html:target/cucumber" }, glue = { "test.cps3222.stepdefs" }, features = { "test/resources/features" }, monochrome = true)
public class RunTests {

}
