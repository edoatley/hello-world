package edoatley.scenarios;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:contracts", glue = {"edoatley.scenarios"}, plugin = "pretty", strict = true)
public class CucumberRunner {
}
