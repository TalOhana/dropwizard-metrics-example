package dropwizard.metrics.example;

import dropwizard.metrics.example.modules.MetricsModule;
import io.dropwizard.Application;
import io.dropwizard.configuration.ResourceConfigurationSourceProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

public class GreetingApplication extends Application<GreetingConfiguration> {

    public static void main(String[] args) throws Exception {
        new GreetingApplication().run(args);
    }

    @Override
    public void initialize(Bootstrap<GreetingConfiguration> bootstrap) {
        bootstrap.setConfigurationSourceProvider(new ResourceConfigurationSourceProvider());

        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .useWebInstallers()
                .modules(new MetricsModule())
                .build());
    }

    public void run(GreetingConfiguration configuration, Environment environment) {
        // Autoscan enabled, no need to do anything here
    }
}
