package steps;

import com.consol.citrus.annotations.CitrusResource;
import com.consol.citrus.config.CitrusSpringConfig;
import com.consol.citrus.dsl.design.TestDesigner;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.message.MessageType;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

//@SuppressWarnings("SpringJavaAutowiringInspection")
@ContextConfiguration(classes = CitrusSpringConfig.class)
public class PostgresDemoSteps {

    @CitrusResource
    private TestDesigner designer;

    private HttpClient postgresDemoClient;

    @Autowired
    PostgresDemoSteps(HttpClient postgresDemoClient) {
        this.postgresDemoClient = postgresDemoClient;
    }

    @Given("table is empty")
    public void tableIsEmpty() {

        designer.http()
                .client(postgresDemoClient)
                .send()
                .get("/questions")
        ;
    }

    @When("I add entry {string}")
    public void iAddEntry(String arg0) {

//        designer.http()
//                .client("postgresDemoClient")
//                .receive()
//                .response(HttpStatus.OK)
//        ;

    }

    @Then("the number of records should be {int}")
    public void theNumberOfRecordsShouldBe(int arg0) {

        designer.http()
                .client(postgresDemoClient)
                .receive()
                .response(HttpStatus.OK)
                .messageType(MessageType.JSON)
                .validate("$.content[0].id", arg0);

    }
}
