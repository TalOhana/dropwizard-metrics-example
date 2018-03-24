FROM java:8

WORKDIR /opt/example

COPY DropwizardMetricsExample.java DropwizardMetricsExample.java

EXPOSE 1337-1338

CMD ["java", "-jar", "DropwizardMetricsExample.java", "server", "configuration.yml"]