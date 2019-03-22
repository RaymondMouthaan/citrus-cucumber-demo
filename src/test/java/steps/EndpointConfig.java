package steps;

import com.consol.citrus.dsl.endpoint.CitrusEndpoints;
import com.consol.citrus.http.client.HttpClient;
import com.consol.citrus.variable.GlobalVariables;
import org.springframework.context.annotation.*;

@Configuration
@PropertySource("citrus.properties")
public class EndpointConfig {

    @Bean
    public HttpClient postgresDemoClient() {
        return CitrusEndpoints.http()
                .client()
                .requestUrl("http://localhost:8080")
                .build();
    }

    @Bean
    public GlobalVariables globalVariables() {
        GlobalVariables variables = new GlobalVariables();
        variables.getVariables().put("project.name", "Citrus Integration Tests");
        return variables;
    }

}
