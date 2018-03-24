package dropwizard.metrics.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

public class GreetingConfiguration extends Configuration {
    @NotEmpty
    private String graphiteHost;

    private int graphitePort;

    @JsonProperty
    public String getGraphiteHost() {
        return graphiteHost;
    }

    @JsonProperty
    public void setGraphiteHost(String graphiteHost) {
        this.graphiteHost = graphiteHost;
    }

    @JsonProperty
    public int getGraphitePort() {
        return graphitePort;
    }

    @JsonProperty
    public void setGraphitePort(int graphitePort) {
        this.graphitePort = graphitePort;
    }
}
