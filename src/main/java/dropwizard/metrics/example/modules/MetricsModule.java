package dropwizard.metrics.example.modules;

import com.codahale.metrics.MetricFilter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.graphite.Graphite;
import com.codahale.metrics.graphite.GraphiteReporter;
import dropwizard.metrics.example.GreetingConfiguration;
import ru.vyarus.dropwizard.guice.module.support.DropwizardAwareModule;

import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;

public class MetricsModule extends DropwizardAwareModule<GreetingConfiguration> {
    protected void configure() {
        final Graphite graphite = new Graphite(new InetSocketAddress(configuration().getGraphiteHost(), configuration().getGraphitePort()));

        final GraphiteReporter reporter = GraphiteReporter.forRegistry(environment().metrics())
                .prefixedWith("greetings")
                .convertRatesTo(TimeUnit.SECONDS)
                .convertDurationsTo(TimeUnit.MILLISECONDS)
                .filter(MetricFilter.ALL)
                .build(graphite);

        reporter.start(5, TimeUnit.SECONDS);

        bind(MetricRegistry.class).toInstance(environment().metrics());
    }
}
