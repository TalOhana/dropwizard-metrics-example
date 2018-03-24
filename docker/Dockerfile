FROM java:8

WORKDIR /opt/example

COPY DropwizardMetricsExample.jar DropwizardMetricsExample.jar

EXPOSE 1337-1338

CMD ["java", "-jar", "DropwizardMetricsExample.jar", "server", "configuration.yml"]