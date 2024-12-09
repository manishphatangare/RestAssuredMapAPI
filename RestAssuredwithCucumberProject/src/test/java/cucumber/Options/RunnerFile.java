package cucumber.Options;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/FeatureFile",
		glue={"StepDefination"},
//		plugin={"pretty","json:target/cucumber.json"},
				plugin={"pretty","json:target/cucumber.json"},
		tags="@DeletePlace"
		)

public class RunnerFile extends AbstractTestNGCucumberTests{

}
