package dropwizard.metrics.example.resources;

import com.codahale.metrics.Counter;
import com.codahale.metrics.Meter;
import com.codahale.metrics.MetricRegistry;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.Optional;

@Path("/greet")
public class GreetingsResource {
    private Counter greetingsCounter;
    private Meter greetingsMeter;

    @Inject
    public GreetingsResource(MetricRegistry metrics) {
        this.greetingsCounter = metrics.counter("GreetingsCounter");
        this.greetingsMeter = metrics.meter("GreetingsMeter");
    }

    @GET
    public String greet(@QueryParam("person") Optional<String> person) {
        greetingsCounter.inc();
        greetingsMeter.mark();
        return String.format("Greetings %s!", person.orElse("Stranger"));
    }

}
