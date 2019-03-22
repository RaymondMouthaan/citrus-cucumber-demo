import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        plugin = {
                "com.consol.citrus.cucumber.CitrusReporter",
                "pretty",
                "html:target/cucumber-reports",
                "json:target/cucumber-reports/cucumber.json"
        }
)
public class PostgresDemoFeatureIT {
}
